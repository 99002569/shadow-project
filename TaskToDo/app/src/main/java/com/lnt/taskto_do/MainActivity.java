package com.lnt.taskto_do;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
//    Room_Database room_database;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        // when upgrading versions, kill the original tables by using fallbackToDestructiveMigration()
//        room_database = Room.databaseBuilder(this, Room_Database.class, Room_Database).fallbackToDestructiveMigration().build();
//    }
//
//    public Room_Database getMyDatabase() {
//        return room_database;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}