package com.group7.fitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReviewMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_menu);
    }

    public void doFeedback(View v){
        startActivity(new Intent(this, ReviewMain.class));
    }

    public void doReview(View v){
        startActivity(new Intent(this, FeedbackList.class));
    }
}
