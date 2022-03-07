package com.group7.fitnessapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CoachingBuild extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coach_profile_build);
    }

    public void onSend(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(CoachingBuild.this);
        View v = getLayoutInflater().inflate(R.layout.coach_dialog, null);

        final EditText message = v.findViewById(R.id.tv_dialog);
        Button cancel = v.findViewById(R.id.btn_cancel);
        Button send = v.findViewById(R.id.btn_send);

        alert.setView(v);

        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message1 = message.getText().toString().trim();

                if (!message1.equals("")){
                    Toast.makeText(getApplicationContext(), "Message Sent.", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), "Please Enter Message.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog.show();
    }
}
