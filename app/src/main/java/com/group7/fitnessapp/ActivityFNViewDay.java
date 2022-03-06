package com.group7.fitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityFNViewDay extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fnviewday);

        Bundle extra = getIntent().getExtras();
        String day = extra.getString("day");

        TextView breakfast_content = (TextView) findViewById(R.id.breakfast_content);
        TextView lunch_content = (TextView) findViewById(R.id.lunch_content);
        TextView dinner_content = (TextView) findViewById(R.id.dinner_content);
        if (day.equals("1")) {
            breakfast_content.setText(getString(R.string.d1_bf_content));
            lunch_content.setText(getString(R.string.d1_lunch_content));
            dinner_content.setText(getString(R.string.d1_dinner_content));
        }
        if (day.equals("2")) {
            breakfast_content.setText(getString(R.string.d2_bf_content));
            lunch_content.setText(getString(R.string.d2_lunch_content));
            dinner_content.setText(getString(R.string.d2_dinner_content));
        }
        if (day.equals("3")) {
            breakfast_content.setText(getString(R.string.d3_bf_content));
            lunch_content.setText(getString(R.string.d3_lunch_content));
            dinner_content.setText(getString(R.string.d3_dinner_content));
        }
        if (day.equals("4")) {
            breakfast_content.setText(getString(R.string.d4_bf_content));
            lunch_content.setText(getString(R.string.d4_lunch_content));
            dinner_content.setText(getString(R.string.d4_dinner_content));
        }
        if (day.equals("5")) {
            breakfast_content.setText(getString(R.string.d5_bf_content));
            lunch_content.setText(getString(R.string.d5_lunch_content));
            dinner_content.setText(getString(R.string.d5_bf_content));
        }
        if (day.equals("6")) {
            breakfast_content.setText(getString(R.string.d6_bf_content));
            lunch_content.setText(getString(R.string.d6_lunch_content));
            dinner_content.setText(getString(R.string.d6_dinner_content));
        }
        if (day.equals("7")) {
            breakfast_content.setText(getString(R.string.d7_bf_content));
            lunch_content.setText(getString(R.string.d7_lunch_content));
            dinner_content.setText(getString(R.string.d7_dinner_content));
        }
    }
}
