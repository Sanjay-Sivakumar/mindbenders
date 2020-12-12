package com.example.mindbenders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button dashboard,ivchecker,current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dashboard=(Button)findViewById(R.id.btndashboard);
        ivchecker=(Button)findViewById(R.id.btnivcheck);
        current=(Button)findViewById(R.id.btncurrent);

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, DashboardPage.class));
            }
        });

        ivchecker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, IvCheckingPage.class));
            }
        });

        current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, CurrentCondition.class));
            }
        });


    }
}