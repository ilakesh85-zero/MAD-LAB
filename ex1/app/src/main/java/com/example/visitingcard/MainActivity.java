package com.example.visitingcard;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDesignation, etCompany, etPhone, etEmail;
    Button btnShow;
    TextView tvName, tvDesignation, tvCompany, tvPhone, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etDesignation = findViewById(R.id.etDesignation);
        etCompany = findViewById(R.id.etCompany);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);

        btnShow = findViewById(R.id.btnShow);

        tvName = findViewById(R.id.tvName);
        tvDesignation = findViewById(R.id.tvDesignation);
        tvCompany = findViewById(R.id.tvCompany);
        tvPhone = findViewById(R.id.tvPhone);
        tvEmail = findViewById(R.id.tvEmail);

        btnShow.setOnClickListener(view -> {
            tvName.setText(etName.getText().toString());
            tvDesignation.setText(etDesignation.getText().toString());
            tvCompany.setText(etCompany.getText().toString());
            tvPhone.setText("Phone : " + etPhone.getText().toString());
            tvEmail.setText("Email : " + etEmail.getText().toString());
        });
    }
}
