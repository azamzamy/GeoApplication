package com.example.hp.youarehere;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.hp.youarehere.adapters.TimeLineFragmentsAdapter;

public class Timeline extends AppCompatActivity {

    ViewPager viewPager;
    Context context;
    TimeLineFragmentsAdapter timeLineFragmentsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        timeLineFragmentsAdapter = new TimeLineFragmentsAdapter(getSupportFragmentManager(), 2,context);
        viewPager.setAdapter(timeLineFragmentsAdapter);
        viewPager.setCurrentItem(0);

    }
}
