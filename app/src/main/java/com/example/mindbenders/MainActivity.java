package com.example.mindbenders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView adminpage,generalwardpage,aboutuspage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminpage=(ImageView) findViewById(R.id.btntoadmin);
        generalwardpage=(ImageView) findViewById(R.id.btntogeneralward);
        aboutuspage=(ImageView)findViewById(R.id.btntoaboutus);

        adminpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AdminLoginPage.class));
            }
        });

        generalwardpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, GeneralWard.class));
            }
        });

        aboutuspage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AboutUs.class));
            }
        });


    }
}