package com.group7.fitnessapp;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class ReviewMain extends Activity {

    EditText etFeedback;
    RatingBar fRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_main);

        etFeedback = findViewById(R.id.ratingbox);
        fRating = findViewById(R.id.ratingbar);

    }

    public void doSubmit(View v) {
        float rating = fRating.getRating();
        String feedback = etFeedback.getText().toString();
        DBaseReviewTest db = new DBaseReviewTest(this);
        db.open();
        db.add(rating, feedback);
        db.close();

        Dialog d = new Dialog(this);
        d.setTitle("Message");
        TextView tv = new TextView(this);
        tv.setText("Your review has been recorded");
        d.setContentView(tv);
        d.show();
    }

    public void doBack(View v) {
        finish();
    }
}