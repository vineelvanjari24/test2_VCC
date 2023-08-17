package com.vv.test2_vcc.agent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.vv.test2_vcc.R;

public class ManageCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_customer);
        findViewById(R.id.addCustomer).setOnClickListener(v ->{
            startActivity(new Intent(ManageCustomer.this,AddCustomer.class));
        });
    }
}