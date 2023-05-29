package com.example.designapp_final;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designapp_final.Adapters.CycleListAdaptor;
import com.example.designapp_final.data.model.Cycle;

import java.util.ArrayList;

public class CycleList extends AppCompatActivity {
    ArrayList<Cycle> cycleList = new ArrayList<>();
    private static CycleListAdaptor cycleListAdaptor;
    private Button move;

    ListView listView;

    String cycleArr[] = {"Avail AR1 9x3 gears $ 195", "Pinarello Paris 9x3 gears $ 126", "Evil Bike 9x3 gears $ 184", "Canyon Torgue 9x3 gears$ 205"};
    int cycleImages [] = {R.drawable.avail, R.drawable.paris, R.drawable.evil,R.drawable.torque};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyclelist);
        move =findViewById(R.id.buttonCycleList);
        move.setOnClickListener(v -> {
           Intent intent = new Intent(CycleList.this, CycleDetails.class);
           startActivity(intent);
       });

        cycleList.add(new Cycle("Avail AR1 9x3 gears $ 195",this.getResources().getDrawable(R.drawable.avail)));
        cycleList.add(new Cycle("Pinarello Paris 9x3 gears $ 126",this.getResources().getDrawable(R.drawable.paris)));
        cycleList.add(new Cycle("Evil Bike 9x3 gears $ 184",this.getResources().getDrawable(R.drawable.evil)));

        cycleListAdaptor = new CycleListAdaptor(cycleList, getApplicationContext());

        listView = (ListView) findViewById(R.id.list_cycle);
        listView.setAdapter(cycleListAdaptor);
    }
}