package com.example.budejie.mvp.presenter;

import com.example.budejie.mvp.view.MvpView;

public interface MvpPresenter <V extends MvpView> {
    public void attachView(V view);
    public void detachView();
}
