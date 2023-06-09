package com.example.designapp_final;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.designapp_final.models.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    FloatingActionButton fab;


    @SuppressLint("InflateParams")
    @Override
    public void setContentView(View view){
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById((R.id.activitycontainer));
        container.addView(view);
        super.setContentView(drawerLayout);
        fab = findViewById(R.id.fab);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.menu_drawer_open, R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(view == null){
            startActivity(new Intent(this, MapsActivity.class));
            overridePendingTransition(0,0);
            navigationView.setCheckedItem(R.id.nav_mylocation);
        }
        View header = navigationView.getHeaderView(0);
        ImageView navImage = (ImageView) header.findViewById(R.id.navImage);
        TextView navName = (TextView) header.findViewById(R.id.navName);
        TextView navEmail = (TextView) header.findViewById(R.id.navEmail);

        try {
            UserDatabaseHelper userDatabaseHelper = new UserDatabaseHelper(this);
            User user = userDatabaseHelper.getUser();

            if(user == null){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
            assert user != null;
            navName.setText(user.getName());
            navEmail.setText(user.getEmail());
            byte[] imageByte = user.getImage();

            if(imageByte != null){
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
                navImage.setImageBitmap(bitmap);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrawerBaseActivity.this, UploadActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        Log.d("MENU ITEM :", item.toString());
        switch (item.getItemId()){
            case R.id.nav_mylocation:
                startActivity(new Intent(this, MapsActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_navlocation:
                startActivity(new Intent(this, PlacesNavigation.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_serachlocation:
                startActivity(new Intent(this, MapsActivitySearch.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_info:
                startActivity(new Intent(this, AboutActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_exit:
                logoutMenu(DrawerBaseActivity.this);
                break;
        }
        return false;
    }

    public void logoutMenu(DrawerBaseActivity drawerBaseActivity){
        AlertDialog.Builder builder = new AlertDialog.Builder(drawerBaseActivity);
        builder.setTitle("Log out");
        builder.setMessage("Are you sure you want to exit");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            Intent intent = new Intent(DrawerBaseActivity.this, MainActivity.class);
            startActivity(intent);
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        builder.show();
    }


    protected void allocateActivityTitle(String titleString){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(titleString);
        }
    }
//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
}