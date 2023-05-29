package com.example.designapp_final;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CycleBaseadaptor extends BaseAdapter {

    Context context;
    String[] listCycle;
    int[] listImages;
    LayoutInflater inflater;

    public CycleBaseadaptor(Context ctx, String [] Cyclelist, int [] images){
        this.context = ctx;
        this.listCycle = Cyclelist;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return Integer.parseInt(null);
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_cyclelist_view, null);
        TextView txtView = (TextView) convertView.findViewById(R.id.txt_cycle_name);
        ImageView cycleImg = (ImageView) convertView.findViewById(R.id.list_image);
        txtView.setText(listCycle[i]);
        cycleImg.setImageResource(listImages[i]);
        return convertView;
    }
}
