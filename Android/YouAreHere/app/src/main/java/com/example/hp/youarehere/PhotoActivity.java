package com.example.hp.youarehere;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.hp.youarehere.models.CommentResponse;
import com.example.hp.youarehere.models.PhotosResponse;
import com.example.hp.youarehere.utilities.RetroFitController;
import com.example.hp.youarehere.utilities.RetrofitSingleton;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PhotoActivity extends AppCompatActivity {
    ImageView mainPhoto;
    ListView commentsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        mainPhoto = (ImageView) findViewById(R.id.main_photo);
        commentsList = (ListView) findViewById(R.id.comments_list);
        getComments();

    }
    private void getComments() {
        RetroFitController.commentValContent commentVal= RetrofitSingleton.getInstance().create(RetroFitController.commentValContent.class);
            commentVal.getCommentVal(new Callback<CommentResponse>() {//interface
                @Override
                public void success(CommentResponse commentResponse, Response response) {
                    Log.d("Response", "YAAAAAAAY");
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });
    }

}
