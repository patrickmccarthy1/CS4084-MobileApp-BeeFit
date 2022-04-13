package ie.ul.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //declaring variables
    private int seconds;
    private boolean timing;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialise app
        init();
    }

    public void startTime(View view){
        this.view = view;
        //starts time
        timing =true;
    }
    public void stopTime(View view){
        this.view = view;
        //stops time
        timing =false;
    }
    public void resetTime(View view){
        this.view = view;
        //stops time
        timing =false;
        //resets time to 0
        seconds =0;
    }

    private void init() {
        TextView tView = findViewById(R.id.timer);
        //instantiating handler to send and process Runnable objects to be executed
        Handler handler;
        handler = new Handler();
        handler.post(new Runnable(){

            @Override
            public void run(){
                //converting hours and minutes to seconds
                int secs;
                //seconds
                secs = seconds % 60;
                int mins;
                //3600/60=60 seconds which is one minute
                mins = (seconds % 3600)/60;
                int hrs;
                //3600 seconds in an hour
                hrs = seconds / 3600;

                if (!timing) handler.postDelayed(this, 1000);
                else {
                    //increments seconds by 1
                    seconds++;
                    //increments 1 second every 1000 milliseconds
                    handler.postDelayed(this, 1000);
                }

                //establishing format of timer
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d",
                        hrs,
                        mins,
                        secs);
                //setting format of timer to tView
                tView.setText(time);

            }

        });
    }

}