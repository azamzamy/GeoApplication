package com.example.hp.youarehere;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.hp.youarehere.adapters.CommentsAdapter;
import com.example.hp.youarehere.models.CommentResponse;
import com.example.hp.youarehere.models.PhotosResponse;
import com.example.hp.youarehere.utilities.RetroFitController;
import com.example.hp.youarehere.utilities.RetrofitSingleton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PhotoActivity extends AppCompatActivity {
    Context context;
    Activity activity;
    ImageView mainPhoto;
    int photoId;
    String photoUrl;

    RecyclerView commentsList;
    CommentsAdapter commentsAdapter;
    LinearLayoutManager commentLinearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        context = this;
        activity = this;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            photoId = Integer.parseInt(extras.getString("photo_id"));
            photoUrl = extras.getString("photo_url");
            Log.d("ResponseComment",photoId +"");
        }

        mainPhoto = (ImageView) findViewById(R.id.main_photo);
        Picasso.with(context).load(photoUrl).into(mainPhoto);
        commentsList = (RecyclerView) findViewById(R.id.comments_list);
        getComments();

    }
    private void getComments() {
        RetroFitController.commentValContent commentVal= RetrofitSingleton.getInstance().create(RetroFitController.commentValContent.class);
            commentVal.getCommentVal(photoId, new Callback<ArrayList<CommentResponse>>() {//interface
                @Override
                public void success(ArrayList<CommentResponse> commentResponses, Response response) {
                    Log.d("ResponseComment", "YAAAAAAAY");
                    commentsAdapter = new CommentsAdapter(commentResponses, context, activity);
                    commentLinearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                    commentsList.setAdapter(commentsAdapter);
                    commentsList.setLayoutManager(commentLinearLayoutManager);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("ResponseComment", "FAIL  " + error.getLocalizedMessage());
                }
            });
    }

}
