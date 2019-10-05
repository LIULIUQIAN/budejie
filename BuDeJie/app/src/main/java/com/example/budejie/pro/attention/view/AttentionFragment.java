package com.example.budejie.pro.attention.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budejie.R;
import com.example.budejie.mvp.presenter.MvpBasePresenter;
import com.example.budejie.pro.attention.view.nav.AttentionNavigationBuilder;
import com.example.budejie.pro.base.view.BaseFragment;
import com.example.budejie.pro.essence.view.adapter.EssenceAdapter;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttentionFragment extends BaseFragment {


    public AttentionFragment() {
        // Required empty public constructor
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_attention;
    }

    @Override
    public void initContentView(View viewContent) {

        ViewPager viewPager = viewContent.findViewById(R.id.vp_attention);
        String[] titles = getResources().getStringArray(R.array.attention_video_tab);
        EssenceAdapter adapter = new EssenceAdapter(getFragmentManager(), R.string.appbar_scrolling_view_behavior, Arrays.asList(titles));
        viewPager.setAdapter(adapter);
        initToolBar(viewContent,viewPager);
    }

    private void initToolBar(View viewContent, ViewPager viewPager) {
        AttentionNavigationBuilder builder = new AttentionNavigationBuilder(getContext());
        builder.setUpWithViewPage(viewPager)
                .setLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("aaaaaaaa");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }

    @Override
    public void initData() {

    }
}
