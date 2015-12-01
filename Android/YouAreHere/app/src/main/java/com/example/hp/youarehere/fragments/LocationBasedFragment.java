package com.example.hp.youarehere.fragments;

import android.location.Location;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hp.youarehere.CommentsListAdapter;
import com.example.hp.youarehere.FriendsListAdapter;
import com.example.hp.youarehere.R;
import com.example.hp.youarehere.adapters.ImagesAdapter;
import com.example.hp.youarehere.utilities.Post;


import java.util.ArrayList;

/**
 * Created by ahmedtarek on 11/29/15.
 */
public class LocationBasedFragment extends Fragment {


    // Location-based RecyclerView stuff
    RecyclerView locationRecyclerView;
    ImagesAdapter imagesAdapter;
    LinearLayoutManager locationLinearLayoutManager;
    Post[] locationPosts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.location_based_fragment, container, false);


        locationPosts = new Post[8];
        for (int i=0; i<locationPosts.length; i++) {
            Post p = new Post(i+"","","");
            locationPosts[i] = p;
        }
        locationRecyclerView = (RecyclerView) rootView.findViewById(R.id.location_based_recycler_view);
        imagesAdapter = new ImagesAdapter(locationPosts, getContext(), 0, getActivity());
        locationLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        locationRecyclerView.setAdapter(imagesAdapter);
        locationRecyclerView.setLayoutManager(locationLinearLayoutManager);



        return rootView;
    }
}
