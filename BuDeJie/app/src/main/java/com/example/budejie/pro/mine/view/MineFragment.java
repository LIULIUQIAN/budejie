package com.example.budejie.pro.mine.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.budejie.R;
import com.example.budejie.pro.base.view.BaseFragment;
import com.example.budejie.pro.mine.view.nav.MineNavigationBuilder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {


    @Override
    public int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initContentView(View viewContent) {
        initNavigation(viewContent);
    }

    private void initNavigation(View viewContent){
        MineNavigationBuilder builder = new MineNavigationBuilder(getContext());
        builder.setModelRes(R.drawable.main_mine_night_model_selector)
                .setModelOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .setTitle(R.string.main_mine_title_text)
                .setRightIcon(R.drawable.main_mine_setting_selector)
                .setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       System.out.println("aaaaaa");
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }
}
