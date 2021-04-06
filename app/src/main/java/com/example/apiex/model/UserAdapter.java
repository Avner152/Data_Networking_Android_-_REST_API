package com.example.apiex.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apiex.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.DataViewHolder> {

private User user;
private List<Data> userList;
private Context context;
    public UserAdapter(User user) {
        this.user = user;
        this.userList = user.getData();
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userdata, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
    holder.dataId.setText("Id: " + userList.get(position).getId() + ".");
    holder.dataEmail.setText("Email: " + userList.get(position).getEmail() );
    holder.dataFirstName.setText("First: " + userList.get(position).getFirst_name() + ",");
    holder.dataLastName.setText("Last: " + userList.get(position).getLast_name());
    String URL = userList.get(position).getAvatar();

        Glide.with(context)
                .load(URL)
                .into(holder.user_data_img);

    }

    public void updateList(List<Data> data){
        userList.clear();
        userList.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView page, per_page, total, total_pages, dataId, dataEmail, dataFirstName, dataLastName;
        private ImageView user_data_img;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
//            page = itemView.findViewById(R.id.user_page);
//            per_page = itemView.findViewById(R.id.user_per_page);
//            total = itemView.findViewById(R.id.user_total);
//            total_pages = itemView.findViewById(R.id.user_total_pages);
            dataId = itemView.findViewById(R.id.user_data_id);
            dataEmail = itemView.findViewById(R.id.user_data_email);
            dataFirstName = itemView.findViewById(R.id.user_data_first_name);
            dataLastName = itemView.findViewById(R.id.user_data_last_name);
            user_data_img = itemView.findViewById(R.id.user_id_img);
        }
    }
}
