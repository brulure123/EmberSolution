package com.zedlab.embersolutionofficial.Controllers.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.zedlab.embersolutionofficial.Controllers.Adapters.PageAdapter;
import com.zedlab.embersolutionofficial.R;

public class UserScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);

        this.configureShowViewPager();
    }

    private void configureShowViewPager(){

        Toolbar toolbar = findViewById(R.id.user_screen_activity_toolbar);
        setSupportActionBar(toolbar);

        ViewPager pager = findViewById(R.id.userscreen_activity_viewpager);
        pager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        TabLayout tabs = findViewById(R.id.user_screen_activity_tabs);
        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }

    @NonNull
    @Override
    public String toString() {
        return getClass().getName();
    }
}