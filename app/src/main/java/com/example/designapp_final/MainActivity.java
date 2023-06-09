package com.example.designapp_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.CursorWindow;
import android.os.Bundle;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    private UserDatabaseHelper userDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            field.setAccessible(true);
            field.set(null, 100 * 1024 * 1024); //the 100MB is the new size
        } catch (Exception e) {
            e.printStackTrace();
        }

        Runnable runnable = () -> {
            try {
                Thread.sleep(3000);
                userDatabaseHelper = new UserDatabaseHelper(this);
                if(!userDatabaseHelper.isUsersEmpty()){
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                    startActivity(intent);
                }

                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        }
    }
