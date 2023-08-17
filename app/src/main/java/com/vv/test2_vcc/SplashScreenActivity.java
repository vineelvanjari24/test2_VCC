package com.vv.test2_vcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SplashScreenActivity extends AppCompatActivity {
Button beignButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        beignButton=findViewById(R.id.BeignButton);
        beignButton.setOnClickListener(v ->{
            Intent i = new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(i);
        });

    }
}