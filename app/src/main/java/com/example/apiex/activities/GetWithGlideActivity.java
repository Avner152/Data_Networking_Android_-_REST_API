package com.example.apiex.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.apiex.R;
import com.example.apiex.model.Data;
import com.example.apiex.model.User;
import com.example.apiex.model.UserAdapter;
import com.example.apiex.webservice.DataService;
import com.example.apiex.webservice.RetrofitData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.POST;

public class GetWithGlideActivity extends AppCompatActivity {
    private Button GET_btn, POST_btn, PUT_btn, DELETE_btn;
    private RecyclerView user_RCV_data;
    private User users;
    private LinearLayoutManager linearLayoutManager;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_glide);

        findViews();
        setupRecyclerView();

        initViews();


//     // :: HTTP Methods :: //
//        // GET //
//        fetchServices();
//        // POST //  => need to change //
//        createUser();
//        // PUT //
//        updateUserData();
//        // DELETE //
//        deleteUserData();
    }

    private void findViews() {
        GET_btn = findViewById(R.id.GET_btn);
        POST_btn = findViewById(R.id.POST_btn);
        PUT_btn = findViewById(R.id.PUT_btn);
        DELETE_btn = findViewById(R.id.DELETE_btn);
        if(users == null) {
            users = new User(1, 2, 3, 4, new ArrayList<>());
        }
    }

    private void deleteUserData() {
    }

    private void updateUserData() {

        Data data = new Data(123456789, "ChesterBe@gmail.com", "Chester", "Bennington", "https://i.pinimg.com/originals/fa/d5/6a/fad56aa64b303d88b7bf5b77e223254c.jpg");
        Call<Data> userCall = RetrofitData.getService().updateDataUser(1, data);

        userCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                users.getData().set(1, data);
                userAdapter.updateList(users.getData());

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.i("TAG", t.getMessage());

            }
        });
    }

    private void initViews() {
        GET_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchServices();

            }
        });
        POST_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
        PUT_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserData();
            }
        });
        DELETE_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void createUser() {
        Data d = new Data(308063395,"avnerx92@gmail.com","Avner","Levy","https://i.imgur.com/Dc8DY7g.jpg");
        Call<User> call = RetrofitData.getService().updateUser(users);
    call.enqueue(new Callback<User>() {
        @Override
        public void onResponse(Call<User> call, Response<User> response) {
            response.body().getData().add(d);
            userAdapter.updateList(response.body().getData());
        }

        @Override
        public void onFailure(Call<User> call, Throwable t) {

        }
    });
    }

    private void fetchServices() {
        RetrofitData.getService().user().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                users = response.body();
                userAdapter.updateList(users.getData());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void setupRecyclerView() {
        user_RCV_data = findViewById(R.id.RCV_users);
        linearLayoutManager = new LinearLayoutManager(this);

        userAdapter = new UserAdapter(users);

        user_RCV_data.setLayoutManager(linearLayoutManager);
        user_RCV_data.setHasFixedSize(true);
        user_RCV_data.setAdapter(userAdapter);
    }
}