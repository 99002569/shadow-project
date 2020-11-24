////entity of task table

package com.lnt.taskto_do;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.util.TableInfo;

@Entity(foreignKeys = @ForeignKey(entity=table1.class, parentColumns="category_id", childColumns="cat_id"), tableName = "Task")
public class table2 {

    @PrimaryKey(autoGenerate = true)
    private int task_id;

    private String task_title;

    private String task_description;

    private int cat_id;

    public table2(String task_title, String task_description) {
        this.task_title = task_title;
        this.task_description = task_description;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }
    public void setcat_id(int cat_id) {
        this.cat_id = cat_id;
    }


    public int getTask_id() {
        return task_id;
    }

    public String getTask_title() {
        return task_title;
    }

    public String getTask_description() {
        return task_description;
    }

    public int getCat_id() {
        return cat_id;
    }
}
