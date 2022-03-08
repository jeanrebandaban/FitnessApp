package com.group7.fitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FoodNutrition extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodnutrition);
    }

    public void viewDay (View v){
        Intent i = new Intent(this.getApplicationContext(), ActivityFNViewDay.class);
        i.putExtra("day", v.getTag().toString());
        startActivity(i);
    }
}
