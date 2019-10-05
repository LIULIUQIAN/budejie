package com.example.budejie.pro.essence.view.nav;

import android.content.Context;

import com.example.budejie.R;
import com.example.budejie.pro.base.view.navigation.NavigationBuilderAdapter;

public class EssenceNavigationBuilder extends NavigationBuilderAdapter {

    public EssenceNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_essence_layout;
    }
}
