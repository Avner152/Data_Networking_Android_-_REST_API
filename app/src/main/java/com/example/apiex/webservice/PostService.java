package com.example.apiex.webservice;

import com.example.apiex.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostService {
   String BASE_URL = "http://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Post>> postList();

}
