package com.arcsavunma.fouralabs.adapters.profile_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arcsavunma.fouralabs.adapters.posts.PostAdapter;
import com.arcsavunma.fouralabs.databinding.ProfileRecyclerRowBinding;
import com.arcsavunma.fouralabs.model.user.UserProfile;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileHolder> {
    ArrayList<UserProfile> usersProfileArrayList;

    public ProfileAdapter(ArrayList<UserProfile> usersProfileArrayList) {
        this.usersProfileArrayList = usersProfileArrayList;
    }

    @NonNull
    @Override
    public ProfileAdapter.ProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProfileRecyclerRowBinding recyclerRowBinding = ProfileRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ProfileHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ProfileHolder holder, int position) {
        Picasso.get().load(usersProfileArrayList.get(position).getUserPostUrl()).into(holder.binding.profileRecyclerviewImage);
    }

    @Override
    public int getItemCount() {
        return usersProfileArrayList.size();
    }

    class ProfileHolder extends RecyclerView.ViewHolder{
        ProfileRecyclerRowBinding binding;
        public ProfileHolder(@NonNull ProfileRecyclerRowBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
