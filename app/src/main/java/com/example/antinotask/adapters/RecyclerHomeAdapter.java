package com.example.antinotask.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.antinotask.R;
import com.example.antinotask.models.User;
//import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerHomeAdapter extends RecyclerView.Adapter<RecyclerHomeAdapter.UserViewHolder> {

    private List<User>users;
    private Context context;
    private static ClickListener listener;

    public RecyclerHomeAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_view_layout,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        Glide.with(context).load(user.getUrl()).placeholder(R.drawable.ic_circle).error(R.drawable.ic_404_error).apply(new RequestOptions().circleCrop()).into(holder.userImg);
        holder.name.setText(user.getName());
        holder.age.setText("Age : "+user.getAge());
        holder.location.setText(user.getLocation());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.userImg)
        ImageView userImg;
        @BindView(R.id.tvName)
        TextView name;
        @BindView(R.id.age)
        TextView age;
        @BindView(R.id.location)
        TextView location;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        RecyclerHomeAdapter.listener = clickListener;
    }
    public interface ClickListener {
        void onClick(View view, int position);
    }

}
