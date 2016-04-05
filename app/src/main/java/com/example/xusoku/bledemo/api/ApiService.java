package com.example.xusoku.bledemo.api;

import com.example.xusoku.bledemo.model.film;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by xusoku on 2016/4/5.
 */
public interface ApiService {
    //http://api.dymfilm.com/tags/list?forCinecism=1
        @GET("tags/list")
        Call<film> listfilms(@Query("forCinecism") String forCinecism);
}

