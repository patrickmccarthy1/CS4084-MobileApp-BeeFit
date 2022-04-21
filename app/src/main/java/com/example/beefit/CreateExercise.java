package com.example.beefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateExercise extends AppCompatActivity {
    private ImageView return_arrow;
    private TextView exercise_name_title, exercise_type_title, measurement_1_title,
            measurement_2_title,
            calorie_burned_title, measurement_1_units, measurement_2_units, calorie_units;
    private EditText edit_exercise_name, edit_measurement_1, edit_measurement_2,
            edit_calories_burned;
    private Spinner exercise_type_dropdown;
    private Button submit_button, display_button;

    public ArrayList<Exercise> exerciseArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercise);

        initViews();

        exercise_type_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setMetrics();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToExpandedWorkout();
            }
        });

        display_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendArray();
                goToExpandedWorkout();
            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitExercise();
                clearData();
            }
        });
    }

    private void submitExercise() {
        if(validateData()) {
            addToList();
            submitToDatabase();
            Toast.makeText(CreateExercise.this, "Exercise Created",
                    Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(CreateExercise.this, "Please Fill in all Required Sections",
                    Toast.LENGTH_SHORT).show();
        }
    }


    private boolean validateData() {

        if(edit_exercise_name.getText().toString().equals("")) {
            exercise_name_title.setText("Name of Exercise (Required)");
            //set text to red so that it stands out
            exercise_name_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            //for reset
            exercise_name_title.setText("Name of Exercise");
            exercise_name_title.setTextColor(Color.rgb(3, 218, 197));

        }

        if(exercise_type_dropdown.getSelectedItem().toString().equals("Select Gender")) {
            exercise_type_title.setText("Type of Exercise (Required)");
            //set text to red so that it stands out
            exercise_type_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            exercise_type_title.setText("Type of Exercise");
            exercise_type_title.setTextColor(Color.rgb(3, 218, 197));
        }

        if(edit_calories_burned.getText().toString().equals("")) {
            calorie_burned_title.setText("Calories Burned (Required)");
            //set text to red so that it stands out
            calorie_burned_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            //for reset
            calorie_burned_title.setText("Calories Burned");
            calorie_burned_title.setTextColor(Color.rgb(3, 218, 197));

        }

        if(edit_exercise_name.getText().toString().equals("") ||
                exercise_type_dropdown.getSelectedItem().toString().equals("") ||
                edit_calories_burned.getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    private void setMetrics() {
        String type = exercise_type_dropdown.getSelectedItem().toString();

        switch (type) {
            case "Strength Exercise":
                measurement_1_title.setText("Reps");
                measurement_1_units.setText("reps");
                edit_measurement_1.setHint("Reps");
                measurement_2_title.setText("Sets");
                measurement_2_units.setText("sets");
                edit_measurement_2.setHint("Sets");
                break;
            case "Cardio Exercise":
                measurement_1_title.setText("Time");
                measurement_1_units.setText("mins");
                edit_measurement_1.setHint("Time");
                measurement_2_title.setText("Distance");
                measurement_2_units.setText("metres");
                edit_measurement_2.setHint("Distance");
                break;
            case "Abdominal Exercise":
                measurement_1_title.setText("Sets");
                measurement_1_units.setText("sets");
                edit_measurement_1.setHint("Sets");
                measurement_2_title.setText("Time");
                measurement_2_units.setText("secs");
                edit_measurement_2.setHint("Time");
                break;
        }
    }

    private void addToList() {
        String exercise_name = edit_exercise_name.getText().toString();
        String exercise_type = exercise_type_dropdown.getSelectedItem().toString();
        String met1 = edit_measurement_1.getText().toString();
        String met2 = edit_measurement_2.getText().toString();
        String calories_burned = edit_calories_burned.getText().toString();

        Exercise exercise = new Exercise(exercise_name, exercise_type, met1, met2, calories_burned);

        exerciseArrayList.add(exercise);
    }

    private void submitToDatabase() {
        String exercise_name = edit_exercise_name.getText().toString();
        String exercise_type = exercise_type_dropdown.getSelectedItem().toString();
        int calories_burned = Integer.parseInt(edit_calories_burned.getText().toString());

        int reps;
        String time;
        int sets;
        int distance;

        HashMap<String, Object> exercise_map = new HashMap<>();
        exercise_map.put("Exercise Name", exercise_name);
        exercise_map.put("Exercise Type", exercise_type);

        if(exercise_type.equals("Strength Exercise")) {
            reps = Integer.parseInt(edit_measurement_1.getText().toString());
            exercise_map.put("Reps", reps);
            sets = Integer.parseInt(edit_measurement_2.getText().toString());
            exercise_map.put("Sets", sets);
        } else if(exercise_type.equals("Cardio Exercise")) {
            time = edit_measurement_1.getText().toString();
            exercise_map.put("Time", time);
            distance = Integer.parseInt(edit_measurement_2.getText().toString());
            exercise_map.put("Distance", distance);
        } else if(exercise_type.equals("Abdominal Exercise")) {
            time = edit_measurement_1.getText().toString();
            exercise_map.put("Time", time);
            sets = Integer.parseInt(edit_measurement_2.getText().toString());
            exercise_map.put("Sets", sets);
        }

        exercise_map.put("Calories Burned", calories_burned);

    }

    private void initViews() {
        return_arrow = (ImageView) findViewById(R.id.return_arrow_create_exercise);

        exercise_name_title = (TextView) findViewById(R.id.exercise_name_title);
        exercise_type_title = (TextView) findViewById(R.id.exercise_type_title);
        measurement_1_title = (TextView) findViewById(R.id.measurement_1_title);
        measurement_2_title = (TextView) findViewById(R.id.measurement_2_title);
        calorie_burned_title = (TextView) findViewById(R.id.calorie_burned_title);
        measurement_1_units = (TextView) findViewById(R.id.measurement_1_unit);
        measurement_2_units = (TextView) findViewById(R.id.measurement_2_unit);
        calorie_units = (TextView) findViewById(R.id.calorie_units);

        edit_exercise_name = (EditText) findViewById(R.id.edit_exercise_name);
        edit_measurement_1 = (EditText) findViewById(R.id.edit_measurement_1);
        edit_measurement_2 = (EditText) findViewById(R.id.edit_measurement_2);
        edit_calories_burned = (EditText) findViewById(R.id.edit_calories_burned);

        exercise_type_dropdown = (Spinner) findViewById(R.id.exercise_type_dropdown);

        submit_button = (Button) findViewById(R.id.submit_button_exercise);
        display_button = (Button) findViewById(R.id.display_button_exercise);

    }

    private void goToExpandedWorkout() {
        Intent intent = new Intent(this, ExpandedWorkout.class);
        startActivity(intent);
    }


    private void sendArray() {
        Intent intent = new Intent(this, ExpandedWorkout.class);

        intent.putExtra("exerciseArrayList", exerciseArrayList);

        startActivity(intent);
    }

    private void clearData() {
        edit_exercise_name.setText("");
        edit_measurement_1.setText("");
        edit_measurement_2.setText("");
        edit_calories_burned.setText("");
        exercise_type_dropdown.setSelection(0);
    }
}