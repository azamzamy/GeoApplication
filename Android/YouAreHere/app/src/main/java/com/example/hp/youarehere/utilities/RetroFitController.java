package com.example.hp.youarehere.utilities;

import com.example.hp.youarehere.models.PhotosResponse;

import java.util.ArrayList;
import java.util.List;

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
        @Headers({
                "Content-Type: application/json",
                "Authorization: b973904fee30bf0ba30d98caebf8b6ee"
        })
        @GET("/photos")
        void getLocationBased(Callback<List<PhotosResponse>> photos);
    }

}
