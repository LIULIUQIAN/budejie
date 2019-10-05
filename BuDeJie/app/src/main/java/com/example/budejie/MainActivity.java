package com.example.budejie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTabHost;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.budejie.pro.attention.view.AttentionFragment;
import com.example.budejie.pro.essence.view.EssenceFragment;
import com.example.budejie.pro.mine.view.MineFragment;
import com.example.budejie.pro.newpost.view.NewpostFragment;
import com.example.budejie.pro.publish.view.PublishFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {

    private List<TabItem> tabItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabData();
        initTabHost();
    }

    private void initTabData(){
        tabItemList = new ArrayList<>();
        tabItemList.add(new TabItem(R.drawable.main_bottom_essence_normal,R.drawable.main_bottom_essence_press,R.string.main_essence_text, EssenceFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_newpost_normal,R.drawable.main_bottom_newpost_press,R.string.main_newpost_text, NewpostFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_public_normal,R.drawable.main_bottom_public_press,0, PublishFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_attention_normal,R.drawable.main_bottom_attention_press,R.string.main_attention_text, AttentionFragment.class));
        tabItemList.add(new TabItem(R.drawable.main_bottom_mine_normal,R.drawable.main_bottom_mine_press,R.string.main_mine_text, MineFragment.class));
    }

    private void initTabHost(){
        FragmentTabHost fragmentTabHost = findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);

        for (int i=0;i<tabItemList.size();i++){
            TabItem tabItem = tabItemList.get(i);
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tabItem.getTitleString()).setIndicator(tabItem.getView());
            fragmentTabHost.addTab(tabSpec,tabItem.getFragmentClass(),tabItem.getBundle());
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE);
            fragmentTabHost.setOnTabChangedListener(this);
            tabItem.setChecked(i==0);
        }


    }

    @Override
    public void onTabChanged(String tabId) {

        for (int i = 0; i < tabItemList.size();i++){
            TabItem tabItem = tabItemList.get(i);
            tabItem.setChecked(tabId.equals(tabItem.getTitleString()));
        }

        System.out.println("tab===="+tabId);
    }


    class TabItem{
        private int imageNormal;
        private int imagePress;
        private int title;
        private String titleString;
        private Class<? extends Fragment> fragmentClass;

        private View view;
        private ImageView imageView;
        private TextView textView;
        private Bundle bundle;

        public TabItem(int imageNormal, int imagePress, int title, Class<? extends Fragment> fragmentClass) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.title = title;
            this.fragmentClass = fragmentClass;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        private int getImageNormal(){
            return imageNormal;
        }
        private int getImagePress(){
            return imagePress;
        }
        private int getTitle(){
            return title;
        }

        public String getTitleString() {
            if (getTitle() == 0){
                return "";
            }
            if (TextUtils.isEmpty(titleString)){
                titleString = getString(title);
            }
            return titleString;
        }

        public Bundle getBundle() {
            if (bundle == null){
                bundle = new Bundle();
            }
            bundle.putString("title",getTitleString());
            return bundle;
        }


        public View getView() {

            if (view == null){
                view = getLayoutInflater().inflate(R.layout.view_tab_item,null);
                imageView = view.findViewById(R.id.iv_tab);
                textView = view.findViewById(R.id.tv_tab);
            }
            if (getTitle() == 0){
                textView.setVisibility(View.GONE);
            }else {
                textView.setVisibility(View.VISIBLE);
                textView.setText(getTitleString());
            }
            imageView.setImageResource(getImageNormal());
            return view;
        }

      public void setChecked(boolean isChecked){
            if (imageView != null){
                if (isChecked){
                    imageView.setImageResource(getImagePress());
                }else {
                    imageView.setImageResource(getImageNormal());
                }
            }
            if (textView != null){
                if (isChecked){
                    textView.setTextColor(getColor(R.color.main_bottom_text_select));
                }else {
                    textView.setTextColor(getColor(R.color.main_bottom_text_normal));
                }
            }
      }


    }
}
