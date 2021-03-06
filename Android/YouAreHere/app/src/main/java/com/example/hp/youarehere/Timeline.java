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
import android.widget.Toast;

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

        TextView friend = (TextView) findViewById(R.id.Friends);


        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Friends.class);
                startActivity(intent);
            }
        });

        TextView Setting = (TextView) findViewById(R.id.Settings);


        Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Settings.class);
                startActivity(intent);
            }
        });


        TextView Explore= (TextView) findViewById(R.id.Explore);


        Explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Timeline.class);
                startActivity(intent);
            }
        });

        TextView postPhoto= (TextView) findViewById(R.id.post_photo);


        postPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(context, "An Image have been selected", Toast.LENGTH_LONG).show();
    }
}
