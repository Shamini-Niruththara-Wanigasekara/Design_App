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
import com.example.designapp_final.data.model.ReviewAndBook;
import java.util.ArrayList;


public class ReviewBookAdaptor extends ArrayAdapter<ReviewAndBook> implements View.OnClickListener{

    private ArrayList<ReviewAndBook> dataSet;
    Context mContext;

    private static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewVersion;
        TextView textViewApiLevel;
    }

    public ReviewBookAdaptor  (ArrayList<ReviewAndBook> data, Context context) {
        super(context, R.layout.activity_review_book, data);
        this.dataSet = data;
        this.mContext = context;
    }
    @Override
    public void onClick(View view) {

    }
    @Override
    public View getView(int position, View currentView, @NonNull ViewGroup parent) {
        ReviewAndBook reviewAndBook = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (currentView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            currentView = inflater.inflate(R.layout.activity_review_book_view, parent, false);
            viewHolder.textViewName = (TextView) currentView.findViewById(R.id.txt_reviewbook_name);
            viewHolder.imageView = (ImageView) currentView.findViewById(R.id.list_image3);
            result = currentView;
            currentView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) currentView.getTag();
            result = currentView;
        }
        assert reviewAndBook != null;
        viewHolder.textViewName.setText(reviewAndBook.getName());
        System.out.println(reviewAndBook.getImage());
        if(reviewAndBook.getImage() != null){
            viewHolder.imageView.setImageDrawable(reviewAndBook.getImage());
        }

        return currentView;
    }
}


