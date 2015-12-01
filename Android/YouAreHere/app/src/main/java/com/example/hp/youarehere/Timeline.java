package com.example.hp.youarehere;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.youarehere.adapters.TimeLineFragmentsAdapter;

public class Timeline extends AppCompatActivity {

    ViewPager viewPager;
    Context context;
    TimeLineFragmentsAdapter timeLineFragmentsAdapter;
    TextView profile;

    ImageView menuButton;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        context = this;
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        menuButton = (ImageView) findViewById(R.id.menu_button_image);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        timeLineFragmentsAdapter = new TimeLineFragmentsAdapter(getSupportFragmentManager(), 2,context);
        viewPager.setAdapter(timeLineFragmentsAdapter);
        viewPager.setCurrentItem(0);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        profile = (TextView) findViewById(R.id.profile_text);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Profile.class);
                startActivity(intent);
            }
        });


    }
}
