package com.example.beefit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class stopwatch extends AppCompatActivity {
    //declaring variables
    private int milliseconds;
    private boolean timing;
    private View view;
    private ImageView returnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stopwatch);
        //initialise app
        init();
        //onclick return to mainActivity
        returnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToMain();
            }
        });
    }


    public void startTime(View view){
        this.view = view;
        //starts time
        timing =true;
    }
    public void stopTime(View view){
        this.view = view;
        //stops time
        timing =false;
    }
    public void resetTime(View view){
        this.view = view;
        //stops time
        timing =false;
        //resets time to 0
        milliseconds =0;
    }

    private void init() {
        TextView tView = findViewById(R.id.timer);
        returnMain = (ImageView) findViewById(R.id.return_arrow);
        //instantiating handler to send and process Runnable objects to be executed
        Handler handler;
        handler = new Handler();
        handler.post(new Runnable(){

            @Override
            public void run(){
                //converting milliseconds to seconds and minutes
                int millisecs;
                //milliseconds
                millisecs = milliseconds % 60;
                int secs;
                //seconds
                secs = (milliseconds % 3600)/60;
                int mins;
                //mins
                mins = milliseconds / 3600;
                //hours
                int hours;
                hours= (milliseconds / (3600*60));

                if (!timing) handler.postDelayed(this, 1);
                else {
                    //increments millisecond by 1
                    milliseconds++;
                    //increments 1 every millisecond
                    handler.postDelayed(this, 1);
                }

                //establishing format of timer
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d:%02d",
                        hours,
                        mins,
                        secs,
                        millisecs);
                //setting format of timer to tView
                tView.setText(time);

            }

        });
    }
    private void returnToMain() {
        Intent intent = new Intent(stopwatch.this,MainActivity.class);
        startActivity(intent);
    }

}