package com.example.designapp_final;

import static android.graphics.Color.*;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;

public class SensorActivity extends AppCompatActivity {
    private Accelerometer accelerometer;
    private Gyroscope gyroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        accelerometer = new Accelerometer(this);
        gyroscope = new Gyroscope(this);

        accelerometer.setListener(new Accelerometer.Listener() {
            @Override
            public void onTranslation(float tx, float ty, float tz) {
                if(tx > 1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }
                else if(tx< -1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                }

            }
        });
        gyroscope.setListener(new Gyroscope.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
                if(rx > 1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
                else if(rx< -1.0f)
                {
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }

            }
        });
    }
    @Override
    protected void onResume(){
        super.onResume();

        accelerometer.register();
        gyroscope.register();
    }

    @Override
    protected void onPause(){
        super.onPause();

        accelerometer.unregister();
        gyroscope.unregister();
    }

}