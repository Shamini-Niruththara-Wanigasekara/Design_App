package com.example.designapp_final;

import android.os.Bundle;

import com.example.designapp_final.databinding.ActivityAboutBinding;


public class AboutActivity extends DrawerBaseActivity {
    private ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding .inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocateActivityTitle("About");
    }
}