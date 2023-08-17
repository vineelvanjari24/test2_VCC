package com.vv.test2_vcc.agent;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.vv.test2_vcc.DBHelper.AgentLoginDBHelper;
import com.vv.test2_vcc.R;
import com.vv.test2_vcc.admin.ManageUser;

public class AgentCreateActivity extends AppCompatActivity {
EditText username,password,reEnterPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_sign_up);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        reEnterPassword=findViewById(R.id.reEnterPassword);
        AgentLoginDBHelper AgentLoginDB = new AgentLoginDBHelper(AgentCreateActivity.this);
        findViewById(R.id.signUp).setOnClickListener(v ->{
            String usernameString=  username.getText().toString();
            String passwordString= password.getText().toString();
            String reEnterPasswordString = reEnterPassword.getText().toString();
            if(usernameString.equals(""))
                Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
            else if(passwordString.equals(""))
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            else if(reEnterPasswordString.equals(""))
                Toast.makeText(this, "Re-Enter Password", Toast.LENGTH_SHORT).show();
            else if(passwordString.length()<8)
                Toast.makeText(this, "Password Should be at least 8 characters ", Toast.LENGTH_SHORT).show();
            else if(!passwordString.equals(reEnterPasswordString))
                Toast.makeText(this, "Password should match", Toast.LENGTH_SHORT).show();
            else if(AgentLoginDB.userNameCheck(usernameString))
                Toast.makeText(this, "Username already exists .. Try another name ", Toast.LENGTH_SHORT).show();
            else {
                AgentLoginDB.insert(usernameString,passwordString);
                Toast.makeText(this, "Account created Successful ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AgentCreateActivity.this, ManageUser.class));
            }
        });
        AgentLoginDB.close();
    }

    }