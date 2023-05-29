package com.example.designapp_final;

import android.os.Bundle;
import android.view.View;

import com.example.designapp_final.databinding.ActivityTermsConditionsBinding;

public class TeamsConditionsActivity extends DrawerBaseActivity {
    private ActivityTermsConditionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTermsConditionsBinding .inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocateActivityTitle("Teams and Conditions");
    }
}