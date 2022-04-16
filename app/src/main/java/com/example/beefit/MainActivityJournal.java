package com.example.beefit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityJournal extends AppCompatActivity implements View.OnClickListener {
    //declaration of variables
    LinearLayout layoutList;
    Button buttonAdd;
    Button buttonSubmit;
    //Declaration of arrayLists
    List<String> calList;
    ArrayList<Journal> journalList;

    {
        calList = new ArrayList<>();
        journalList = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutList = findViewById(R.id.layout_list);

        buttonAdd = findViewById(R.id.add_button);
        //response to add button click
        buttonAdd.setOnClickListener(this);

        buttonSubmit = findViewById(R.id.submit_button);
        //response to submit button click
        buttonSubmit.setOnClickListener(this);

        //ArrayList with hardcoded values for calories spinner
        for (String s : Arrays.asList("calories","0cal" , "25cal","50cal", "75cal","100cal",
                "125cal", "150cal", "175cal", "200cal", "225cal","250cal", "275cal", "300cal",
                "325cal", "350cal", "375cal", "400cal", "425cal", "450cal","475cal" , "500cal",
                "525cal", "550cal", "575cal", "600cal","625cal", "650cal", "675cal", "700cal",
                "725cal", "750cal", "775cal", "800cal", "825cal","850cal", "875cal", "900cal",
                "925cal", "950cal","975cal", "1000cal")) {
            calList.add(s);
        }
    }

    @Override
    public void onClick(View Menu){

        switch (Menu.getId()) {

            case R.id.add_button:
                //call add view method
                addView();
                break;

            case R.id.submit_button:
                if (!ValidView()) {
                } else {
                    //instantiate intent so submit button can launch recyclerView adapter
                    Intent intent = new Intent(MainActivityJournal.this, ActivityFoodJournal.class);
                    Bundle bundle = new Bundle();
                    //accepts objects that implement Serializable
                    bundle.putSerializable("list", journalList);
                    //adds extended data to the intent
                    intent.putExtras(bundle);
                    //instance of activity is started and passed to the intent
                    startActivity(intent);
                }
                break;
        }

    }

    private boolean ValidView() {
        //remove all of the elements from the journalList
        journalList.clear();
        boolean result = true;
        //loop to return views
        for (int i = 0; i < layoutList.getChildCount(); i++) {

            View foodView;
            //Returns the view at the specified position
            foodView = layoutList.getChildAt(i);
            //editText boxs for food and nutrients
            EditText editTextName;
            editTextName = (EditText)foodView.findViewById(R.id.edit_food);

            EditText editTextPro;
            editTextPro = (EditText)foodView.findViewById(R.id.edit_Pro);

            EditText editTextFat;
            editTextFat = (EditText)foodView.findViewById(R.id.edit_Fat);

            EditText editTextCarbs;
            editTextCarbs = (EditText)foodView.findViewById(R.id.edit_Carbs);

            EditText editTextFibre;
            editTextFibre = (EditText)foodView.findViewById(R.id.edit_Fib);

            EditText editTextSugar;
            editTextSugar = (EditText)foodView.findViewById(R.id.edit_Sug);
            //spinner for calories
            AppCompatSpinner spinner;
            spinner = (AppCompatSpinner) foodView.findViewById(R.id.spinner_cal);

            Journal foodItem = new Journal();
            //returning strings representing the editText box
            if (editTextName.getText().toString().equals("")) {
            } else {
                foodItem.setFoodName(editTextName.getText().toString());
            }

            if (editTextPro.getText().toString().equals("")) {
            } else {
                foodItem.setFoodPro(editTextPro.getText().toString());
            }

            if (editTextFat.getText().toString().equals("")) {
            } else {
                foodItem.setFoodFat(editTextFat.getText().toString());
            }

            if (editTextCarbs.getText().toString().equals("")) {
            } else {
                foodItem.setFoodCarbs(editTextCarbs.getText().toString());
            }

            if (editTextFibre.getText().toString().equals("")) {
            } else {
                foodItem.setFoodFibre(editTextFibre.getText().toString());
            }

            if (editTextSugar.getText().toString().equals("")) {
            } else {
                foodItem.setFoodSugar(editTextSugar.getText().toString());
            }
            //returning item position of spinner
            if (spinner.getSelectedItemPosition() == 0) {
            } else {
                foodItem.setFoodCal(calList.get(spinner.getSelectedItemPosition()));
            }

            journalList.add(foodItem);
        }
        return true;
    }

    private void addView() {

        View foodView;
        //inflated from row_add_food XML layout file
        foodView = getLayoutInflater().inflate(R.layout.row_add_food, null, false);

        EditText editText;
        editText = (EditText) foodView.findViewById(R.id.edit_food);
        EditText editProText;
        editProText = (EditText) foodView.findViewById(R.id.edit_Pro);
        EditText editFatText;
        editFatText = (EditText) foodView.findViewById(R.id.edit_Fat);
        EditText editCarbsText;
        editCarbsText = (EditText) foodView.findViewById(R.id.edit_Carbs);
        EditText editFibreText;
        editFibreText = (EditText) foodView.findViewById(R.id.edit_Fib);
        EditText editSugarText;
        editSugarText = (EditText) foodView.findViewById(R.id.edit_Sug);


        AppCompatSpinner spinner;
        spinner = (AppCompatSpinner) foodView.findViewById(R.id.spinner_cal);

        ImageView imageClose;
        imageClose = (ImageView) foodView.findViewById(R.id.image_remove);

        ArrayAdapter arrayAdapter;
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, calList);
        spinner.setAdapter(arrayAdapter);

        //image deletes row that has been added if clicked
        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View Menu) {
                DeleteView(foodView);
            }
        });

        layoutList.addView(foodView);
    }
    //method to remove row
    public void DeleteView(View view){

        layoutList.removeView(view);

    }
}