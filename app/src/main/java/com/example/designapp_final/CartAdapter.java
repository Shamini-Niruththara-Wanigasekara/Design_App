package com.example.designapp_final;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.designapp_final.Database.OrderContract;

public class CartAdapter extends CursorAdapter {


    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // getting theviews

        TextView cycleName, yesHelmet, yesAccessory , price, quantity;


        cycleName = view.findViewById(R.id.cycleNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);
        yesHelmet = view.findViewById(R.id.hasHelmet);
        yesAccessory  = view.findViewById(R.id.hasAccessory);
        quantity = view.findViewById(R.id.quantityinOrderSummary);

        // getting the values by first getting the position of their columns

        int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofcycle = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int quantityofcycle = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int hasHelmet = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_HELMET);
        int hasAccessory = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_ACCESSORY);


        String nameofcycle = cursor.getString(name);
        String pricesofcycle = cursor.getString(priceofcycle);
        String quantitysofcycle = cursor.getString(quantityofcycle);
        String yeshasHelmet = cursor.getString(hasHelmet);
        String yeshasAccessory = cursor.getString(hasAccessory);


        cycleName.setText(nameofcycle);
        price.setText(pricesofcycle);
        yesHelmet.setText(yeshasHelmet);
        yesAccessory.setText(yeshasAccessory);
        quantity.setText(quantitysofcycle);





    }
}
