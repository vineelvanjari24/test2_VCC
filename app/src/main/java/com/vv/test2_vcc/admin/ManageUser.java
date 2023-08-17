package com.vv.test2_vcc.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.vv.test2_vcc.R;
import com.vv.test2_vcc.agent.AgentCreateActivity;

public class ManageUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user);
        findViewById(R.id.createUserAccount).setOnClickListener(v ->{
            startActivity(new Intent(ManageUser.this, AgentCreateActivity.class));
        });
    }
}