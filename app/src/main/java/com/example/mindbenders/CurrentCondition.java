package com.example.mindbenders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CurrentCondition extends AppCompatActivity {

    EditText patientbednochange,patientivnamechange,patientivfinalvaluechange,patientivcurrentvaluechange,patientmedichange;
    Button changesinthebottles;
    List<Appointmentpatient1> appointment1;
    DatabaseReference databasepatient1;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_condition);


        patientbednochange = (EditText) findViewById(R.id.editTextbednochanged);
        patientivnamechange = (EditText) findViewById(R.id.editTextpatientivnamechanged);
        patientivfinalvaluechange = (EditText) findViewById(R.id.editTextpatientivfinalvaluechanged);
        patientivcurrentvaluechange = (EditText) findViewById(R.id.editTextpatientcurrentivmlchanged);
        changesinthebottles = (Button) findViewById(R.id.changethebottle);
        patientmedichange=(EditText)findViewById(R.id.editTextpatientmedcondchanged);


        databasepatient1 = FirebaseDatabase.getInstance().getReference("Patient");

        appointment1 = new ArrayList<>();


        changesinthebottles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chathbot();
            }
        });

    }
    private void chathbot() {
        //getting the values to save
        String bednochange = patientbednochange.getText().toString().trim();
        String ivnamechange=patientivnamechange.getText().toString().trim();
        String ivfinalvaluechange = patientivfinalvaluechange.getText().toString().trim();
        String currentivchange = patientivcurrentvaluechange.getText().toString().trim();
        String medicalconditionchange = patientmedichange.getText().toString().trim();


        //checking if the value is provided
        if (!TextUtils.isEmpty(bednochange)) {


            //creating an name Object
            Appointmentpatient1 appointmentpatient1 = new Appointmentpatient1(bednochange,ivnamechange,ivfinalvaluechange,currentivchange,medicalconditionchange);

            databasepatient1.child(bednochange).setValue(appointmentpatient1);
            //setting edittext to blank again

            patientmedichange.setText("");
            patientivcurrentvaluechange.setText("");
            patientivnamechange.setText("");
            patientivfinalvaluechange.setText("");
            patientbednochange.setText("");
            //displaying a success toast
            Toast.makeText(this,  "Patient record:" + patientbednochange.getText().toString() + " is changed successfully", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_LONG).show();
        }
    }
}