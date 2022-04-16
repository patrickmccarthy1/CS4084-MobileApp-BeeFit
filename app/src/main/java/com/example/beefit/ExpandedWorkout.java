package com.example.beefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ExpandedWorkout extends AppCompatActivity {
    private ImageView return_arrow_expanded_workout;
    private TextView workout_title;
    private Button add_strength_button, add_cardio_button, add_abdominal_button;
    private TableLayout strength_table, cardio_table, abdominal_table;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_workout);

        initView();

        setWorkout_title();

        return_arrow_expanded_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToWorkouts();
            }
        });

        add_strength_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createExercise("strength");
            }
        });

        add_cardio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createExercise("cardio");
            }
        });

        add_abdominal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createExercise("abdominal");
            }
        });

    }

    private void returnToWorkouts() {
        Intent intent = new Intent(this, Workouts.class);
        startActivity(intent);
    }


    private void setWorkout_title() {
        Intent receiver = getIntent();

        String title = receiver.getStringExtra("expandedTitle");

        workout_title.setText(title);
    }


    private void createExercise(String type) {
        Intent intent = new Intent(this, CreateExercise.class);

        //send exercise type for use in create exercise
        intent.putExtra("exercise", type);

        startActivity(intent);
    }

    private void initView() {
        return_arrow_expanded_workout = (ImageView) findViewById(R.id.return_arrow_expanded_workout);
        workout_title = (TextView) findViewById(R.id.workout_title);
        add_strength_button = (Button) findViewById(R.id.add_strength_button);
        add_cardio_button = (Button) findViewById(R.id.add_cardio_button);
        add_abdominal_button = (Button) findViewById(R.id.add_abdominal_button);
        strength_table = (TableLayout) findViewById(R.id.strength_table);
        cardio_table = (TableLayout) findViewById(R.id.cardio_table);
        abdominal_table = (TableLayout) findViewById(R.id.abdominal_table);
    }
}