package com.example.designapp_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CycleDetails extends AppCompatActivity {
    private Button move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycledetails);
        move =findViewById(R.id.buttonCycleDetails);
        move.setOnClickListener(v -> {
            Intent intent = new Intent( CycleDetails.this, AddAccessories.class);
            startActivity(intent);
        });
    }
}
