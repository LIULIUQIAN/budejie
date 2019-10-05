package com.example.budejie.pro.newpost.view;


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

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewpostFragment extends BaseFragment {

    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    public int getContentView() {
        return R.layout.fragment_newpost;
    }

    @Override
    public void initContentView(View viewContent) {
        initNavigation(viewContent);
        viewPager = viewContent.findViewById(R.id.vp_essence);
        tabLayout = viewContent.findViewById(R.id.tab_essence);
    }

    private void initNavigation(View viewContent){
        EssenceNavigationBuilder builder = new EssenceNavigationBuilder(getContext());
        builder.setTitle(R.drawable.main_essence_title)
                .setLeftIcon(R.drawable.main_newpost_audit_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("aaaaa");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);

    }

    @Override
    public void initData() {
        String[] titles = getResources().getStringArray(R.array.newpost_video_tab);
        EssenceAdapter adapter = new EssenceAdapter(getFragmentManager(),R.string.appbar_scrolling_view_behavior, Arrays.asList(titles));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
