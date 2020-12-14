package com.example.mindbenders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GeneralWard extends AppCompatActivity {

    Button bednumoneto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_ward);

        bednumoneto=(Button)findViewById(R.id.btntobednumone);
        bednumoneto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(GeneralWard.this, IvCheckingPage.class));
            }
        });
    }
}