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

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CreateExercise extends AppCompatActivity {
    private ImageView return_arrow;
    private TextView exercise_name_title, exercise_type_title, measurement_1_title,
            measurement_2_title,
            calorie_burned_title, measurement_1_units, measurement_2_units, calorie_units;
    private EditText edit_exercise_name, edit_measurement_1, edit_measurement_2,
            edit_calories_burned;
    private Spinner exercise_type_dropdown;
    private Button submit_button, cancel_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercise);

        initViews();

        //set exercise dropdown
        setExercise_type_dropdown();

        exercise_type_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                updateText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToExpandedWorkout();
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToExpandedWorkout();
            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitExercise();
            }
        });
    }

    private void submitExercise() {
        if(validateData()) {
            submitToDatabase();

            Toast.makeText(CreateExercise.this, "Exercise Created",
                    Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(CreateExercise.this, "Please Fill in all Required Sections",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void updateText() {
        if(exercise_type_dropdown.getSelectedItem().toString().equals("Strength Exercise")) {
            //measurement 1
            measurement_1_title.setText("Reps");
            edit_measurement_1.setHint("Reps");
            measurement_1_units.setText("reps");

            //measurement 2
            measurement_2_title.setText("Sets");
            edit_measurement_2.setHint("Sets");
            measurement_2_units.setText("sets");

        } else if(exercise_type_dropdown.getSelectedItem().toString().equals("Cardio Exercise")) {
            //measurement 1
            measurement_1_title.setText("Time");
            edit_measurement_1.setHint("Time");
            measurement_1_units.setText("mins");

            //measurement 2
            measurement_2_title.setText("Distance");
            edit_measurement_2.setHint("Distance");
            measurement_2_units.setText("metres");

        } else if(exercise_type_dropdown.getSelectedItem().toString().equals("Abdominal Exercise")) {
            //measurement 1
            measurement_1_title.setText("Time");
            edit_measurement_1.setHint("Time");
            measurement_1_units.setText("secs");

            //measurement 2
            measurement_2_title.setText("Sets");
            edit_measurement_2.setHint("Sets");
            measurement_2_units.setText("sets");

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
        cancel_button = (Button) findViewById(R.id.cancel_button_exercise);

    }

    private void returnToExpandedWorkout() {
        Intent intent = new Intent(this, ExpandedWorkout.class);
        startActivity(intent);
    }

    //set exercise dropdown method
    private void setExercise_type_dropdown() {
        Intent receiver = getIntent();

        String type = receiver.getStringExtra("exercise");

        if(type.equals("strength")) {
            exercise_type_dropdown.setSelection(0);
        } else if(type.equals("cardio")) {
            exercise_type_dropdown.setSelection(1);
        } else {
            exercise_type_dropdown.setSelection(2);
        }
    }
}