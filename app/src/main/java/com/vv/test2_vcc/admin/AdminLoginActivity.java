package com.vv.test2_vcc.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vv.test2_vcc.DBHelper.AdminLoginDBHelper;
import com.vv.test2_vcc.R;

public class AdminLoginActivity extends AppCompatActivity {
Button Login1;
EditText adminName,adminPassword;
TextView createAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        createAdmin=findViewById(R.id.createAdmin);
        adminName=findViewById(R.id.adminName);
        adminPassword=findViewById(R.id.adminPassword);
        Login1=findViewById(R.id.Login);
        AdminLoginDBHelper AdminLoginDB = new AdminLoginDBHelper(AdminLoginActivity.this);

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
                else if(AdminLoginDB.userNameCheck(name)){
                    if (AdminLoginDB.passwordCheck(name,password)) {
                        Toast.makeText(getApplicationContext(), "Login Successful ", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(AdminLoginActivity.this, AdminMainActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(AdminLoginActivity.this, "Username and Password didn't match ", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getApplicationContext(), "no user exist .. please enter another name ", Toast.LENGTH_SHORT).show();
            }
        });
        createAdmin.setOnClickListener(w ->{
            Intent i = new Intent(AdminLoginActivity.this,AdminCreateActivity.class);
            startActivity(i);
        });
        AdminLoginDB.close();
    }
}