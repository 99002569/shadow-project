package com.lnt.taskto_do;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {table1.class, table2.class}, version = 1)
public abstract class Room_Database extends RoomDatabase {
    private static Room_Database instance;
    public abstract table1Dao Dao1();
    public abstract  table2Dao Dao2();
    public static synchronized Room_Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Room_Database.class, "room_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private table1Dao Dao1 ;
        private table2Dao Dao2;
        private PopulateDbAsyncTask(Room_Database db) {
            Dao1 = db.Dao1();
            Dao2 = db.Dao2();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            Dao1.insert(new table1("Name1"));
            Dao1.insert(new table1("Name2"));
            Dao1.insert(new table1("Name3"));

            Dao2.insert(new table2("title 1", "description 1"));
            Dao2.insert(new table2("title 2", "description 2"));
            Dao2.insert(new table2("title 3", "description 3"));
            return null;
        }
    }
}

