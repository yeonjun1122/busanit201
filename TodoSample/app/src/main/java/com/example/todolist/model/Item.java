package com.example.todolist.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item")
public class Item {
    @PrimaryKey(autoGenerate = true)
    int no;
    String title;
    String content;
//    String regDate;

//    @ColumnInfo(name = "done", defaultValue = "0")
//    Boolean isDone = false;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public String getRegDate() {
//        return regDate;
//    }
//
//    public void setRegDate(String regDate) {
//        this.regDate = regDate;
//    }

//    public Boolean getDone() {
//        return isDone;
//    }
//
//    public void setDone(Boolean done) {
//        isDone = done;
//    }

    @Override
    public String toString() {
        return "Item{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
//                ", regDate='" + regDate + '\'' +
//                ", isDone=" + isDone +
                '}';
    }
}
