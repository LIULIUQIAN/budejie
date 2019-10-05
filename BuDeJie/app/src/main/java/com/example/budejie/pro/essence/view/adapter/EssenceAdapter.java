package com.example.budejie.pro.essence.view.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.budejie.pro.essence.view.EssenceVideoFragment;

import java.util.List;

public class EssenceAdapter extends FragmentStatePagerAdapter {

    public static final String TAB_TAG = "@dream@";
    private List<String> mTitles;

    public EssenceAdapter(FragmentManager fm, int behavior, List<String> mTitles) {
        super(fm, behavior);
        this.mTitles = mTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        EssenceVideoFragment fragment = new EssenceVideoFragment();
        String[] title = mTitles.get(position).split(TAB_TAG);
        fragment.setmTitle(title[0]);
        fragment.setmType(Integer.parseInt(title[1]));
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position).split(TAB_TAG)[0];
    }
}
