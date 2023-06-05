package com.example.designapp_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RidesHistory extends AppCompatActivity {
    private Button move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rides_history);
        move =findViewById(R.id.btnRides);
        move.setOnClickListener(v -> {
            Intent intent = new Intent(RidesHistory.this, DashBoardActivity.class);
            startActivity(intent);
        });
    }
}