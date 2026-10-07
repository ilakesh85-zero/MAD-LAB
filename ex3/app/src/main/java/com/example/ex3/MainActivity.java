package com.example.ex3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password, confirmPassword;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect XML views with Java
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        signupButton = findViewById(R.id.signupButton);

        signupButton.setOnClickListener(v -> {

            String user = username.getText().toString().trim();
            String pass = password.getText().toString();
            String confirmPass = confirmPassword.getText().toString();

            // Username validation
            if (user.isEmpty()) {
                username.setError(getString(R.string.enter_username));
                username.requestFocus();
                return;
            }

            if (user.length() < 4) {
                username.setError(getString(R.string.username_too_short));
                username.requestFocus();
                return;
            }

            // Password validation
            if (pass.isEmpty()) {
                password.setError(getString(R.string.enter_password));
                password.requestFocus();
                return;
            }

            if (pass.length() < 6) {
                password.setError(getString(R.string.password_too_short));
                password.requestFocus();
                return;
            }

            // Confirm password validation
            if (confirmPass.isEmpty()) {
                confirmPassword.setError(getString(R.string.confirm_your_password));
                confirmPassword.requestFocus();
                return;
            }

            if (!pass.equals(confirmPass)) {
                confirmPassword.setError(getString(R.string.passwords_do_not_match));
                confirmPassword.requestFocus();
                return;
            }

            // Signup successful
            Toast.makeText(
                    MainActivity.this,
                    getString(R.string.signup_successful),
                    Toast.LENGTH_LONG
            ).show();
        });
    }
}