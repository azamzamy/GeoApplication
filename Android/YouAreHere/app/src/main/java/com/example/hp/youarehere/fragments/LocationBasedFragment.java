package com.example.hp.youarehere.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.youarehere.R;

/**
 * Created by ahmedtarek on 11/29/15.
 */
public class LocationBasedFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.location_based_fragment, container, false);



        return rootView;
    }
}
