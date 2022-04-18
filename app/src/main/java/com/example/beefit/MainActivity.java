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
    }
    //instantiate intent so button can launch MapActivity
    private void startStopwatchActivity() {
        Intent intent = new Intent(MainActivity.this,stopwatch.class);
        startActivity(intent);
    }
    //instantiate intent so button can launch MapActivity
    private void beeMapsActivity() {
        Intent intent = new Intent(MainActivity.this,MainActivityMap.class);
        startActivity(intent);
    }
    //instantiate intent so button can launch MapActivity
    private void startJournalActivity() {
        Intent intent = new Intent(MainActivity.this,MainActivityJournal.class);
        startActivity(intent);
    }
    private void init() {
        stopwatch = (Button) findViewById(R.id.buttonPage);
        journal = (Button) findViewById(R.id.journal_Page);
        map = (Button) findViewById(R.id.maps_Page);
    }


    }

