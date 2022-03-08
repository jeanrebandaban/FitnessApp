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
    public void goFNMedia(View v){
        Intent i = new Intent(this.getApplicationContext(), ActivityFNMedia.class);
        startActivity(i);
    }

    public void goCoaching(View v){
        Intent i = new Intent(this.getApplicationContext(), Coaching.class);
        startActivity(i);
    }

    public void goDifficulty(View v){
        Intent i = new Intent(this.getApplicationContext(), WorkoutDifficulty.class);
        startActivity(i);
    }


}