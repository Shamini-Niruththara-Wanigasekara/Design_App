package com.example.designapp_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.designapp_final.databinding.ActivityDashBoardBinding;

public class DashBoardActivity extends DrawerBaseActivity {
    ActivityDashBoardBinding activityDashBoardBinding;
    private Button move;
    private Button move1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashBoardBinding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(activityDashBoardBinding.getRoot());
        allocateActivityTitle("DashBoard");
        move =findViewById(R.id.buttondashboard);
        move.setOnClickListener(v -> {
            Intent intent = new Intent( DashBoardActivity.this, MainActivity_Recyc.class);
            startActivity(intent);
        });
        move1 =findViewById(R.id.buttondashboard2);
        move1.setOnClickListener(v -> {
            Intent intent = new Intent( DashBoardActivity.this, AddAccessories.class);
            startActivity(intent);
        });

    }
}