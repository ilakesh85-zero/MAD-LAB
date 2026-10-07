package com.example.ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements SensorEventListener {

    TextView tvX, tvY;

    SensorManager sensorManager;
    Sensor accelerometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvX = findViewById(R.id.tvX);
        tvY = findViewById(R.id.tvY);


        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(
                Sensor.TYPE_ACCELEROMETER
        );

    }


    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(
                this,
                accelerometer,
                SensorManager.SENSOR_DELAY_NORMAL
        );
    }


    @Override
    protected void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        float x = event.values[0];
        float y = event.values[1];


        tvX.setText("X Value: " + x);
        tvY.setText("Y Value: " + y);

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}