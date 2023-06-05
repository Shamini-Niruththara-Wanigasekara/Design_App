package com.example.designapp_final;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.designapp_final.databinding.ActivityDashBoardBinding;

public class DashBoardActivity extends DrawerBaseActivity {
    ActivityDashBoardBinding activityDashBoardBinding;
    private Button move;
    private Button move1;
    private Button move2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashBoardBinding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(activityDashBoardBinding.getRoot());
        allocateActivityTitle("DashBoard");
        move =findViewById(R.id.btnDash1);
        move.setOnClickListener(v -> {
            Intent intent = new Intent( DashBoardActivity.this, MainActivity_Recyc.class);
            startActivity(intent);
        });
        move1 =findViewById(R.id.btnDash2);
        move1.setOnClickListener(v -> {
            Intent intent = new Intent( DashBoardActivity.this, MyAccessories.class);
            startActivity(intent);
        });
        move2 =findViewById(R.id.btnDash3);
        move2.setOnClickListener(v -> {
            Intent intent = new Intent( DashBoardActivity.this, RidesHistory.class);
            startActivity(intent);
        });

    }
}