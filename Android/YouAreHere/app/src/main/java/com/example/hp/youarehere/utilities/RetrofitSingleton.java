package com.example.hp.youarehere.utilities;

import android.provider.SyncStateContract;

import retrofit.RestAdapter;

/**
 * Created by ahmedtarek on 12/15/15.
 */

public class RetrofitSingleton {

    private static RestAdapter restAdapter = null;
	private static final String ENDPOINT = "http://localhost:3000/api";

    private RetrofitSingleton(){

    }

    public static RestAdapter getInstance(){
		if (restAdapter == null) {
			restAdapter = new RestAdapter.Builder().setEndpoint(ENDPOINT).build();
		}
		return restAdapter;
	}
}
