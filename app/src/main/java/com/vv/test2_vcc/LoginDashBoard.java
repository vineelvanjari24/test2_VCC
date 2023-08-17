package com.vv.test2_vcc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import com.vv.test2_vcc.admin.AdminLoginActivity;
import com.vv.test2_vcc.agent.AgentLoginActivity;
public class LoginDashBoard extends AppCompatActivity {
CardView admin,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_dash_board);

        findViewById(R.id.admin).setOnClickListener(v ->{
            Intent i = new Intent(LoginDashBoard.this, AdminLoginActivity.class);
            startActivity(i);
        });
        findViewById(R.id.user).setOnClickListener(v ->{
            Intent i = new Intent(LoginDashBoard.this, AgentLoginActivity.class);
            startActivity(i);
        });
    }
}