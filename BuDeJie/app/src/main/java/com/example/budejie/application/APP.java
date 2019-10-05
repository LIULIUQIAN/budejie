package com.example.budejie.application;

import android.app.Application;

public class APP extends Application {
    private volatile static APP instance=null;//防止多个线程同时访问

    public static APP getInstance() {
        if (instance==null){
            synchronized (APP.class){
                if (instance==null){
                    instance=new APP();
                }
            }
        }
        return instance;
    }
}
