package com.group7.fitnessapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class Coaching extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coach_profile);
    }

    public void onCoach1(View v){
        Intent i = new Intent(this, CoachingFitness.class);
        startActivity(i);
    }

    public void onCoach2(View v){
        Intent i = new Intent(this, CoachingFood.class);
        startActivity(i);
    }

    public void onCoach3(View v){
        Intent i = new Intent(this, CoachingHealth.class);
        startActivity(i);
    }

    public void onCoach4(View v){
        Intent i = new Intent(this, CoachingAthletic.class);
        startActivity(i);
    }

    public void onCoach5(View v){
        Intent i = new Intent(this, CoachingXfit.class);
        startActivity(i);
    }

    public void onCoach6(View v){
        Intent i = new Intent(this, CoachingBuild.class);
        startActivity(i);
    }
}
