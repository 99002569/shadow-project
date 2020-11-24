//entity of category table

package com.lnt.taskto_do;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.util.TableInfo;

@Entity(tableName = "Category")
public class table1 {

    @PrimaryKey(autoGenerate = true)
    private int category_id;
    private String category_name;

    public table1(String category_name) {
        this.category_name = category_name;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }
}
