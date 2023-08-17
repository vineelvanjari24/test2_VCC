package com.vv.test2_vcc.agent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.vv.test2_vcc.R;

public class SavingAccountReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_account_reports);
        findViewById(R.id.dayWiseAccountSummary).setOnClickListener(v ->{
            startActivity(new Intent(SavingAccountReports.this,DayWiseSummery.class));
        });
        findViewById(R.id.monthlyAccountSummary).setOnClickListener(v ->{
            startActivity(new Intent(this,MonthlySummery.class));
        });
    }
}