package com.vv.test2_vcc.agent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vv.test2_vcc.DBHelper.AdminLoginDBHelper;
import com.vv.test2_vcc.DBHelper.AgentLoginDBHelper;
import com.vv.test2_vcc.R;
import com.vv.test2_vcc.admin.AdminCreateActivity;
import com.vv.test2_vcc.admin.AdminLoginActivity;
import com.vv.test2_vcc.admin.AdminMainActivity;

public class AgentLoginActivity extends AppCompatActivity {
TextView adminName,adminPassword;
Button Login1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_login);
        adminName=findViewById(R.id.adminName);
        adminPassword=findViewById(R.id.adminPassword);
        Login1=findViewById(R.id.Login);
        AgentLoginDBHelper AgentLoginDB = new AgentLoginDBHelper(AgentLoginActivity.this);

        Login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = adminName.getText().toString();
                String password =adminPassword.getText().toString();
                if(name.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else if(AgentLoginDB.userNameCheck(name)){
                    if (AgentLoginDB.passwordCheck(name,password)) {
                        Toast.makeText(getApplicationContext(), "Login Successful ", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(AgentLoginActivity.this, AgentMainActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(AgentLoginActivity.this, "Username and Password didn't match ", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getApplicationContext(), "no user exist .. please enter another name ", Toast.LENGTH_SHORT).show();
            }
        });
        AgentLoginDB.close();
    }
}