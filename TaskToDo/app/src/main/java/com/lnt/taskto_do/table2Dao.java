package com.lnt.taskto_do;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface table2Dao {

    @Insert
    void insert(table2 task);

    @Delete
    void delete(table2 task);

    @Update
    void update(table2 task);

    @Query("DELETE from Task")
    void deleteAllTask();

    @Query("SELECT * FROM Task ORDER BY task_title ASC")
    LiveData<List<table1>> getAllTask();

}
