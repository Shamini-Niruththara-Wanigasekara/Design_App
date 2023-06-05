package com.example.designapp_final;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import lk.payhere.androidsdk.PHConfigs;
import lk.payhere.androidsdk.PHConstants;
import lk.payhere.androidsdk.PHMainActivity;
import lk.payhere.androidsdk.model.InitRequest;
import lk.payhere.androidsdk.model.Item;

public class PaymentChoice extends AppCompatActivity {
    private Button move;
    private Button move1;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_choice);
        move1 =findViewById(R.id.btnConfirm2);
        move1.setOnClickListener(v -> {
            Intent intent = new Intent(PaymentChoice.this, DashBoardActivity.class);
            startActivity(intent);
        });

        move =findViewById(R.id.btnConfirm);
        move.setOnClickListener(v -> {
            int PAYHERE_REQUEST = 11111;

            InitRequest req = new InitRequest();
            req.setMerchantId("1223256");       // Merchant ID
            req.setCurrency("USD");             // Currency code LKR/USD/GBP/EUR/AUD
            req.setAmount(70.00);             // Final Amount to be charged
            req.setOrderId("230000123");        // Unique Reference ID
            req.setItemsDescription("Avail Cycle");  // Item description title
            req.setCustom1("Highest Grade Aluminium Cycle");
            req.setCustom2("Expert for handling and control");

            //User Details
            req.getCustomer().setFirstName("John");
            req.getCustomer().setLastName("Doe");
            req.getCustomer().setEmail("johndoe@gmail.com");
            req.getCustomer().setPhone("+94771234567");
            req.getCustomer().getAddress().setAddress("No.2, Galle Road");
            req.getCustomer().getAddress().setCity("Colombo");
            req.getCustomer().getAddress().setCountry("Sri Lanka");

            //Optional Params
            req.getCustomer().getDeliveryAddress().setAddress("No.2, Kandy Road");
            req.getCustomer().getDeliveryAddress().setCity("Kadawatha");
            req.getCustomer().getDeliveryAddress().setCountry("Sri Lanka");
            req.getItems().add(new Item(null, "Avail Cycle", 1, 70.0));

            Intent intent = new Intent(getApplicationContext(), PHMainActivity.class);
            intent.putExtra(PHConstants.INTENT_EXTRA_DATA, req);
            PHConfigs.setBaseUrl(PHConfigs.SANDBOX_URL);
            startActivityForResult(intent, PAYHERE_REQUEST);
//            registerForActivityResult(
//                    new ActivityResultContracts.StartActivityForResult(),
//                    new ActivityResultCallback<ActivityResult>() {
//                        @Override
//                        public void onActivityResult(ActivityResult result) {
//                            Log.d("ACTIVITY RESULT", result.toString());
//                        }
//                    }).launch(intent);

        });
    }
}