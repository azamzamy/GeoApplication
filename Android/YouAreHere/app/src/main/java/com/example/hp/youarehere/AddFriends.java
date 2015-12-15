package com.example.hp.youarehere;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.youarehere.models.UserResponse;
import com.example.hp.youarehere.utilities.RetroFitController;
import com.example.hp.youarehere.utilities.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class AddFriends extends ActionBarActivity {


    ListView friends ;
    private FriendsListAdapter adapter2;
    //    private String[] images = new int[]{R.drawable.ahmedtarek, R.drawable.hend, R.drawable.kamel, R.drawable.zamzamy};
//    private String [] names = {"Ahmed Tarek", "Hend Hesham", "Abdelrahman Kamel", "Zamzamy"};
    private ArrayList<String> friendNames;
    private ArrayList<String> friendImages;
    private ArrayList<Integer> friendIds;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friends);


        friends = (ListView) findViewById(R.id.friends);


        friendNames = new ArrayList<String>();

        friendImages = new ArrayList<String>();
        friendIds = new ArrayList<Integer>();

        RetroFitController.ViewAll viewfr = RetrofitSingleton.getInstance().create(RetroFitController.ViewAll.class);
        viewfr.viewAll(new Callback<List<UserResponse>>() {


            @Override
            public void success(List<UserResponse> friends, Response response) {
                int s = friends.size();
                for (int i = 0; i < s; i++) {
                    friendImages.add(friends.get(i).pp);
                    friendNames.add(friends.get(i).name);
                    friendIds.add(friends.get(i).id);
                    Log.d("Response:::::::::::::::", friends.get(i).id + "");


                }

            }


            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }

        });


        adapter2 = new FriendsListAdapter(AddFriends.this, friendNames, friendImages, friendIds, 2);
        friends.setAdapter(adapter2);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_friends, menu);
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
