package com.arcsavunma.fouralabs.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.arcsavunma.fouralabs.R;
import com.arcsavunma.fouralabs.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    private FirebaseAuth firebaseAuth;
    String userMail, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        firebaseAuth = FirebaseAuth.getInstance();
       // FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        /*if (firebaseUser != null) {

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        }*/
        binding.userMailEditText.setText("admin@example.com");
        binding.passwordEditText.setText("123456");

    }

    public void LoginClicked(View view){

        userMail = binding.userMailEditText.getText().toString();
        userPassword = binding.passwordEditText.getText().toString();



        if(TextUtils.isEmpty(userMail)) {
            binding.userMailEditText.setError("Kullanıcı Emaili Boş Olamaz!");
            return;
        }else if(TextUtils.isEmpty(userPassword)) {
            binding.passwordEditText.setError("Kullanıcı Şifresi Boş Olamaz!");
            return;
        }else{
            firebaseAuth.signInWithEmailAndPassword(userMail,userPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(LoginActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}