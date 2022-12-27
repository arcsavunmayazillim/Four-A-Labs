package com.arcsavunma.fouralabs.adapters.posts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arcsavunma.fouralabs.databinding.MainRecyclerRowBinding;
import com.arcsavunma.fouralabs.model.posts.Posts;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    ArrayList<Posts> postsArrayList;

    public PostAdapter(ArrayList<Posts> postsArrayList) {
        this.postsArrayList = postsArrayList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainRecyclerRowBinding recyclerRowBinding = MainRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PostHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.recyclerRowBinding.mainRecyclerUserName.setText(postsArrayList.get(position).getUserName());
        holder.recyclerRowBinding.mainRecyclerUserComment.setText(postsArrayList.get(position).getUserComment());
        Picasso.get().load(postsArrayList.get(position).getPhotoUrl()).into(holder.recyclerRowBinding.mainRecyclerUserImage);
    }

    @Override
    public int getItemCount() {
        return postsArrayList.size();
    }
    class PostHolder extends RecyclerView.ViewHolder {
        MainRecyclerRowBinding recyclerRowBinding;

        public PostHolder(@NonNull MainRecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;

        }
    }
}
