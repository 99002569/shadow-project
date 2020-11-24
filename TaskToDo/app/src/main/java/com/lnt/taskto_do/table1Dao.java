package com.lnt.taskto_do;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface table1Dao {
    @Insert
    void insert(table1 category);

    @Delete
    void delete(table1 category);

    @Query("DELETE FROM category")
    void deleteAllCategory();


    @Query("SELECT * FROM Category ORDER BY category_name ASC")
    LiveData<List<table1>> getAllCategory();


}
