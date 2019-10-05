package com.example.budejie.pro.base.model;

import android.content.Context;

import com.example.budejie.mvp.model.MvpModel;

public class BaseModel implements MvpModel {
    private Context context;

    public BaseModel(Context context) {
        this.context = context;
    }
    public String getServerUrl(){
        return "http://api.budejie.com";
    }
}
