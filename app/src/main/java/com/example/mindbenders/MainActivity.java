package com.example.mindbenders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button newrecpage,iventerpage,patientdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newrecpage=(Button)findViewById(R.id.btntonewmem);
        iventerpage=(Button)findViewById(R.id.btntoiveenter);

        newrecpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AdminLoginPage.class));
            }
        });

        iventerpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, IvCheckingPage.class));
            }
        });

    }
}