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
import android.widget.Button;
import android.widget.EditText;
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

public class EditProfile extends AppCompatActivity {

    //ImagesAdapter profileAdapter;
    //StaggeredGridLayoutManager profileGridLayoutManager;
    //Post[] posts;
    //ViewPager viewPager;
    EditText editName;
    EditText editInfo;
    Button editNameButton;
    Button editInfoButton;
    ImageView menuButton;
    ImageView profilePicture;
    Context context;
    //TimeLineFragmentsAdapter timeLineFragmentsAdapter;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        context = this;


        TextView profile = (TextView) findViewById(R.id.profile_text);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditProfile.class);
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

        getEditProfile();





        // Text Shit
        editName = (EditText) findViewById(R.id.profile_name);
        editInfo = (EditText) findViewById(R.id.profile_info);


        //by3mel eh da ???
        //profileName.setTypeface(Typeface.createFromAsset(context.getAssets(), "Raleway-Medium.ttf"));
        //profileInfo.setTypeface(Typeface.createFromAsset(context.getAssets(), "Raleway-Medium.ttf"));

        //buttons
        editInfoButton = (Button) findViewById(R.id.edit_info_button);
        editNameButton = (Button) findViewById(R.id.edit_name_button);
        editInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        editNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
    private void getEditProfile() {
        RetroFitController.EditProfile UserProfile= RetrofitSingleton.getInstance().create(RetroFitController.EditProfile.class);
        UserProfile.getEditProfile(new Callback<UserResponse>() {
            @Override
            public void success(UserResponse UserResponse, Response response) {
                //edit in api instead of retreiving ???????????
                editName.setText(UserResponse.name);
                Picasso.with(context).load(UserResponse.pp).into(profilePicture);
                editInfo.setText("A "+ UserResponse.gender + " from " + UserResponse.city + " " + UserResponse.country);

                Log.d("Response", "YAAAAAAAY");
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


}
