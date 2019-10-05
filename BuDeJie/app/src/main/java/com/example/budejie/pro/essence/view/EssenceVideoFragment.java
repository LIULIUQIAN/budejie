package com.example.budejie.pro.essence.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.budejie.R;
import com.example.budejie.bean.PostsListBean;
import com.example.budejie.mvp.presenter.MvpBasePresenter;
import com.example.budejie.pro.base.presenter.BasePresenter;
import com.example.budejie.pro.base.view.BaseFragment;
import com.example.budejie.pro.essence.presenter.EssenceVideoPresenter;
import com.example.budejie.pro.essence.view.adapter.EssenceVideoAdapter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EssenceVideoFragment extends BaseFragment {

    private int mType = 0;
    private String mTitle;

    private EssenceVideoPresenter presenter;

    private RecyclerView recyclerView;
    private EssenceVideoAdapter videoAdapter;
    private RefreshLayout refreshLayout;

    private List<PostsListBean.PostList> postList = new ArrayList<>();

    private Handler handler = new Handler();
    public void setmType(int mType) {
        this.mType = mType;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public MvpBasePresenter bindPresenter() {
        presenter = new EssenceVideoPresenter(getContext());
        return presenter;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_essence_video;
    }

    @Override
    public void initContentView(View viewContent) {
        recyclerView = viewContent.findViewById(R.id.recycler_view_test_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        videoAdapter = new EssenceVideoAdapter(getContext(),postList);
        recyclerView.setAdapter(videoAdapter);

        refreshLayout = viewContent.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                loadData(true);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                loadData(false);
            }
        });
    }

    @Override
    public void initData() {

        loadData(true);
    }

    private void loadData(final boolean isDownRefresh){
        presenter.getEssenceList(mType,true, new BasePresenter.OnUIThreadListener<List<PostsListBean.PostList>>(){

            @Override
            public void onResult(final List<PostsListBean.PostList> result) {

                if (isDownRefresh){
                    postList.clear();
                }
                if (result != null){
                    postList.addAll(result);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        videoAdapter.notifyDataSetChanged();
                        refreshLayout.finishLoadMore();
                        refreshLayout.finishRefresh();
                    }
                });

            }
        });
    }
}
