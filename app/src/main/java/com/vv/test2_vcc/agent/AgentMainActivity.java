package com.vv.test2_vcc.agent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.vv.test2_vcc.LoginDashBoard;
import com.vv.test2_vcc.R;
import com.vv.test2_vcc.admin.AdminMainActivity;
import com.vv.test2_vcc.admin.ManageUser;

public class AgentMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_main);

        findViewById(R.id.savingAccountCollection).setOnClickListener(v ->{
            startActivity(new Intent(AgentMainActivity.this,savingAccountCollection.class));
        });
        findViewById(R.id.savingAccountReports).setOnClickListener(v ->{
            startActivity(new Intent(AgentMainActivity.this,SavingAccountReports.class));
        });
        findViewById(R.id.manageCustomer).setOnClickListener(v ->{
            startActivity(new Intent(AgentMainActivity.this, ManageCustomer.class));
        });
        findViewById(R.id.logout).setOnClickListener(v ->{
            startActivity(new Intent(AgentMainActivity.this, LoginDashBoard.class));
        });
    }
}