package com.example.budejie.mvp.view.impl;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.budejie.mvp.presenter.MvpBasePresenter;
import com.example.budejie.mvp.view.MvpView;

public abstract class MvpActivity<P extends MvpBasePresenter> extends AppCompatActivity implements MvpView {

    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = bindPresenter();
        if (presenter != null){
            presenter.attachView(this);
        }
    }

    public abstract P bindPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detachView();
        }
    }
}
