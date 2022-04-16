package com.example.beefit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivityMap extends AppCompatActivity {

    private static final String MAP = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Calling init
        init();
        //Calender view
        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());
        TextView textViewDate = findViewById(R.id.text_view_date);
        textViewDate.setText(currentDate);
    }

    private void init() {
        //button click navigates user to google maps
        Button buttonMap = (Button) findViewById(R.id.buttonMap);
        buttonMap.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //instantiate intent so button can launch MapActivity
                Intent intent = new Intent(MainActivityMap.this, MapActivity.class);
                startActivity(intent);

            }
        }));

    }

}

