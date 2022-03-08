package com.group7.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void goNutrition(View v){
        Intent i = new Intent(this.getApplicationContext(), FoodNutrition.class);
        startActivity(i);
    }

    public void viewDay (View v){
        Intent i = new Intent(this.getApplicationContext(), ActivityFNViewDay.class);
        startActivity(i);
    }

    public void goCoaching(View v){
        Intent i = new Intent(this.getApplicationContext(), Coaching.class);
        startActivity(i);
    }

}