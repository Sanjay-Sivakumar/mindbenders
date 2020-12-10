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

public class NewMemberRecord extends AppCompatActivity {

    EditText patientname,patientage,patientdob,patientphone,patientaddress,patientheartrate,patientbp,patienttemperature,patientrepirationrate;
    EditText patientivname,patientivfinalvalue,patientcurrentiv,patientmedicalcond,patientbedno;
    Spinner patientbloodgrp,patientgender;
    Button addnewpatientdetails;
    List<Appointmentpatient> appointment;
    DatabaseReference databasepatient;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_member_record);

        patientname = (EditText) findViewById(R.id.editTextpatientname);
        patientbedno = (EditText) findViewById(R.id.editTextbedno);
        patientage = (EditText) findViewById(R.id.editTextpatientage);
        patientdob = (EditText) findViewById(R.id.editTextpatientdob);
        patientphone = (EditText) findViewById(R.id.editTextpatientphone);
        patientaddress = (EditText) findViewById(R.id.editTextpatientaddress);
        patientheartrate = (EditText) findViewById(R.id.editTextpatientheartrate);
        patientbp = (EditText) findViewById(R.id.editTextpatientbp);
        patienttemperature = (EditText) findViewById(R.id.editTextpatienttemp);
        patientrepirationrate = (EditText) findViewById(R.id.editTextpatientrespirate);
        patientivname = (EditText) findViewById(R.id.editTextpatientivname);
        patientivfinalvalue = (EditText) findViewById(R.id.editTextpatientivfinalvalue);
        patientcurrentiv = (EditText) findViewById(R.id.editTextpatientcurrentivml);
        patientmedicalcond = (EditText) findViewById(R.id.editTextpatientmedcond);
        patientbloodgrp = (Spinner) findViewById(R.id.patientbloodgrp);
        patientgender =(Spinner) findViewById(R.id.patientgender);
        addnewpatientdetails = (Button) findViewById(R.id.fixtheappointer);

        databasepatient = FirebaseDatabase.getInstance().getReference("Patient");

        appointment = new ArrayList<>();

        addnewpatientdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fixappointment();
            }
        });

    }

    private void fixappointment() {
        //getting the values to save
        String name = patientname.getText().toString().trim();
        String bedno = patientbedno.getText().toString().trim();
        String age = patientage.getText().toString().trim();
        String Dob = patientdob.getText().toString().trim();
        String phone = patientphone.getText().toString().trim();
        String address = patientaddress.getText().toString().trim();
        String heartrate = patientheartrate.getText().toString().trim();
        String bp = patientbp.getText().toString().trim();
        String temperature = patienttemperature.getText().toString().trim();
        String respirationrate = patientrepirationrate.getText().toString().trim();
        String ivname = patientivname.getText().toString().trim();
        String ivfinalvalue = patientivfinalvalue.getText().toString().trim();
        String currentiv = patientcurrentiv.getText().toString().trim();
        String medicalcondition = patientmedicalcond.getText().toString().trim();
        String gender = patientgender.getSelectedItem().toString();
        String bloodgrp = patientbloodgrp.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(bedno)&&!TextUtils.isEmpty(name)) {


            //creating an name Object
            Appointmentpatient appointmentpatient = new Appointmentpatient(bedno,name,age,Dob,phone,address,bloodgrp,gender,heartrate,bp,temperature,respirationrate,ivname,ivfinalvalue,currentiv,medicalcondition);

            databasepatient.child(bedno).setValue(appointmentpatient);
            //setting edittext to blank again
            patientname.setText("");
            patientage.setText("");
            patientdob.setText("");
            patientphone.setText("");
            patientaddress.setText("");
            patientmedicalcond.setText("");
            patientcurrentiv.setText("");
            patientrepirationrate.setText("");
            patientivname.setText("");
            patientivfinalvalue.setText("");
            patienttemperature.setText("");
            patientheartrate.setText("");
            patientbp.setText("");
            //displaying a success toast
            Toast.makeText(this,  "Patient record:" + patientname.getText().toString() + " is created successfully", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_LONG).show();
        }
    }


}