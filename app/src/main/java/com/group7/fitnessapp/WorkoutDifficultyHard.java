package com.group7.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class WorkoutDifficultyHard extends AppCompatActivity {

    LinearLayout easyexercise1,easyexercise2,easyexercise3,easyexercise4,easyexercise5,easyexercise6,easyexercise7,easyexercise8,easyexercise9,easyexercise10,easyexercise11,
            easyexercise12,easyexercise13,easyexercise14,easyexercise15,rest1,rest2,rest3;
    Button donebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_difficulty_hard);

        donebtn = findViewById(R.id.donebtn);
        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this, WorkoutDone.class));
            }
        });

        easyexercise1 = findViewById(R.id.easyexercise1);
        easyexercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this, Exercise1.class));
            }
        });

        easyexercise2 = findViewById(R.id.easyexercise2);
        easyexercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise2.class));
            }
        });


        easyexercise3 = findViewById(R.id.easyexercise3);
        easyexercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise3.class));
            }
        });

        easyexercise4 = findViewById(R.id.easyexercise4);
        easyexercise4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise4.class));
            }
        });

        easyexercise5 = findViewById(R.id.easyexercise5);
        easyexercise5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise5.class));
            }
        });

        easyexercise6 = findViewById(R.id.easyexercise6);
        easyexercise6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise6.class));
            }
        });

        easyexercise7 = findViewById(R.id.easyexercise7);
        easyexercise7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise7.class));
            }
        });

        easyexercise8 = findViewById(R.id.easyexercise8);
        easyexercise8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise8.class));
            }
        });

        easyexercise9 = findViewById(R.id.easyexercise9);
        easyexercise9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise9.class));
            }
        });

        easyexercise10 = findViewById(R.id.easyexercise10);
        easyexercise10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise10.class));
            }
        });

        easyexercise11 = findViewById(R.id.easyexercise11);
        easyexercise11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise11.class));
            }
        });

        easyexercise12 = findViewById(R.id.easyexercise12);
        easyexercise12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise12.class));
            }
        });

        easyexercise13 = findViewById(R.id.easyexercise13);
        easyexercise13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise13.class));
            }
        });

        easyexercise14 = findViewById(R.id.easyexercise14);
        easyexercise14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise14.class));
            }
        });

        easyexercise15 = findViewById(R.id.easyexercise15);
        easyexercise15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,Exercise15.class));
            }
        });

        rest1 = findViewById(R.id.rest1);
        rest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,WorkoutRest.class));
            }
        });

        rest2 = findViewById(R.id.rest2);
        rest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,WorkoutRest.class));
            }
        });

        rest3 = findViewById(R.id.rest3);
        rest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutDifficultyHard.this,WorkoutRest.class));
            }
        });

    }



}