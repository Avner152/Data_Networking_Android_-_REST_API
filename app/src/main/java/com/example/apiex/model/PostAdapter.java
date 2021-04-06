package com.example.apiex.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiex.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> postsList;

    public PostAdapter(List<Post> postsList){
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.userId_TextView.setText(postsList.get(position).getUserId() + "");
        holder.id_TextView.setText(postsList.get(position).getId() + "");
        holder.title_TextView.setText(postsList.get(position).getTitle());
        holder.body_TextView.setText(postsList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public List<Post> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Post> postsList) {
        this.postsList = postsList;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        private ImageView user_image;
        private TextView userId_TextView;
        private TextView id_TextView;
        private TextView title_TextView;
        private TextView body_TextView;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            user_image = itemView.findViewById(R.id.profile_id_img);
            userId_TextView = itemView.findViewById(R.id.userId);
            id_TextView = itemView.findViewById(R.id.id);
            title_TextView = itemView.findViewById(R.id.title);
            body_TextView = itemView.findViewById(R.id.body);
        }
    }
}

