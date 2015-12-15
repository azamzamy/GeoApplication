package com.example.hp.youarehere;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.youarehere.adapters.TimeLineFragmentsAdapter;
import com.example.hp.youarehere.models.Friendship;
import com.example.hp.youarehere.models.UserResponse;
import com.example.hp.youarehere.utilities.RetroFitController;
import com.example.hp.youarehere.utilities.RetrofitSingleton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class Friends extends ActionBarActivity {


    ListView friends ;
    private FriendsListAdapter adapter2;
//    private String[] images = new int[]{R.drawable.ahmedtarek, R.drawable.hend, R.drawable.kamel, R.drawable.zamzamy};
//    private String [] names = {"Ahmed Tarek", "Hend Hesham", "Abdelrahman Kamel", "Zamzamy"};
    private ArrayList<String> friendNames;
    private ArrayList<String> friendImages;
    private ArrayList<Integer> friendIds;
    Context context;


    TimeLineFragmentsAdapter timeLineFragmentsAdapter;
    TextView profile;
    ImageView menuButton;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        context = this;

        // Get ListView object from xml
        friends = (ListView) findViewById(R.id.friends);


        friendNames = new ArrayList<String>();

        friendImages = new ArrayList<String>();
        friendIds = new ArrayList<Integer>();

        RetroFitController.ViewFriends viewfr = RetrofitSingleton.getInstance().create(RetroFitController.ViewFriends.class);
        viewfr.viewFriends(1, new Callback<List<UserResponse>>() {


            @Override
            public void success(List<UserResponse> friends, Response response) {
                int s = friends.size();
                for (int i = 0; i < s; i++) {
                            friendImages.add(friends.get(i).pp);
                            friendNames.add(friends.get(i).name);
                            friendIds.add(friends.get(i).id);
                    Log.d("Response:::::::::::::::", friends.get(i).id+"");


                        }

                }


            @Override
                public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                }

            });


        adapter2 = new FriendsListAdapter(Friends.this, friendNames, friendImages, friendIds, 1);
        friends.setAdapter(adapter2);

        TextView AddFriends = (TextView) findViewById(R.id.AddFriends);
        AddFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Friends.this, AddFriends.class);
                startActivity(intent);
            }
        });






        TextView profile = (TextView) findViewById(R.id.profile_text);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Profile.class);
                startActivity(intent);
            }
        });

        TextView users = (TextView) findViewById(R.id.users);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Users.class);
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
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_friends, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
