package com.example.ex6 ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tvCounter;
    Button btnStart, btnStop;

    int counter = 0;

    Handler handler = new Handler();

    boolean running = false;


    Runnable runnable = new Runnable() {

        @Override
        public void run() {

            if (running) {

                counter++;

                tvCounter.setText(
                        String.valueOf(counter)
                );

                handler.postDelayed(
                        this,
                        1000
                );
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        tvCounter = findViewById(R.id.tvCounter);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);


        btnStart.setOnClickListener(view -> {

            if (!running) {

                running = true;

                handler.post(runnable);

            }

        });


        btnStop.setOnClickListener(view -> {

            running = false;

            handler.removeCallbacks(runnable);

        });

    }


    @Override
    protected void onDestroy() {

        super.onDestroy();

        handler.removeCallbacks(runnable);

    }
}