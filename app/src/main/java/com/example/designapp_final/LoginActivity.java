package com.example.designapp_final;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import com.example.designapp_final.databinding.ActivityLoginBinding;
import com.example.designapp_final.models.User;

import java.util.concurrent.Executor;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    UserDatabaseHelper userDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userDatabaseHelper = new UserDatabaseHelper(this);
        User user = userDatabaseHelper.getUser();

        if(user == null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        assert user != null;
        binding.loginEmail.setText(user.getEmail());


        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(LoginActivity.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                                "Authentication error: " + errString, Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),
                        "Authentication succeeded!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), BookCycleVideo.class);
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), "Authentication failed",
                                Toast.LENGTH_SHORT)
                        .show();
            }
        });

        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login for my app")
                .setSubtitle("Log in to " + user.getEmail() + " using your biometric credential")
                .setNegativeButtonText("Use account password")
                .build();
        biometricPrompt.authenticate(promptInfo);


        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.loginEmail.getText().toString();
            String password = binding.loginPassword.getText().toString();

            if (email.equals("")|| password.equals(""))
                Toast.makeText(LoginActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            else {
                Boolean checkCredentials = userDatabaseHelper.checkEmailPassword(email, password);

                if(checkCredentials){
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), BookCycleVideo.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.signupRedirectText.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

    }
}