package com.group7.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutDifficulty extends AppCompatActivity {

    Button easybtn,medbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_difficulty);

    easybtn = findViewById(R.id.easybtn);
    medbtn = findViewById(R.id.medbtn);

    easybtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(WorkoutDifficulty.this, WorkoutDifficultyEasy.class);
            startActivity(intent);
        }
    });
    medbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(WorkoutDifficulty.this, WorkoutDifficultyMedium.class);
            startActivity(intent);
        }
    });

    }
}