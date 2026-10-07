






































































































package com.example.ex10;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvLocation;
    private Button btnLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLocation = findViewById(R.id.tvLocation);
        btnLocation = findViewById(R.id.btnLocation);

        btnLocation.setOnClickListener(v -> {
            // Location logic to be implemented
            tvLocation.setText("Location button clicked");
        });
    }
}
