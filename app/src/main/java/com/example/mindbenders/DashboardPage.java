package com.example.mindbenders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DashboardPage extends AppCompatActivity {

    ImageView newmember,patientcontact,ivchangepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_page);


        newmember=(ImageView) findViewById(R.id.btntoaddpat);
        patientcontact=(ImageView) findViewById(R.id.btntopatdetail);
        ivchangepage=(ImageView) findViewById(R.id.btntochangeivbottle);

        newmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DashboardPage.this, NewMemberRecord.class));
            }
        });

        patientcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DashboardPage.this, PatientContact.class));
            }
        });

        ivchangepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DashboardPage.this, CurrentCondition.class));
            }
        });

    }
}