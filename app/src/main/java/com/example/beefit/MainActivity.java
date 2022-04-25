package com.example.beefit;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView journal, map, details, createWorkout, exWorkout, stopwatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        journal = (CardView) findViewById(R.id.journal_page);
        map = (CardView) findViewById(R.id.maps_page);
        details = (CardView) findViewById(R.id.Details);
        createWorkout = (CardView) findViewById(R.id.Workout);
        exWorkout = (CardView) findViewById(R.id.Expanded);
        stopwatch = (CardView) findViewById(R.id.buttonPage);

        journal.setOnClickListener(this);
        map.setOnClickListener(this);
        details.setOnClickListener(this);
        createWorkout.setOnClickListener(this);
        exWorkout.setOnClickListener(this);
        stopwatch.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.journal_page:
                i = new Intent(this, MainActivityJournal.class);
                startActivity(i);
                break;

            case R.id.maps_page:
                i = new Intent(this, MainActivityMap.class);
                startActivity(i);
                break;

            case R.id.Details:
                i = new Intent(this, Details.class);
                startActivity(i);
                break;

            case R.id.Workout:
                i = new Intent(this, Workouts.class);
                startActivity(i);
                break;

            case R.id.Expanded:
                i = new Intent(this, LoginActivity1.class);
                startActivity(i);
                break;

            case R.id.buttonPage:
                i = new Intent(this, stopwatch.class);
                startActivity(i);
                break;
        }
    }
}