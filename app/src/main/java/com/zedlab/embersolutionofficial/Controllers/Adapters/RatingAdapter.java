package com.zedlab.embersolutionofficial.Controllers.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zedlab.embersolutionofficial.Models.Entity.RatingData;
import com.zedlab.embersolutionofficial.R;

import java.util.ArrayList;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.RatingViewHolder> {

     ArrayList<RatingData> ratingDatas;

     public RatingAdapter(ArrayList<RatingData> ratingDatas) {
          this.ratingDatas = ratingDatas;
     }

     @NonNull
     @Override
     public RatingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false);
          return new RatingViewHolder(view);
     }

     @Override
     public void onBindViewHolder(@NonNull RatingViewHolder holder, int position) {
          RatingData data = ratingDatas.get(position);

          holder.image.setImageResource(data.getImageUrl());
          holder.userName.setText(data.getUserName());
          holder.ratingBar.setRating(data.getRatingStars());
          holder.comment.setText(data.getComment());
     }

     @Override
     public int getItemCount() {
          return this.ratingDatas.size();
     }

     static class RatingViewHolder extends RecyclerView.ViewHolder{
          ImageView image;
          TextView userName, comment;
          RatingBar ratingBar;

          public RatingViewHolder(@NonNull View itemView) {
               super(itemView);

               //Hooks
               image = itemView.findViewById(R.id.user_image);
               userName = itemView.findViewById(R.id.user_username);
               ratingBar = itemView.findViewById(R.id.user_rating);
               comment = itemView.findViewById(R.id.user_comment);
          }
     }
}
