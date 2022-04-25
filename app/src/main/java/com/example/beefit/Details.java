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

public class Details extends AppCompatActivity {
    private ImageView return_arrow;
    private TextView first_name_title, last_name_title, age_title, gender_title, height_title, weight_title,
            goal_title, weight_goal_title, activity_level_title;
    private EditText edit_first_name, edit_last_name, edit_age, edit_height, edit_weight, edit_weight_goal;
    private Spinner gender_dropdown, goal_dropdown, activity_level_dropdown;
    private Button submit_button, cancel_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initViews();

        goal_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                returnToMainPage();
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToMainPage();
            }
        });

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
                returnToMainPage();
            }
        });
    }

    private void updateText() {
        if(goal_dropdown.getSelectedItem().toString().equals("Maintain Weight")) {
            edit_weight_goal.setText(edit_weight.getText().toString());
        } else {
            edit_weight_goal.setText("");
        }
    }

    private void register() {
        if (validateData()) {
            submitToDatabase();
            Toast.makeText(Details.this, "User Information Submitted", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(Details.this, "Please Fill in all Sections", Toast.LENGTH_SHORT).show();
        }
    }

    private void returnToMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //check that data has been inputted for each section
    private boolean validateData() {

        if(edit_first_name.getText().toString().equals("")) {
            first_name_title.setText("First Name (Required)");
            //set text to red so that it stands out
            first_name_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            //for reset
            first_name_title.setText("First Name");
            first_name_title.setTextColor(Color.rgb(0, 0, 0));

        }

        if(edit_last_name.getText().toString().equals("")) {
            last_name_title.setText(" Last Name (Required)");
            //set text to red so that it stands out
            last_name_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            //for reset
            last_name_title.setText("Last Name");
            first_name_title.setTextColor(Color.rgb(0, 0, 0));

        }

        if(edit_age.getText().toString().equals("")) {
            age_title.setText("Age (Required)");
            //set text to red so that it stands out
            age_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            //for reset
            age_title.setText("Age");
            first_name_title.setTextColor(Color.rgb(0, 0, 0));

        }

        if(gender_dropdown.getSelectedItem().toString().equals("Select Gender")) {
            gender_title.setText("Gender (Required)");
            //set text to red so that it stands out
            gender_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            gender_title.setText("Gender");
            first_name_title.setTextColor(Color.rgb(0, 0, 0));
        }

        if(edit_height.getText().toString().equals("")) {
            height_title.setText("Height (Required)");
            //set text to red so that it stands out
            height_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            //for reset
            height_title.setText("Height");
            first_name_title.setTextColor(Color.rgb(0, 0, 0));

        }

        if(edit_weight.getText().toString().equals("")) {
            weight_title.setText("Weight (Required)");
            //set text to red so that it stands out
            weight_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            //for reset
            weight_title.setText("Weight");
            first_name_title.setTextColor(Color.rgb(0, 0, 0));

        }

        if(goal_dropdown.getSelectedItem().toString().equals("Select Goal")) {
            goal_title.setText("Goal (Required)");
            //set text to red so that it stands out
            goal_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            goal_title.setText("Goal");
            first_name_title.setTextColor(Color.rgb(0, 0, 0));
        }

        if(edit_weight_goal.getText().toString().equals("")) {
            weight_goal_title.setText("Weight Goal (Required)");
            //set text to red so that it stands out
            weight_goal_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            //for reset
            weight_goal_title.setText("Weight Goal");
            first_name_title.setTextColor(Color.rgb(0, 0, 0));

        }

        if(activity_level_dropdown.getSelectedItem().toString().equals("Select Activity Level")) {
            activity_level_title.setText("Activity Level (Required)");
            //set text to red so that it stands out
            activity_level_title.setTextColor(Color.rgb(200, 0, 0));
        } else {
            activity_level_title.setText("Activity Level");
            first_name_title.setTextColor(Color.rgb(0, 0, 0));
        }

        if(edit_first_name.getText().toString().equals("") ||
                edit_last_name.getText().toString().equals("") ||
                edit_age.getText().toString().equals("") ||
                gender_dropdown.getSelectedItem().toString().equals("Select Gender") ||
                edit_height.getText().toString().equals("") ||
                edit_weight.getText().toString().equals("") ||
                goal_dropdown.getSelectedItem().toString().equals("Select Goal") ||
                edit_weight_goal.getText().toString().equals("") ||
                activity_level_dropdown.getSelectedItem().toString().equals("Select Activity Level")) {
            return false;
        }
        return true;
    }

    private void initViews() {
        return_arrow = (ImageView) findViewById(R.id.return_arrow_details);

        first_name_title = (TextView) findViewById(R.id.exercise_name_title);
        last_name_title = (TextView) findViewById(R.id.exercise_type_title);
        age_title = (TextView) findViewById(R.id.age_title);
        gender_title = (TextView) findViewById(R.id.gender_title);
        height_title = (TextView) findViewById(R.id.measurement_1_title);
        weight_title = (TextView) findViewById(R.id.measurement_2_title);
        goal_title = (TextView) findViewById(R.id.goal_title);
        weight_goal_title = (TextView) findViewById(R.id.calorie_burned_title);
        activity_level_title = (TextView) findViewById(R.id.activity_level_title);

        edit_first_name = (EditText) findViewById(R.id.edit_exercise_name);
        edit_last_name = (EditText) findViewById(R.id.edit_last_name);
        edit_age = (EditText) findViewById(R.id.edit_age);
        edit_height = (EditText) findViewById(R.id.edit_measurement_1);
        edit_weight = (EditText) findViewById(R.id.edit_measurement_2);
        edit_weight_goal = (EditText) findViewById(R.id.edit_calories_burned);

        gender_dropdown = (Spinner) findViewById(R.id.gender_dropdown);
        goal_dropdown = (Spinner) findViewById(R.id.goal_dropdown);
        activity_level_dropdown = (Spinner) findViewById(R.id.activity_level_dropdown);

        submit_button = (Button) findViewById(R.id.submit_button_exercise);
        cancel_button = (Button) findViewById(R.id.cancel_button_exercise);


    }

    private int calculateBmr(int height, int weight, int age) {
        int bmr = 0;

        /*
         * For women
         * BMR = 655.1 + (9.563 x weight in kg) + (1.850 x height in cm) - (4.676 x age in years)
         *
         * For men
         * BMR = 66.47 + (13.75 x weight in kg) + (5.003 x height in cm) - (6.755 x age in years)
         */

        if(gender_dropdown.getSelectedItem().toString().equals("Female")) {
            bmr = (int) (655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age));

        } else if(gender_dropdown.getSelectedItem().toString().equals("Male")) {
            bmr = (int) (66.47 + (13.75 * weight) + (5.003 * height) - (6.755 * age));
        } else {
            Toast.makeText(Details.this, "BMR Data Unavailable", Toast.LENGTH_SHORT).show();
        }



        return bmr;
    }

    private int calculateAmr(int bmr, String activityLevel) {
        int amr = 0;

        if(activityLevel.equals("Sedentary (little/no exercise)")) {
            amr = (int) (bmr * 1.2);

        } else if(activityLevel.equals("Lightly Active (1 - 3 days/week)")) {
            amr = (int) (bmr * 1.375);

        } else if(activityLevel.equals("Moderately Active (3 - 5 days/week)")) {
            amr = (int) (bmr * 1.55);

        } else if(activityLevel.equals("Active (6 - 7 days/week)")) {
            amr = (int) (bmr * 1.725);

        } else if(activityLevel.equals("Extremely Active (Hard Exercise 6 - 7 days/week)")) {
            amr = (int) (bmr * 1.9);

        } else {
            Toast.makeText(Details.this, "AMR Data Unavailable", Toast.LENGTH_SHORT).show();
        }

        return amr;
    }

    private String createId() {
        String concatName = edit_first_name.getText().toString() + edit_last_name.getText().toString();

        int random = (int) (Math.random() * (9999 - 1000) + 1000);

        int num = Integer.parseInt(edit_height.getText().toString()) + Integer.parseInt(edit_weight.getText().toString())
                + Integer.parseInt(edit_age.getText().toString()) + random;

        String id = concatName + Integer.toString(num);

        return id;
    }

    private void submitToDatabase() {
        String first_name = edit_first_name.getText().toString();
        String last_name = edit_last_name.getText().toString();
        int age = Integer.parseInt(edit_age.getText().toString());
        String gender = gender_dropdown.getSelectedItem().toString();
        int height = (int) Double.parseDouble(edit_height.getText().toString());
        int weight = (int) Double.parseDouble(edit_weight.getText().toString());
        String goal = goal_dropdown.getSelectedItem().toString();
        int weight_goal = (int) Double.parseDouble(edit_weight_goal.getText().toString());
        String activity_level = activity_level_dropdown.getSelectedItem().toString();

        int amr = calculateAmr(calculateBmr(height, weight, age), activity_level);

        if(goal.equals("Gain Weight") || goal.equals("Lose Weight")) {
            //user must consume the volume of calories of someone at their goal weight
            amr = calculateAmr(calculateBmr(height, weight_goal, age), activity_level);
        }

        //String key and Object value, use object so me can store multiple types of values
        HashMap<String, Object> map = new HashMap<>();
        map.put("First Name", first_name);
        map.put("Last Name", last_name);
        map.put("Age", age);
        map.put("Gender", gender);
        map.put("Height", height);
        map.put("Weight", weight);
        map.put("Goal", goal);
        map.put("Weight Goal", weight_goal);
        map.put("Activity Level", activity_level);
        map.put("AMR", amr);

        String id = createId();

        FirebaseDatabase.getInstance().getReference().child("User Information").child(id)
                .updateChildren(map);
    }
}