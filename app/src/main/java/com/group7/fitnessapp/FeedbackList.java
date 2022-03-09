package com.group7.fitnessapp;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FeedbackList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_list);

        TextView tv_list = findViewById(R.id.reviewList);
        DBaseReviewTest db = new DBaseReviewTest(this);
        db.open();
        String recs = db.getAllRecord();
        db.close();

        if (recs.isEmpty()){
            Dialog d = new Dialog(this);
            d.setTitle("Message");
            TextView tv = new TextView(this);
            tv.setText("There are no reviews yet");
            d.setContentView(tv);
            d.show();
        } else {
            tv_list.setText(recs);
        }
    }

    public void doBack(View v){

        finish();
    }
}

