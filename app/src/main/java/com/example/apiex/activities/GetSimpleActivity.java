package com.example.apiex.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.apiex.R;
import com.example.apiex.model.Post;
import com.example.apiex.model.PostAdapter;
import com.example.apiex.webservice.RetrofitPost;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetSimpleActivity extends AppCompatActivity {
    private List<Post> posts;
    private PostAdapter postAdapter;
    private RecyclerView posts_RCV;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_simple);

        if(posts == null)
            posts = new ArrayList<>();
        setupRecyclerView();
        fetchPosts();

    }

    private void fetchPosts(){

        RetrofitPost.getService().postList().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                posts.addAll(response.body());
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }
        });
    }


    private void setupRecyclerView() {
        posts_RCV = findViewById(R.id.RCV_posts);
        Log.i("TAG", "setupRecyclerView: " + posts_RCV);
        linearLayoutManager = new LinearLayoutManager(this);

        postAdapter = new PostAdapter(posts);

        posts_RCV.setLayoutManager(linearLayoutManager);
        posts_RCV.setHasFixedSize(true);
        posts_RCV.setAdapter(postAdapter);
    }
}
