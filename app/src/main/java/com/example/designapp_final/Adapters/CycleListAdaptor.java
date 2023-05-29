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
import com.example.designapp_final.data.model.Cycle;

import java.util.ArrayList;
import java.util.List;

public class CycleListAdaptor extends ArrayAdapter<Cycle>  implements View.OnClickListener{

    private ArrayList<Cycle> dataSet;
    Context mContext;

    private static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewVersion;
        TextView textViewApiLevel;
    }

    public CycleListAdaptor(ArrayList<Cycle> data, Context context) {
        super(context, R.layout.activity_cyclelist_view, data);
        this.dataSet = data;
        this.mContext = context;
    }
    @Override
    public void onClick(View view) {

    }
    @Override
    public View getView(int position, View currentView, @NonNull ViewGroup parent) {
        Cycle cycle = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (currentView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            currentView = inflater.inflate(R.layout.activity_cyclelist_view, parent, false);
            viewHolder.textViewName = (TextView) currentView.findViewById(R.id.txt_cycle_name);
            viewHolder.imageView = (ImageView) currentView.findViewById(R.id.list_image);
            result = currentView;
            currentView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) currentView.getTag();
            result = currentView;
        }
        assert cycle != null;
        viewHolder.textViewName.setText(cycle.getName());
        System.out.println(cycle.getImage());
        if(cycle.getImage() != null){
            viewHolder.imageView.setImageDrawable(cycle.getImage());
        }
        return currentView;
    }
}
