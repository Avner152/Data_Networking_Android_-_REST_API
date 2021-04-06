package com.example.apiex.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitPost {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(PostService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static PostService service = retrofit.create(PostService.class);

    public static PostService getService() {
        return service;
    }
}
