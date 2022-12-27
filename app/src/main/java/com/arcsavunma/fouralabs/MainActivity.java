package com.arcsavunma.fouralabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.arcsavunma.fouralabs.databinding.ActivityMainBinding;
import com.arcsavunma.fouralabs.ui.ChatFragment;
import com.arcsavunma.fouralabs.ui.FavoritesFragment;
import com.arcsavunma.fouralabs.ui.MainFragment;
import com.arcsavunma.fouralabs.ui.PostFragment;
import com.arcsavunma.fouralabs.ui.ProfileFragment;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //next buttonu karenin siyah versiyonu


        //bottom nav menu fragment choose
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.fragment_main_menu:
                    replaceFragment(new MainFragment());
                    break;
                case R.id.fragment_chat_menu:
                    replaceFragment(new ChatFragment());
                    break;
                case R.id.fragment_post_menu:
                    replaceFragment(new PostFragment());
                    break;
                case R.id.fragment_fav_menu:
                    replaceFragment(new FavoritesFragment());
                    break;
                case R.id.fragment_profile_menu:
                    replaceFragment(new ProfileFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}