package com.group7.fitnessapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityFNViewDay extends Activity {
    private MealPlanDBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fnviewday);

        db = new MealPlanDBase(this);

        Bundle extra = getIntent().getExtras();
        String day = extra.getString("day");

        TextView day_title = (TextView) findViewById(R.id.day_title);
        TextView breakfast_content = (TextView) findViewById(R.id.breakfast_content);
        TextView lunch_content = (TextView) findViewById(R.id.lunch_content);
        TextView dinner_content = (TextView) findViewById(R.id.dinner_content);
        Button done_button = (Button) findViewById(R.id.btnDone);

        String[] mealPlan = getMealPlanByDay(day);
        breakfast_content.setText(mealPlan[1]);
        lunch_content.setText(mealPlan[2]);
        dinner_content.setText(mealPlan[3]);
        done_button.setTag(day);

        if (day.equals("1")) {
            day_title.setText(getString(R.string.d1_fn));
        }
        if (day.equals("2")) {
            day_title.setText(getString(R.string.d2_fn));
        }
        if (day.equals("3")) {
            day_title.setText(getString(R.string.d3_fn));
        }
        if (day.equals("4")) {
            day_title.setText(getString(R.string.d4_fn));
        }
        if (day.equals("5")) {
            day_title.setText(getString(R.string.d5_fn));
        }
        if (day.equals("6")) {
            day_title.setText(getString(R.string.d6_fn));
        }
        if (day.equals("7")) {
            day_title.setText(getString(R.string.d7_fn));
        }
    }
    public String[] getMealPlanByDay(String day){
        db.open();
        String[] mealPlan = db.getMealPlan(day);
        db.close();
        return mealPlan;
    }

    public void mark_done(View v){
        String day = v.getTag().toString();
        db.open();
        db.mark_complete(day);
        db.close();
        Context context = getApplicationContext();
        CharSequence text = "Congratulations! You've completed day " + day + ".";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        finish();
    }

}
