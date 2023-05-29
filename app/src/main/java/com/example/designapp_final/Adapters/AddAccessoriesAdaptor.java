package com.example.designapp_final.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.designapp_final.R;
import com.example.designapp_final.data.model.Accessory;
import java.util.ArrayList;

public class AddAccessoriesAdaptor  extends ArrayAdapter<Accessory> implements View.OnClickListener{
    private ArrayList<Accessory> dataSet;
    Context mContext;
    private static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewVersion;
        TextView textViewApiLevel;
    }
    public AddAccessoriesAdaptor (ArrayList<Accessory> data, Context context) {
        super(context, R.layout.activity_addaccessories, data);
        this.dataSet = data;
        this.mContext = context;
    }
    @Override
    public void onClick(View view) {

    }
    @Override
    public View getView(int position, View currentView, @NonNull ViewGroup parent) {
        Accessory accessory = getItem(position);
        ViewHolder viewHolder;
        final View result;
        if (currentView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            currentView = inflater.inflate(R.layout.activity_add_accessories_view, parent, false);
            viewHolder.textViewName = (TextView) currentView.findViewById(R.id.txt_accessory_name);
            viewHolder.imageView = (ImageView) currentView.findViewById(R.id.list_image2);
            result = currentView;
            currentView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) currentView.getTag();
            result = currentView;
        }
        assert accessory != null;
        viewHolder.textViewName.setText(accessory.getName());
        System.out.println(accessory.getImage());
        if(accessory.getImage() != null){
            viewHolder.imageView.setImageDrawable(accessory.getImage());
        }
        return currentView;
    }
}

