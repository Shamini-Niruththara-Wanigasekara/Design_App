package com.example.designapp_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.designapp_final.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    UserDatabaseHelper userDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userDatabaseHelper = new UserDatabaseHelper(this);
        if(!userDatabaseHelper.isUsersEmpty()){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
        binding.btnSignup.setOnClickListener(v -> {
            String email = binding.signupEmail.getText().toString();
            String password = binding.signupPassword.getText().toString();
            String confirmPassword = binding.signupConfirm.getText().toString();

            if (email.equals("") || password.equals("") || confirmPassword.equals(""))
                Toast.makeText(SignUpActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            else {
                if (password.equals(confirmPassword)) {
                    Boolean checkUserEmail = userDatabaseHelper.checkEmail(email);

                    if (!checkUserEmail) {
                        Boolean insert = userDatabaseHelper.insertData(email, password);

                        if (insert) {
                            Toast.makeText(SignUpActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUpActivity.this, "Signup Fail", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this, "User already exists, Please login", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignUpActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }
            }

        });


        binding.loginRedirectText.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        });

    }
}