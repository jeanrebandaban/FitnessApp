package com.group7.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutDifficulty extends AppCompatActivity {

    Button easybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_difficulty);

    easybtn = findViewById(R.id.easybtn);

    easybtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(WorkoutDifficulty.this, WorkoutDifficultyEasy.class);
            startActivity(intent);
        }
    });
    }
}