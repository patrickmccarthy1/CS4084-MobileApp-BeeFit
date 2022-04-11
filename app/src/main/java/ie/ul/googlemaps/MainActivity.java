package ie.ul.googlemaps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String MAP = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());

        TextView textViewDate = findViewById(R.id.text_view_date);
        textViewDate.setText(currentDate);
    }

    private void init() {
        Button buttonMap = (Button) findViewById(R.id.buttonMap);
        buttonMap.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);

            }
        }));

    }

}

