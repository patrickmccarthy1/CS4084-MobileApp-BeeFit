package com.example.beefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button stopwatch;
    private Button journal;
    private Button map;
    private Button details;
    private Button createWorkout;
    private Button exWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Calling init
        init();
       stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {startStopwatchActivity();}
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {beeMapsActivity();}
        });
        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {startJournalActivity();}
        });
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {details();}
        });
        createWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {createWorkout();}
        });
        exWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {expandedWO();}
        });
    }
    //instantiate intent so button can launch stopwatch
    private void startStopwatchActivity() {
        Intent intent = new Intent(MainActivity.this,stopwatch.class);
        startActivity(intent);
    }
    //instantiate intent so button can launch MapActivity
    private void beeMapsActivity() {
        Intent intent = new Intent(MainActivity.this,MainActivityMap.class);
        startActivity(intent);
    }
    //instantiate intent so button can launch Journal
    private void startJournalActivity() {
        Intent intent = new Intent(MainActivity.this,MainActivityJournal.class);
        startActivity(intent);
    }
    //instantiate intent so button can launch stopwatch
    private void details() {
        Intent intent = new Intent(MainActivity.this,Details.class);
        startActivity(intent);
    }
    //instantiate intent so button can launch MapActivity
    private void createWorkout() {
        Intent intent = new Intent(MainActivity.this,Workouts.class);
        startActivity(intent);
    }

    private void expandedWO() {
        Intent intent = new Intent(MainActivity.this,ExpandedWorkout.class);
        startActivity(intent);
    }
    private void init() {
        stopwatch = (Button) findViewById(R.id.buttonPage);
        journal = (Button) findViewById(R.id.journal_Page);
        map = (Button) findViewById(R.id.maps_Page);
        details = (Button) findViewById(R.id.Details);
        createWorkout = (Button) findViewById(R.id.Workout);
        exWorkout = (Button) findViewById(R.id.Expanded);
    }


    }

