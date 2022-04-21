package com.example.beefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ExpandedWorkout extends AppCompatActivity {
    private ImageView return_arrow_expanded_workout;
    private TextView workout_title;
    private TableLayout strength_table, cardio_table, abdominal_table;

    private ArrayList<Exercise> exerciseList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_workout);

        initView();

        exerciseList = (ArrayList<Exercise>) getIntent().getSerializableExtra("exerciseArrayList");

        for(Exercise exercise : exerciseList) {
            createRow(exercise.getExercise_type(), exercise.getExercise_name(), exercise.getMet1(),
                    exercise.getMet2(), exercise.getCalories_burned());
        }

        return_arrow_expanded_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToWorkouts();
            }
        });

    }

    private void returnToWorkouts() {
        Intent intent = new Intent(this, Workouts.class);
        startActivity(intent);
    }

    private void initView() {
        return_arrow_expanded_workout = (ImageView) findViewById(R.id.return_arrow_expanded_workout);
        workout_title = (TextView) findViewById(R.id.workout_title);
        strength_table = (TableLayout) findViewById(R.id.strength_table);
        cardio_table = (TableLayout) findViewById(R.id.cardio_table);
        abdominal_table = (TableLayout) findViewById(R.id.abdominal_table);
    }

    private void createRow(String exercise_type, String exercise_name, String met_1, String met_2,
                           String calories_burned) {

        TableRow row = new TableRow(this);

        TextView exerciseName = new TextView(this);
        TextView metric1 = new TextView(this);
        TextView metric2 = new TextView(this);
        TextView caloriesBurned = new TextView(this);

        TableRow.LayoutParams exerciseParams = new TableRow.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT , 6.0f);

        TableRow.LayoutParams otherParams = new TableRow.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT , 4.0f);

        exerciseName.setText(exercise_name);
        exerciseName.setGravity(Gravity.CENTER_HORIZONTAL);
        exerciseName.setPadding(10, 10, 10, 10);
        exerciseName.setTextSize(16);
        exerciseName.setLayoutParams(exerciseParams);
        row.addView(exerciseName);

        metric1.setText(met_1);
        metric1.setGravity(Gravity.CENTER_HORIZONTAL);
        metric1.setPadding(10, 10, 10, 10);
        metric1.setTextSize(16);
        metric1.setLayoutParams(otherParams);
        row.addView(metric1);

        metric2.setText(met_2);
        metric2.setGravity(Gravity.CENTER_HORIZONTAL);
        metric2.setPadding(10, 10, 10, 10);
        metric2.setTextSize(16);
        metric2.setLayoutParams(otherParams);
        row.addView(metric2);

        caloriesBurned.setText(calories_burned);
        caloriesBurned.setGravity(Gravity.CENTER_HORIZONTAL);
        caloriesBurned.setPadding(10, 10, 10, 10);
        caloriesBurned.setTextSize(16);
        caloriesBurned.setLayoutParams(otherParams);
        row.addView(caloriesBurned);

        if(exercise_type.equals("Cardio Exercise")) {
            cardio_table.addView(row);
        } else if(exercise_type.equals("Strength Exercise")) {
            strength_table.addView(row);
        } else {
            abdominal_table.addView(row);
        }

    }
}