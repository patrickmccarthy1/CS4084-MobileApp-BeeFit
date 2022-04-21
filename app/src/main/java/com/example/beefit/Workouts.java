package com.example.beefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Workouts extends AppCompatActivity {
    private ImageView return_arrow;
    private TextView workout_title;
    private EditText create_workout;
    private Button add_workout_button;
    private  ListView workouts_list;

    private ArrayList<String> workouts;
    private ArrayAdapter<String> adapter;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);

        initView();



        return_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToMainActivity();
            }
        });

        add_workout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = create_workout.getText().toString();

                if(name == null || name.length() == 0) {
                    Toast.makeText(Workouts.this, "Name Your Workout", Toast.LENGTH_SHORT).show();
                } else {
                    addEntry(name);
                    //reset
                    create_workout.setText("");
                }
            }
        });

        workouts_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                goToCreateExercise();
            }
        });

        //Long press to remove
        workouts_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Workouts.this, "Removed " + workouts.get(i), Toast.LENGTH_SHORT).show();
                removeEntry(i);
                return false;
            }
        });
    }

    private void addEntry(String entry) {
        workouts.add(entry);
        workouts_list.setAdapter(adapter);
        Toast.makeText(Workouts.this, entry + " Added", Toast.LENGTH_SHORT).show();
    }


    private void removeEntry(int remove) {
        workouts.remove(remove);
        workouts_list.setAdapter(adapter);
    }

    private void returnToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToCreateExercise() {
        Intent intent = new Intent(this, CreateExercise.class);
        startActivity(intent);
    }

    private void initView() {
        return_arrow = (ImageView) findViewById(R.id.return_arrow_workouts);
        workout_title = (TextView) findViewById(R.id.user_workout_title);
        create_workout = (EditText) findViewById(R.id.create_workout);
        add_workout_button = (Button) findViewById(R.id.add_workout_button);
        workouts_list = (ListView) findViewById(R.id.workouts_list);
        workouts = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, workouts);
    }

}