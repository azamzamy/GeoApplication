package com.example.hp.youarehere.utilities;

import com.example.hp.youarehere.models.Friendship;
import com.example.hp.youarehere.models.PhotosResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by ahmedtarek on 12/15/15.
 */
public class RetroFitController {

    public interface locatioBasedPhotos {
        @GET("photos/location")
        @Headers({
                "Content-Type: application/json",
                "Authorization: e9b3a1125f9cfa8e793ab38fa00801e7"
        })
        void getLocationBased(Callback<PhotosResponse> callback);
    }

    public interface ViewFriends {

        @GET("friends/{user_id}")
        void viewFriends(@Path("user_id") int user, Callback<List<Friendship>> callback);
    }



}
