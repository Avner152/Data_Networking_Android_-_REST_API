package com.example.apiex.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitData {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(DataService.DATA_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static DataService dataService = retrofit.create(DataService.class);
    public static DataService getService() {
        return dataService;
    }
}
