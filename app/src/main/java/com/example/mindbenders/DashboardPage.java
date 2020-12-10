package com.example.mindbenders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardPage extends AppCompatActivity {

    Button newmem,ptndet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_page);


        newmem=(Button)findViewById(R.id.btnnewmem);
        ptndet=(Button)findViewById(R.id.btnpatdet);

        newmem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DashboardPage.this, NewMemberRecord.class));
            }
        });

        ptndet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DashboardPage.this, PatientContact.class));
            }
        });

    }
}