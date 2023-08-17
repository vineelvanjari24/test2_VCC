package com.vv.test2_vcc.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.vv.test2_vcc.DBHelper.AdminLoginDBHelper;
import com.vv.test2_vcc.R;

public class AdminCreateActivity extends AppCompatActivity {
EditText username,password,reEnterPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_create);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        reEnterPassword=findViewById(R.id.reEnterPassword);
        AdminLoginDBHelper AdminLoginDB = new AdminLoginDBHelper(AdminCreateActivity.this);
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
            else if(AdminLoginDB.userNameCheck(usernameString))
                Toast.makeText(this, "Username already exists .. Try another name ", Toast.LENGTH_SHORT).show();
            else {
                AdminLoginDB.insert(usernameString,passwordString);
                Toast.makeText(this, "Account created Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminCreateActivity.this, AdminLoginActivity.class));
            }
        });
        AdminLoginDB.close();
    }
}