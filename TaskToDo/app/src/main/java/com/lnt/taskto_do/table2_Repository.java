package com.lnt.taskto_do;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class table2_Repository {

    private table2Dao Dao2;

    private LiveData<List<table1>> allTask;

    public table2_Repository(Application application){
        Room_Database room_database = Room_Database.getInstance(application);
        Dao2 = room_database.Dao2();
        allTask = Dao2.getAllTask();
    }

    public void insert(table2 task){
        new InsertNotAsyncTask(Dao2).execute(task);
    }

    public void update(table2 task){
        new UpdateNotAsyncTask(Dao2).execute(task);
    }

    public void delete(table2 task){
        new deleteNotAsyncTask(Dao2).execute(task);
    }

    public void deleteAllTask() {
        new deleteAllTaskNotAsyncTask(Dao2).execute();
    }

    public LiveData<List<table1>> getAllTask() {
        return allTask;
    }

    //insert
    private static class InsertNotAsyncTask extends AsyncTask<table2, Void, Void> {
        private table2Dao Dao2;

        private InsertNotAsyncTask(table2Dao Dao2){
            this.Dao2 = Dao2;
        }

        @Override
        protected Void doInBackground(table2... tasks){
            Dao2.insert(tasks[0]);
            return null;
        }
    }

    //update
    private static class UpdateNotAsyncTask extends AsyncTask<table2, Void, Void> {
        private table2Dao Dao2;

        private UpdateNotAsyncTask(table2Dao Dao2){
            this.Dao2 = Dao2;
        }

        @Override
        protected Void doInBackground(table2... tasks){
            Dao2.update(tasks[0]);
            return null;
        }
    }

    //delete
    private static class deleteNotAsyncTask extends AsyncTask<table2, Void, Void> {
        private table2Dao Dao2;

        private deleteNotAsyncTask(table2Dao Dao2){
            this.Dao2 = Dao2;
        }

        @Override
        protected Void doInBackground(table2... tasks){
            Dao2.delete(tasks[0]);
            return null;
        }
    }
    //deleteAll
    private static class deleteAllTaskNotAsyncTask extends AsyncTask<Void, Void, Void> {
        private table2Dao Dao2;

        private deleteAllTaskNotAsyncTask(table2Dao Dao2){
            this.Dao2 = Dao2;
        }

        @Override
        protected Void doInBackground(Void... voids){
            Dao2.deleteAllTask();
            return null;
        }
    }
}
