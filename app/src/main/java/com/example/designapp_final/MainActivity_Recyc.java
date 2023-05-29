package com.example.designapp_final;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Recyc extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recyc);

        // creating an arraylist

        modelList = new ArrayList<>();
        modelList.add(new Model("Avail", getString(R.string.Avail), R.drawable.avail));
        modelList.add(new Model("Blackhor", getString(R.string.Blackhor), R.drawable.blackhor));
        modelList.add(new Model("Evil", getString(R.string.Evil), R.drawable.evil));
        modelList.add(new Model("Hightwe", getString(R.string.Hightwe), R.drawable.hightwe));
        modelList.add(new Model("Lemonbin", getString(R.string.Lemonbin), R.drawable.lemonbin));
        modelList.add(new Model("Mrdes", getString(R.string.Mrdes), R.drawable.mrdes));
        modelList.add(new Model("Paris", getString(R.string.Paris), R.drawable.paris));
        modelList.add(new Model("Trek", getString(R.string.Trek), R.drawable.trek));
        modelList.add(new Model("Torgue", getString(R.string.Torgue), R.drawable.torque));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);




    }
}