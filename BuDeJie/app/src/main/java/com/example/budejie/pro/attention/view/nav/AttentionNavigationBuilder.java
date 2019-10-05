package com.example.budejie.pro.attention.view.nav;

import android.content.Context;
import android.view.ViewGroup;

import androidx.viewpager.widget.ViewPager;

import com.example.budejie.R;
import com.example.budejie.pro.base.view.navigation.NavigationBuilderAdapter;
import com.google.android.material.tabs.TabLayout;

public class AttentionNavigationBuilder extends NavigationBuilderAdapter {

    private ViewPager viewPager;

    public AttentionNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_attention_layout;
    }

    public AttentionNavigationBuilder setUpWithViewPage(ViewPager viewPage){
        this.viewPager = viewPage;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left,getLeftIconRes(),getLeftIconOnClickListener());
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_attention);
        tabLayout.setupWithViewPager(viewPager);

    }
}
