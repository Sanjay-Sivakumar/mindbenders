package com.example.mindbenders;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Appointmentpatient1 {

    private String patientid;
    private  String patientivname,patientivfinalvalue,patientcurrentiv,patientmedicondition;

    public Appointmentpatient1(){
        //this constructor is required
    }

    public Appointmentpatient1(String patientid, String patientivname, String patientivfinalvalue, String patientcurrentiv, String patientmedicondition) {
        this.patientid = patientid;
        this.patientivname = patientivname;
        this.patientivfinalvalue = patientivfinalvalue;
        this.patientcurrentiv = patientcurrentiv;
        this.patientmedicondition = patientmedicondition;
    }

    public String getPatientid() {
        return patientid;
    }

    public String getPatientivname() {
        return patientivname;
    }

    public String getPatientivfinalvalue() {
        return patientivfinalvalue;
    }

    public String getPatientcurrentiv() {
        return patientcurrentiv;
    }

    public String getPatientmedicondition() {
        return patientmedicondition;
    }
}
