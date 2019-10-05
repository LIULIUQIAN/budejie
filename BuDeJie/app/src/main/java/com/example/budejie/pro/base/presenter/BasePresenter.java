package com.example.budejie.pro.base.presenter;

import android.content.Context;

import com.example.budejie.mvp.presenter.MvpBasePresenter;
import com.google.gson.Gson;

public class BasePresenter extends MvpBasePresenter {
    private Context context;
    private Gson gson;

    public BasePresenter(Context context) {
        this.context = context;
        this.gson = new Gson();
    }

    public Context getContext() {
        return context;
    }

    public Gson getGson() {
        return gson;
    }

    public interface OnUIThreadListener<T>{
        public void onResult(T result);
    }
}
