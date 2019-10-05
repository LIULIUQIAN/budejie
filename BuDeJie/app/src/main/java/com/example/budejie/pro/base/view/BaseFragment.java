package com.example.budejie.pro.base.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.budejie.mvp.presenter.MvpBasePresenter;
import com.example.budejie.mvp.view.impl.MvpFragment;

public abstract class BaseFragment<P extends MvpBasePresenter> extends MvpFragment<P> {

    private View viewContent;
    private boolean isInitData = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (viewContent == null){
            viewContent = inflater.inflate(getContentView(),container,false);
            initContentView(viewContent);
        }
        ViewGroup parent = (ViewGroup) viewContent.getParent();
        if (parent != null){
            parent.removeView(viewContent);
        }

        return viewContent;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!isInitData){
            initData();
            isInitData = true;
        }
}

    @Override
    public P bindPresenter() {
        return null;
    }

    public abstract int getContentView();

    public void initData(){

    }
    public abstract void initContentView(View viewContent);
}
