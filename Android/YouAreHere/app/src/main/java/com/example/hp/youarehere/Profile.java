package com.example.hp.youarehere;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.youarehere.adapters.ImagesAdapter;
import com.example.hp.youarehere.utilities.Post;

public class Profile extends AppCompatActivity {

    RecyclerView profileRecyclerView;
    ImagesAdapter profileAdapter;
    StaggeredGridLayoutManager profileGridLayoutManager;
    Post[] posts;
    Context context;

    TextView profileName;
    TextView profileInfo;
    ImageView menuButton;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context = this;

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        menuButton = (ImageView) findViewById(R.id.menu_button_image);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        posts = new Post[8];
        for (int i=0; i<posts.length; i++) {
            Post p = new Post(i+"","","");
            posts[i] = p;
        }

        profileRecyclerView = (RecyclerView) findViewById(R.id.profile_recycler_view);
        profileAdapter = new ImagesAdapter(posts, context, 1);
        profileGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        profileRecyclerView.setAdapter(profileAdapter);
        profileRecyclerView.setLayoutManager(profileGridLayoutManager);


        // Text Shit
        profileInfo = (TextView) findViewById(R.id.profile_info);
        profileName = (TextView) findViewById(R.id.profile_name);

        profileName.setTypeface(Typeface.createFromAsset(context.getAssets(), "Raleway-Medium.ttf"));
        profileInfo.setTypeface(Typeface.createFromAsset(context.getAssets(), "Raleway-Medium.ttf"));
    }

}
