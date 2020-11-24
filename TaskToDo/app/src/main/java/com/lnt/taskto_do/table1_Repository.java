package com.lnt.taskto_do;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class table1_Repository {

    private table1Dao Dao1;

    private LiveData<List<table1>> allCategory;

    public table1_Repository(Application application){
        Room_Database room_database = Room_Database.getInstance(application);
        Dao1 = room_database.Dao1();
        allCategory = Dao1.getAllCategory();
    }

    public void insert(table1 category){
        new InsertNotAsyncTask(Dao1).execute(category);
    }

    public void delete(table1 category){
        new deleteNotAsyncTask(Dao1).execute(category);
    }

    public void deleteAllCategory() {
        new deleteAllCategoryNotAsyncTask(Dao1).execute();
    }

    public LiveData<List<table1>> getAllCategory() {
        return allCategory;
    }

    //insert
    private static class InsertNotAsyncTask extends AsyncTask<table1, Void, Void> {
        private table1Dao Dao1;

        private InsertNotAsyncTask(table1Dao Dao1){
            this.Dao1 = Dao1;
        }

        @Override
        protected Void doInBackground(table1... categories){
            Dao1.insert(categories[0]);
            return null;
        }
    }
    //delete
    private static class deleteNotAsyncTask extends AsyncTask<table1, Void, Void> {
        private table1Dao Dao1;

        private deleteNotAsyncTask(table1Dao Dao1){
            this.Dao1 = Dao1;
        }

        @Override
        protected Void doInBackground(table1... categories){
            Dao1.delete(categories[0]);
            return null;
        }
    }
    //deleteAll
    private static class deleteAllCategoryNotAsyncTask extends AsyncTask<Void, Void, Void> {
        private table1Dao Dao1;

        private deleteAllCategoryNotAsyncTask(table1Dao Dao1){
            this.Dao1 = Dao1;
        }

        @Override
        protected Void doInBackground(Void... voids){
            Dao1.deleteAllCategory();
            return null;
        }
    }
}
