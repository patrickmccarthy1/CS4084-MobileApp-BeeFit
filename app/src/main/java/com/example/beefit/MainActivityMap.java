package com.example.beefit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivityMap extends AppCompatActivity {

    private static final String MAP = "MainActivity";
    private ImageView return_arrow;
    private Button buttonMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);
        init();

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {beeMapsActivity();}
        });
        return_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {returnToMainActivity();}
        });
        //Calender view
        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());
        TextView textViewDate = findViewById(R.id.text_view_date);
        textViewDate.setText(currentDate);
    }
    //instantiate intent so button can launch MapActivity
    private void returnToMainActivity() {
        Intent intent = new Intent(MainActivityMap.this,MainActivity.class);
        startActivity(intent);
    }
    //instantiate intent so button can launch MapActivity
    private void beeMapsActivity() {
        Intent intent = new Intent(MainActivityMap.this,beeMaps.class);
        startActivity(intent);
    }
    private void init() {
        buttonMap = (Button) findViewById(R.id.buttonMap);
        return_arrow = (ImageView) findViewById(R.id.return_arrow);
    }

}

