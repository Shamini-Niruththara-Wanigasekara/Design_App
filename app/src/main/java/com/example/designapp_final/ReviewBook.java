package com.example.designapp_final;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.designapp_final.Adapters.ReviewBookAdaptor;
import com.example.designapp_final.data.model.ReviewAndBook;
import java.util.ArrayList;

public class ReviewBook extends AppCompatActivity {
    ArrayList<ReviewAndBook> reviewbookList = new ArrayList<>();
    private static ReviewBookAdaptor reviewBookAdaptor;
    private Button move;

    ListView listView;

    String reviewArr[] = {"Canyon Torgue 9x3gears $ 23", "Pinarollo Paris helmet Safety 45f $ 26", "Lock cable vbrt56 $84"};
    int reviewImages[] = {R.drawable.torque, R.drawable.redhelmet, R.drawable.cable};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_book);
        move =findViewById(R.id.buttonReview);
        move.setOnClickListener(v -> {
            Intent intent = new Intent(ReviewBook.this, MapsActivitySearch.class);
            startActivity(intent);
        });

        reviewbookList.add(new ReviewAndBook("Canyon Torgue 9x3gears $ 23", this.getResources().getDrawable(R.drawable.torque)));
        reviewbookList.add(new ReviewAndBook("Pinarollo Paris helmet Safety 45f $ 26", this.getResources().getDrawable(R.drawable.redhelmet)));
        reviewbookList.add(new ReviewAndBook("Lock cable vbrt56 $84", this.getResources().getDrawable(R.drawable.cable)));

        reviewBookAdaptor = new ReviewBookAdaptor(reviewbookList, getApplicationContext());

        listView = (ListView) findViewById(R.id.list_review);
        listView.setAdapter(reviewBookAdaptor);


    }
}