package com.example.budejie.pro.essence.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budejie.R;
import com.example.budejie.pro.base.view.BaseFragment;
import com.example.budejie.pro.essence.view.adapter.EssenceAdapter;
import com.example.budejie.pro.essence.view.nav.EssenceNavigationBuilder;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class EssenceFragment extends BaseFragment {

    private TabLayout tab_essence;
    private ViewPager vp_essence;

    @Override
    public int getContentView() {
        return R.layout.fragment_essence;
    }

    @Override
    public void initContentView(View viewContent) {
        initNavigation(viewContent);
        tab_essence = viewContent.findViewById(R.id.tab_essence);
        vp_essence = viewContent.findViewById(R.id.vp_essence);
    }

    private void initNavigation(View viewContent){
        EssenceNavigationBuilder builder = new EssenceNavigationBuilder(getContext());
        builder.setTitle(R.drawable.main_essence_title)
                .setLeftIcon(R.drawable.main_essence_btn_selector)
                .setRightIcon(R.drawable.main_essence_btn_more_normal)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("aaaaa");
                    }
                })
                .setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("bbbbb");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);

    }

    @Override
    public void initData() {
        String[] titles = getResources().getStringArray(R.array.essence_video_tab);
        EssenceAdapter adapter = new EssenceAdapter(getFragmentManager(),R.string.appbar_scrolling_view_behavior, Arrays.asList(titles));
        vp_essence.setAdapter(adapter);
        tab_essence.setupWithViewPager(vp_essence);

    }
}
