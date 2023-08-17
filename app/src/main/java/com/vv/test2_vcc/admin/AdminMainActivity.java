package com.vv.test2_vcc.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.vv.test2_vcc.LoginDashBoard;
import com.vv.test2_vcc.R;

public class AdminMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        findViewById(R.id.machineInfo);
        findViewById(R.id.uploadDownload).setOnClickListener(v ->{
            startActivity(new Intent(AdminMainActivity.this,UploadDownload.class));
        });
        findViewById(R.id.deleteFiles).setOnClickListener(v ->{
            startActivity(new Intent(AdminMainActivity.this,DeleteFiles.class));
        });
        findViewById(R.id.settings).setOnClickListener(a ->{
            startActivity(new Intent(AdminMainActivity.this,settings.class));
        });
        findViewById(R.id.logout).setOnClickListener(v ->{
            startActivity(new Intent(AdminMainActivity.this, LoginDashBoard.class));
        });
    }
}