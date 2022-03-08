package com.group7.fitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FoodNutrition extends Activity {
    private MealPlanDBase db;
    @Override
    public void onResume() {
        super.onResume();
        update_button_colors();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodnutrition);
        db = new MealPlanDBase(this);
        db.open();
        db.addAllMealPlan();
        db.close();

        update_button_colors();
    }

    public void reset_nutrition(View v){
        db.open();
        db.reset_completed();
        db.close();
        finish();
        startActivity(getIntent());
    }

    private void update_button_colors(){
        ImageView day1 = findViewById(R.id.imageView);
        ImageView day2 = findViewById(R.id.imageView2);
        ImageView day3 = findViewById(R.id.imageView3);
        ImageView day4 = findViewById(R.id.imageView4);
        ImageView day5 = findViewById(R.id.imageView5);
        ImageView day6 = findViewById(R.id.imageView6);
        ImageView day7 = findViewById(R.id.imageView7);

        String day1_status = getMealPlanStatus("1");
        String day2_status = getMealPlanStatus("2");
        String day3_status = getMealPlanStatus("3");
        String day4_status = getMealPlanStatus("4");
        String day5_status = getMealPlanStatus("5");
        String day6_status = getMealPlanStatus("6");
        String day7_status = getMealPlanStatus("7");

        if(day1_status.equals("true")){
            day1.setImageResource(R.drawable.day_one_done);
        }
    }

    private String getMealPlanStatus(String day){
        db.open();
        String[] record = db.getMealPlan(day);
        db.close();
        return record[4];
    }

    public void viewDay (View v){
        Intent i = new Intent(this.getApplicationContext(), ActivityFNViewDay.class);
        i.putExtra("day", v.getTag().toString());
        startActivity(i);
    }
}
