package com.vv.test2_vcc.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.vv.test2_vcc.R;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        findViewById(R.id.manageUser).setOnClickListener(v ->{
            startActivity(new Intent(settings.this,ManageUser.class));
        });
    }
}