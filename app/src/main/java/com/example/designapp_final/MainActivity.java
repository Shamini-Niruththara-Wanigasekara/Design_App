package com.example.designapp_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        move =findViewById(R.id.imageView3);
        move.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SensorFingerPrint.class);
            startActivity(intent);
        });

        }
    }
