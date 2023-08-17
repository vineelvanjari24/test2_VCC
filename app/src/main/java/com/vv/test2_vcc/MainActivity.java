package com.vv.test2_vcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText agentNumberEditText,agentNameEditText,deviceIDEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deviceIDEditText=findViewById(R.id.deviceIDEditText);
        agentNameEditText=findViewById(R.id.agentNameEditText);
        agentNumberEditText=findViewById(R.id.agentNumberEditText);
        SharedPreferences sharedPreferencesDeviceInfo = getSharedPreferences("Device Info",MODE_PRIVATE);

        deviceIDEditText.setText(sharedPreferencesDeviceInfo.getString("device ID",""));
        if(!deviceIDEditText.getText().toString().equals("")){
            deviceIDEditText.setClickable(false);
            deviceIDEditText.setFocusable(false);
            deviceIDEditText.setFocusableInTouchMode(false);
            deviceIDEditText.setCursorVisible(false);
        }
        agentNameEditText.setText(sharedPreferencesDeviceInfo.getString("agent name",""));
        if(!agentNameEditText.getText().toString().equals("")){
            agentNameEditText.setCursorVisible(false);
            agentNameEditText.setFocusable(false);
            agentNameEditText.setFocusableInTouchMode(false);
            agentNameEditText.setClickable(false);
        }
        agentNumberEditText.setText(sharedPreferencesDeviceInfo.getString("agent number",""));
        if(!agentNumberEditText.getText().toString().equals("")){
            agentNumberEditText.setClickable(false);
            agentNumberEditText.setFocusable(false);
            agentNumberEditText.setFocusableInTouchMode(false);
            agentNumberEditText.setCursorVisible(false);
        }
        sharedPreferencesDeviceInfo.getBoolean("flag",false);
        findViewById(R.id.startButton).setOnClickListener(v ->{
            SharedPreferences.Editor editor =sharedPreferencesDeviceInfo.edit();
            if(deviceIDEditText.getText().toString().equals(""))
                Toast.makeText(this, "Enter Device ID", Toast.LENGTH_SHORT).show();
            else if(agentNameEditText.getText().toString().equals(""))
                Toast.makeText(this, "Enter agent Name", Toast.LENGTH_SHORT).show();
            else if (agentNumberEditText.getText().toString().equals(""))
                Toast.makeText(this, "Enter agent Number", Toast.LENGTH_SHORT).show();
            else{
                editor.putString("device ID",deviceIDEditText.getText().toString());
                editor.putString("agent name",agentNameEditText.getText().toString());
                editor.putString("agent number",agentNumberEditText.getText().toString());
                editor.apply();
                Intent i = new Intent(MainActivity.this,LoginDashBoard.class);
                startActivity(i);


            }
        });

    }
}