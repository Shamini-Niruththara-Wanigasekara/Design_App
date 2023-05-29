package com.example.designapp_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.designapp_final.databinding.ActivityMapsBinding;
import com.example.designapp_final.databinding.ActivitySettingsBinding;

public class SettingsActivity extends DrawerBaseActivity {

    SwitchCompat switch_1,switch_2,switch_3,switch_4,switch_5,switch_6;
    boolean stateSwitch1,stateSwitch2,stateSwitch3,stateSwitch4,stateSwitch5,stateSwitch6;
    SharedPreferences preferences;
    private ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocateActivityTitle("Settings");
        //setContentView(R.layout.activity_settings);

        switch_1 = (SwitchCompat) findViewById((R.id.switch_1)) ;
        switch_2 = (SwitchCompat) findViewById((R.id.switch_2)) ;
        switch_3 = (SwitchCompat) findViewById((R.id.switch_3)) ;
        switch_4 = (SwitchCompat) findViewById((R.id.switch_4)) ;
        switch_5 = (SwitchCompat) findViewById((R.id.switch_5)) ;
        switch_6 = (SwitchCompat) findViewById((R.id.switch_6)) ;

        preferences = getSharedPreferences("PREFS", 0);
        stateSwitch1 = preferences.getBoolean("switch1", false);
        stateSwitch1 = preferences.getBoolean("switch2", false);
        stateSwitch1 = preferences.getBoolean("switch3", false);
        stateSwitch1 = preferences.getBoolean("switch4", false);
        stateSwitch1 = preferences.getBoolean("switch5", false);
        stateSwitch1 = preferences.getBoolean("switch6", false);

        switch_1.setChecked(stateSwitch1);
        switch_2.setChecked(stateSwitch2);
        switch_3.setChecked(stateSwitch3);
        switch_4.setChecked(stateSwitch4);
        switch_5.setChecked(stateSwitch5);
        switch_6.setChecked(stateSwitch6);

        switch_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch1 = !stateSwitch1;
                switch_1.setChecked(stateSwitch1);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch1", stateSwitch1);
                editor.apply();
            }
        });

        switch_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch2 = !stateSwitch2;
                switch_2.setChecked(stateSwitch2);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch2", stateSwitch2);
                editor.apply();
            }
        });

        switch_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch3 = !stateSwitch3;
                switch_3.setChecked(stateSwitch3);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch3", stateSwitch3);
                editor.apply();
            }
        });

        switch_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch4 = !stateSwitch4;
                switch_4.setChecked(stateSwitch4);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch4", stateSwitch4);
                editor.apply();
            }
        });

        switch_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch5 = !stateSwitch5;
                switch_5.setChecked(stateSwitch5);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch5", stateSwitch5);
                editor.apply();
            }
        });

        switch_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch6 = !stateSwitch6;
                switch_6.setChecked(stateSwitch6);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("switch6", stateSwitch6);
                editor.apply();
            }
        });

    }
}