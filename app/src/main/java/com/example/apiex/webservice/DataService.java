package com.example.apiex.webservice;

import com.example.apiex.model.Data;
import com.example.apiex.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DataService {
    String DATA_URL = "http://reqres.in/api/";

    @GET("users")
    Call<User> user();

    @POST("users")
    Call<User> updateUser(@Body User user);

    @PUT("users/{id}")
    Call<Data> updateDataUser(@Path("id") int id, @Body Data data);

    }
