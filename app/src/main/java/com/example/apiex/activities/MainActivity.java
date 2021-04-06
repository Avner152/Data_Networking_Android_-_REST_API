package com.example.apiex.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.apiex.R;
import com.example.apiex.model.Post;
import com.example.apiex.model.PostAdapter;
import com.example.apiex.webservice.RetrofitPost;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private Button simpleGET_btn, getWithGlide_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        InitView();

    }

    private void findViews() {
        simpleGET_btn = findViewById(R.id.simpleGET_btn);
        getWithGlide_btn = findViewById(R.id.GET_with_Glide_btn);

    }

    private void InitView() {

        simpleGET_btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, GetSimpleActivity.class);
            startActivity(intent);
               });
        getWithGlide_btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, GetWithGlideActivity.class);
            startActivity(intent);

        });


    }


}