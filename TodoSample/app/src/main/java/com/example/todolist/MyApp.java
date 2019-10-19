package com.example.todolist;

import android.app.Application;

import com.example.todolist.logic.local.AppDatabaseProvider;
import com.facebook.stetho.Stetho;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRoom();
        initSteho();
    }

    private void initSteho() {
        Stetho.initializeWithDefaults(this);
    }

    private void initRoom() {
        // 1회 생성
        AppDatabaseProvider.getINSTANCE(getApplicationContext());
    }


}
