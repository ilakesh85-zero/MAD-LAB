package com.example.ex9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etText = findViewById(R.id.etText);
        final Button btnSpeak = findViewById(R.id.btnSpeak);

        textToSpeech = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = textToSpeech.setLanguage(Locale.ENGLISH);
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(MainActivity.this, R.string.error_lang_not_supported, Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, R.string.error_init_failed, Toast.LENGTH_SHORT).show();
            }
        });

        btnSpeak.setOnClickListener(view -> {
            String text = etText.getText().toString();
            if (text.isEmpty()) {
                Toast.makeText(this, R.string.toast_enter_text, Toast.LENGTH_SHORT).show();
            } else {
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}