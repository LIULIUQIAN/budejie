package com.example.budejie.mvp.view.impl;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.budejie.mvp.presenter.MvpBasePresenter;
import com.example.budejie.mvp.view.MvpView;

public abstract class MvpFragment<P extends MvpBasePresenter> extends Fragment implements MvpView {

    protected P presenter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = bindPresenter();
        if (presenter != null){
            presenter.attachView(this);
        }
    }

    public abstract P bindPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null){
            presenter.detachView();
        }
    }
}
