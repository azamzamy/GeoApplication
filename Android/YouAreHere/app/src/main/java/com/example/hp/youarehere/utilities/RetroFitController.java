package com.example.hp.youarehere.utilities;

import com.example.hp.youarehere.models.Friendship;
import com.example.hp.youarehere.models.PhotosResponse;
import com.example.hp.youarehere.models.UserResponse;

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
    public interface ShowProfile {
        @GET("/users")
        @Headers({
                "Content-Type: application/json",
                "Authorization: b973904fee30bf0ba30d98caebf8b6ee"
        })
        void getShowProfile(Callback<UserResponse> callback);
    }

    public interface ShowFriend {

        @GET("/users/{user_id}")
        void showFriend(@Path("user_id") String id, Callback<UserResponse> callback);
    }

    public interface ViewFriends {

        @GET("/friends/{user_id}")
        void viewFriends(@Path("user_id") int user, Callback<List<UserResponse>> callback);

    }

    public interface RemoveFriend {

        @POST("/friends/{user_id}/{friend_id}")
        void removeFriend(@Path("user_id") String user, @Path("friend_id") String friend, Callback<Boolean> callback);

    }


    public interface AddFriend {

        @POST("/friends/{user_id}/add/{friend_id}/{isFriend}")
        void addFriend(@Path("user_id") String user, @Path("friend_id") String friend, @Path("isFriend") boolean isFriend, Callback<Friendship> callback);

    }




    public interface ViewAll {

        @GET("/users")
        void viewAll(Callback<List<UserResponse>> callback);

    }


}
