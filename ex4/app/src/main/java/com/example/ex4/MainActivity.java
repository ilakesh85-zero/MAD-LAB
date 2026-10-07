package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnWallpaper;

    Handler handler = new Handler();

    int[] images = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
    };

    Random random = new Random();

    Runnable wallpaperRunnable = new Runnable() {
        @Override
        public void run() {

            changeWallpaper();

            // Repeat after 30 seconds
            handler.postDelayed(this, 500);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnWallpaper = findViewById(R.id.btnWallpaper);


        btnWallpaper.setOnClickListener(view -> {

            handler.post(wallpaperRunnable);

            Toast.makeText(
                    MainActivity.this,
                    "Wallpaper changing started",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }


    private void changeWallpaper() {

        int index = random.nextInt(images.length);

        Bitmap bitmap = BitmapFactory.decodeResource(
                getResources(),
                images[index]
        );


        WallpaperManager wallpaperManager =
                WallpaperManager.getInstance(this);


        try {

            wallpaperManager.setBitmap(bitmap);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Stop wallpaper changing when app closes
        handler.removeCallbacks(wallpaperRunnable);
    }
}