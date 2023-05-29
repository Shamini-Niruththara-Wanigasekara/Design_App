package com.example.designapp_final;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.designapp_final.Database.OrderContract;

public class LatteActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    // first of all we will get the views that are  present in the layout of info

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, cycleName, cyclePrice;
    CheckBox addHelmet, addAccessory;
    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity  = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        cycleName = findViewById(R.id.cycleNameinInfo);
        cyclePrice = findViewById(R.id.cyclePrice);
        addHelmet = findViewById(R.id.addHelmet);
        addtoCart = findViewById(R.id.addtocart);
        addAccessory = findViewById(R.id.addAccessory);

        // setting the name of drink

        cycleName.setText("Lemonbin");
        imageView.setImageResource(R.drawable.lemonbin);

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LatteActivity.this, SummaryActivity.class);
                startActivity(intent);
                // once this button is clicked we want to save our values in the database and send those values
                // right away to summary activity where we display the order info

                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  price
                int basePrice = 50;
                quantity++;
                displayQuantity();
                int Price = basePrice * quantity;
                String setnewPrice = String.valueOf(Price);
                cyclePrice.setText(setnewPrice);


                // checkBoxes functionality

                int ifCheckBox = CalculatePrice(addHelmet, addAccessory);
                cyclePrice.setText("$ " + ifCheckBox);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 5;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(LatteActivity.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int Price = basePrice * quantity;
                    String setnewPrice = String.valueOf(Price);
                    cyclePrice.setText(setnewPrice);


                    // checkBoxes functionality

                    int ifCheckBox = CalculatePrice(addHelmet, addAccessory);
                    cyclePrice.setText("$ " + ifCheckBox);
                }
            }
        });



    }

    private boolean SaveCart() {

        // getting the values from our views
        String name = cycleName.getText().toString();
        String price = cyclePrice.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        if (addHelmet.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_HELMET, "Has Other colours: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_HELMET, "Has Other colours: NO");

        }

        if (addAccessory.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_ACCESSORY, "Has Gear: YES");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_ACCESSORY, "Has Gear: NO");

        }

        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }

    private int CalculatePrice(CheckBox addHelmet, CheckBox addAccessory) {

        int basePrice = 5;

        if (addHelmet.isChecked()) {
            // add the cost $2
            basePrice = basePrice + 2;
        }

        if (addAccessory.isChecked()) {
            //  cost is $3
            basePrice = basePrice + 3;
        }

        return basePrice * quantity;
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_HELMET,
                OrderContract.OrderEntry.COLUMN_ACCESSORY
        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int hasHelmet = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_HELMET);
            int hasAccessory = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_ACCESSORY);


            String nameofcycle = cursor.getString(name);
            String priceofcycle = cursor.getString(price);
            String quantityofcycle = cursor.getString(quantity);
            String yeshasHelmet = cursor.getString(hasHelmet);
            String yeshasAccessory = cursor.getString(hasAccessory);

            cycleName.setText(nameofcycle);
            cyclePrice.setText(priceofcycle);
            quantitynumber.setText(quantityofcycle);
        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {


        cycleName.setText("");
        cyclePrice.setText("");
        quantitynumber.setText("");

    }
}