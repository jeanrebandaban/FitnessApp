package com.group7.fitnessapp;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    String EmailHolder;
    TextView Email;
    Button LogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Email = (TextView)findViewById(R.id.textView1);
        LogOut = (Button)findViewById(R.id.button1);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        EmailHolder = intent.getStringExtra(LoginActivity.UserEmail);

        // Setting up received email to TextView.
        Email.setText(Email.getText().toString()+ EmailHolder);

        // Adding click listener to Log Out button.
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(DashboardActivity.this,"Log Out Successful", Toast.LENGTH_LONG).show();

            }
        });

    }
}