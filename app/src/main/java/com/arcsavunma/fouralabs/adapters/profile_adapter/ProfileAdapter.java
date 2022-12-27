package com.arcsavunma.fouralabs.adapters.profile_adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arcsavunma.fouralabs.databinding.ProfileRecyclerRowBinding;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileHolder> {
    @NonNull
    @Override
    public ProfileAdapter.ProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ProfileHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ProfileHolder extends RecyclerView.ViewHolder{
        ProfileRecyclerRowBinding binding;
        public ProfileHolder(@NonNull ProfileRecyclerRowBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
