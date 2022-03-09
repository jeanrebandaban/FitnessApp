package com.group7.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class WorkoutDifficultyEasy extends AppCompatActivity {

    LinearLayout easyexercise1,easyexercise2,easyexercise3,easyexercise4,easyexercise5,easyexercise6,easyexercise7,easyexercise8,rest1,rest2;
    Button donebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_difficulty_easy);

        donebtn = findViewById(R.id.donebtn);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this, WorkoutDone.class));
            }
        });

        easyexercise1 = findViewById(R.id.easyexercise1);
        easyexercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this, Exercise1.class));
            }
        });

        easyexercise2 = findViewById(R.id.easyexercise2);
        easyexercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this,Exercise2.class));
            }
        });


        easyexercise3 = findViewById(R.id.easyexercise3);
        easyexercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this,Exercise3.class));
            }
        });

        easyexercise4 = findViewById(R.id.easyexercise4);
        easyexercise4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this,Exercise4.class));
            }
        });

        easyexercise5 = findViewById(R.id.easyexercise5);
        easyexercise5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this,Exercise5.class));
            }
        });

        easyexercise6 = findViewById(R.id.easyexercise6);
        easyexercise6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this,Exercise6.class));
            }
        });

        easyexercise7 = findViewById(R.id.easyexercise7);
        easyexercise7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this,Exercise7.class));
            }
        });

        easyexercise8 = findViewById(R.id.easyexercise8);
        easyexercise8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this,Exercise8.class));
            }
        });

        rest1 = findViewById(R.id.rest1);
        rest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this,WorkoutRest.class));
            }
        });

        rest2 = findViewById(R.id.rest2);
        rest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyEasy.this,WorkoutRest.class));
            }
        });

    }



}