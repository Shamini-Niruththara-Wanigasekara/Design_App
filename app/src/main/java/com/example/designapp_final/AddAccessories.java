package com.example.designapp_final;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.designapp_final.Adapters.AddAccessoriesAdaptor;
import com.example.designapp_final.data.model.Accessory;

import java.util.ArrayList;

public class AddAccessories extends AppCompatActivity {
        ArrayList<Accessory> accessoryList = new ArrayList<>();
        private static AddAccessoriesAdaptor addAccessoriesAdaptor;
        private Button move;

        ListView listView;

        String accessoryArr[] = {"Helmet 15kl Echelon II Safety $ 23", "Pinarollo Paris helmet Safety 45f $ 26", "Lock cable vbrt56 $84", "LED Light philips we4 $ 25"};
        int accessoryImages [] = {R.drawable.whitehelmet, R.drawable.redhelmet, R.drawable.cable,R.drawable.ledlight};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaccessories);
        move =findViewById(R.id.buttonAccessory);
        move.setOnClickListener(v -> {
            Intent intent = new Intent(AddAccessories.this, DashBoardActivity.class);
            startActivity(intent);
        });

        accessoryList.add(new Accessory("Helmet 15kl Echelon II Safety $ 23",this.getResources().getDrawable(R.drawable.whitehelmet)));
        accessoryList.add(new Accessory("Pinarollo Paris helmet Safety 45f $ 26",this.getResources().getDrawable(R.drawable.redhelmet)));
        accessoryList.add(new Accessory("Lock cable vbrt56 $84",this.getResources().getDrawable(R.drawable.cable)));
        accessoryList.add(new Accessory("LED Light philips we4 $ 25",this.getResources().getDrawable(R.drawable.ledlight)));

        addAccessoriesAdaptor = new AddAccessoriesAdaptor(accessoryList, getApplicationContext());

        listView = (ListView) findViewById(R.id.list_accessory);
        listView.setAdapter(addAccessoriesAdaptor);


    }
}
