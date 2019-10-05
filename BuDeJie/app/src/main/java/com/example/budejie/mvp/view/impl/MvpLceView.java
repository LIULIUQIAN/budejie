package com.example.budejie.mvp.view.impl;

import com.example.budejie.mvp.view.MvpView;

public interface MvpLceView<M> extends MvpView {

    public void showLoading(boolean pullToRefresh);

    public void showContent();

    public void showError(Exception e,boolean pullToRefresh);

    public void showData(M data);

}
