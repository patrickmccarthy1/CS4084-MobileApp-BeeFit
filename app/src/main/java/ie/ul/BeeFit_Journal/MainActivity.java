package ie.ul.BeeFit_Journal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
        //response to button click
        buttonAdd.setOnClickListener(this);

        buttonSubmit = findViewById(R.id.submit_button);
        //response to button click
        buttonSubmit.setOnClickListener(this);

        //ArrayList values for calories spinner
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

                addView();
                break;

            case R.id.submit_button:
                //see if I can get rid of any of these statements
                if (!ValidView()) {
                } else {
                    Intent intent = new Intent(MainActivity.this, ActivityFoodJournal.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list", journalList);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
        }

    }

    private boolean ValidView() {
        journalList.clear();
        boolean result = true;

        for (int i = 0; i < layoutList.getChildCount(); i++) {

            View foodView;
            foodView = layoutList.getChildAt(i);

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

            AppCompatSpinner spinner;
            spinner = (AppCompatSpinner) foodView.findViewById(R.id.spinner_cal);

            Journal foodItem = new Journal();

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


        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteView(foodView);
            }
        });

        layoutList.addView(foodView);
    }

    public void DeleteView(View view){

        layoutList.removeView(view);

    }
}