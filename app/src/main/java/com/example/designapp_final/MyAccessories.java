package com.example.designapp_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MyAccessories extends AppCompatActivity {
    private Button move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_accessories);
        move =findViewById(R.id.btnAcc);
        move.setOnClickListener(v -> {
            Intent intent = new Intent(MyAccessories.this, DashBoardActivity.class);
            startActivity(intent);
        });

    }
}