package com.example.budejie.pro.essence.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.budejie.bean.PostsListBean;
import com.example.budejie.okhttp.HttpCallBack;
import com.example.budejie.pro.base.presenter.BasePresenter;
import com.example.budejie.pro.essence.model.EssenceVideoModel;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;

public class EssenceVideoPresenter extends BasePresenter {
    private EssenceVideoModel essenceVideoModel;
    private int page = 0;
    private String maxtime = null;

    public EssenceVideoPresenter(Context context) {
        super(context);
        this.essenceVideoModel = new EssenceVideoModel(context);
    }

    //定义解析方法
    public void getEssenceList(int type, final boolean isDownRefresh, final OnUIThreadListener<List<PostsListBean.PostList>> onUIThreadListener){
        if (isDownRefresh){
            maxtime = null;
        }
        //执行网络请求
        essenceVideoModel.getEssenceList(type, page, maxtime, new HttpCallBack() {


            @Override
            public void requestSuccess(Object result) {
                String r = (String) result;

                if (TextUtils.isEmpty(r)){
                    onUIThreadListener.onResult(null);
                }else {
                    try {
                        PostsListBean postsListBean = getGson().fromJson(r,PostsListBean.class);
                        if (postsListBean != null && postsListBean.getInfo() != null){
                            maxtime = postsListBean.getInfo().getMaxtime();
                        }
                        if (isDownRefresh){
                            page = 0;
                        }else {
                            page++;
                        }
                        onUIThreadListener.onResult(postsListBean.getList());
                    }catch (Exception e){
                        onUIThreadListener.onResult(null);
                    }
                }

            }

            @Override
            public void requestFailure(IOException e) {
                onUIThreadListener.onResult(null);

            }

        });
    }

}
