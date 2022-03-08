package com.group7.fitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class ActivityFNMedia extends Activity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fn_media);
        videoView = (VideoView) findViewById(R.id.vdo);
    }

    public void doPlay(View v){
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.healtyplate));
//        videoView.setMediaController(new MediaController(this));
        videoView.start();
        videoView.requestFocus();
    }

    public void goNutrition(View v){
        Intent i = new Intent(this.getApplicationContext(), FoodNutrition.class);
        startActivity(i);
    }
}
