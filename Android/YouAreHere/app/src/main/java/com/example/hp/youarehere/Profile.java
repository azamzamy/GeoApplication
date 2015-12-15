package com.example.hp.youarehere;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.youarehere.adapters.ImagesAdapter;
import com.example.hp.youarehere.adapters.TimeLineFragmentsAdapter;
import com.example.hp.youarehere.models.PhotosResponse;
import com.example.hp.youarehere.models.UserResponse;
import com.example.hp.youarehere.utilities.Post;
import com.example.hp.youarehere.utilities.RetroFitController;
import com.example.hp.youarehere.utilities.RetrofitSingleton;
import com.squareup.picasso.Picasso;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Profile extends AppCompatActivity {

    RecyclerView profileRecyclerView;
    ImagesAdapter profileAdapter;
    StaggeredGridLayoutManager profileGridLayoutManager;
    Post[] posts;
    ViewPager viewPager;
    TextView profileName;
    TextView profileInfo;
    ImageView menuButton;
    ImageView profilePicture;
    Context context;
    TimeLineFragmentsAdapter timeLineFragmentsAdapter;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context = this;


        TextView profile = (TextView) findViewById(R.id.profile_text);


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



        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        menuButton = (ImageView) findViewById(R.id.menu_button_image);
        profilePicture = (ImageView) findViewById(R.id.profile_picture);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        getShowProfile();



        posts = new Post[8];
        for (int i=0; i<posts.length; i++) {
            Post p = new Post(i+"","","");
            posts[i] = p;
        }

        profileRecyclerView = (RecyclerView) findViewById(R.id.profile_recycler_view);
        profileAdapter = new ImagesAdapter(posts, context, 1, Profile.this);
        profileGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        profileRecyclerView.setAdapter(profileAdapter);
        profileRecyclerView.setLayoutManager(profileGridLayoutManager);


        // Text Shit
        profileInfo = (TextView) findViewById(R.id.profile_info);
        profileName = (TextView) findViewById(R.id.profile_name);

        profileName.setTypeface(Typeface.createFromAsset(context.getAssets(), "Raleway-Medium.ttf"));
        profileInfo.setTypeface(Typeface.createFromAsset(context.getAssets(), "Raleway-Medium.ttf"));


    }
    private void getShowProfile() {
        RetroFitController.ShowProfile UserProfile= RetrofitSingleton.getInstance().create(RetroFitController.ShowProfile.class);
        UserProfile.getShowProfile(new Callback<UserResponse>() {
            @Override
            public void success(UserResponse UserResponse, Response response) {
                profileName.setText(UserResponse.name);
                Picasso.with(context).load(UserResponse.pp).into(profilePicture);
                profileInfo.setText("A "+ UserResponse.gender + " from " + UserResponse.city + " " + UserResponse.country);

                Log.d("Response", "YAAAAAAAY");
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
