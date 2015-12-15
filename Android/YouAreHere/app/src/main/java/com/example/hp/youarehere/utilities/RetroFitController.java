package com.example.hp.youarehere.utilities;

import com.example.hp.youarehere.models.PhotosResponse;
import com.example.hp.youarehere.models.UserResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by ahmedtarek on 12/15/15.
 */
public class RetroFitController {

    public interface locatioBasedPhotos {
        @GET("photos/location")
        @Headers({
                "Content-Type: application/json",
                "Authorization: b973904fee30bf0ba30d98caebf8b6ee"
        })
        void getLocationBased(Callback<PhotosResponse> callback);
    }
    public interface ShowProfile {
        @GET("/users")
        @Headers({
                "Content-Type: application/json",
                "Authorization: b973904fee30bf0ba30d98caebf8b6ee"
        })
        void getShowProfile(Callback<UserResponse> callback);
    }

}
