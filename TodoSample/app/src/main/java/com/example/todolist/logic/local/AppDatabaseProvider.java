package com.example.todolist.logic.local;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseProvider {

    private volatile static AppDatabase INSTANCE = null;

    private AppDatabaseProvider(){}

    // LocalDataSourceImpl
    public static AppDatabase getINSTANCE() throws Exception {
        if(INSTANCE == null) {
            throw new Exception("INSTANCE MUST BE NOT NULL");
        }
        return INSTANCE;
    }

    // Application
    public static AppDatabase getINSTANCE(Context context) {

        if(INSTANCE == null) {
            synchronized (AppDatabase.class) {
                INSTANCE = Room.databaseBuilder(context,
                        AppDatabase.class, "db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }

        return INSTANCE;
    }

}
