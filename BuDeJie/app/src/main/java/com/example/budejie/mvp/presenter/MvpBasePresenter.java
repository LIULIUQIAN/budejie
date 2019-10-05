package com.example.budejie.mvp.presenter;

import com.example.budejie.mvp.view.MvpView;

public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
