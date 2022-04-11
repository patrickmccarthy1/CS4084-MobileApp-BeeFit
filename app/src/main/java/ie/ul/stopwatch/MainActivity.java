package ie.ul.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds;
    private boolean timing;
    private boolean wasTiming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    public void startTime(View view){
       timing =true;
    }
    public void stopTime(View view){
       timing =false;
    }
    public void resetTime(View view){
        timing =false;
        seconds =0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasTiming) {
            timing = true;
        } else {
            return;
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if (timing) {
            wasTiming = true;
            timing = false;
        } else {
            wasTiming = false;
            timing = false;
        }
    }

    private void init() {
        TextView timeView = findViewById(R.id.timer);
        Handler handler = new Handler();
        handler.post(new Runnable(){

            @Override
            public void run(){
                int hrs;
                hrs = seconds / 3600;
                int mins;
                mins = (seconds % 3600)/60;
                int secs;
                secs = seconds % 60;

                String time = String.format(Locale.getDefault(),
                                               "%d:%02d:%02d",
                                                 hrs, mins, secs);
                timeView.setText(time);

                if (!timing) {
                } else {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
                }

        });
    }

}