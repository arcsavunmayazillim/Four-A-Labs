package com.arcsavunma.fouralabs.view.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arcsavunma.fouralabs.R;
import com.arcsavunma.fouralabs.adapters.posts.PostAdapter;
import com.arcsavunma.fouralabs.adapters.profile_adapter.ProfileAdapter;
import com.arcsavunma.fouralabs.model.posts.Posts;
import com.arcsavunma.fouralabs.model.user.UserProfile;
import com.arcsavunma.fouralabs.view.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    Context context;
    ArrayList<UserProfile> userProfileArrayList;
    ArrayList<Posts> postsArrayList;

    TextView postCount, followersCount, followsCount;
    ProfileAdapter profileAdapter;
    RecyclerView recyclerView;
    ImageView backToMainPage;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        context = getContext();
        userProfileArrayList = new ArrayList<>();
        postsArrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.profile_recyclerview);
        postCount = view.findViewById(R.id.profile_post_count);
        followsCount = view.findViewById(R.id.profile_user_follows);
        followersCount = view.findViewById(R.id.profile_user_followers);
        backToMainPage = view.findViewById(R.id.profile_back_to_main_imageview);
        backToMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        GetProfileData();

        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        profileAdapter = new ProfileAdapter(userProfileArrayList);
        recyclerView.setAdapter(profileAdapter);
        return view;
    }

    public void GetProfileData(){

        CollectionReference collectionReference = firebaseFirestore.collection("Posts");
        collectionReference.orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                if (e != null) {
                    Toast.makeText(context,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }

                if (queryDocumentSnapshots != null) {

                    for (DocumentSnapshot snapshot : queryDocumentSnapshots.getDocuments()) {

                        Map<String,Object> data = snapshot.getData();

                        //Casting
                        String comment = (String) data.get("comment");
                        String userEmail = (String) data.get("useremail");
                        String downloadUrl = (String) data.get("downloadurl");
                        Posts post = new Posts(userEmail,"Melik.Ugur",comment,downloadUrl);
                        postsArrayList.add(post);
                    }

                    for(Posts postItem : postsArrayList){
                        userProfileArrayList.add(new UserProfile(postItem.getEmail(),postItem.getUserName(),"Uğur","m.melik.ugur",String.valueOf(postsArrayList.size()),"1625","186",postItem.getPhotoUrl()));
                    }
                    postCount.setText(userProfileArrayList.get(0).getUserPosts());
                    followersCount.setText(userProfileArrayList.get(0).getUserFollowers());
                    followsCount.setText(userProfileArrayList.get(0).getUserFollows());
                    profileAdapter.notifyDataSetChanged();

                }

            }
        });
    }
}