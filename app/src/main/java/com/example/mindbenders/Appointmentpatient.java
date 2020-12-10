package com.example.mindbenders;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Appointmentpatient {

    private String patientid;
    private String patientname;
    private String patientage;
    private String patientdob;
    private String patientphone;
    private String patientaddress,patientbloodgrp,patientgender;
    private String patientheartrate,patientbp;
    private  String patienttemperature;
    private  String patientrespirationrate,patientivname,patientivfinalvalue,patientcurrentiv,patientmedicalcondition;
    public Appointmentpatient(){
        //this constructor is required
    }

    public Appointmentpatient(String patientid, String patientname, String patientage, String patientdob, String patientphone, String patientaddress, String patientbloodgrp, String patientgender, String patientheartrate, String patientbp, String patienttemperature, String patientrespirationrate, String patientivname, String patientivfinalvalue, String patientcurrentiv, String patientmedicalcondition) {
        this.patientid = patientid;
        this.patientname = patientname;
        this.patientage = patientage;
        this.patientdob = patientdob;
        this.patientphone = patientphone;
        this.patientaddress = patientaddress;
        this.patientbloodgrp = patientbloodgrp;
        this.patientgender = patientgender;
        this.patientheartrate = patientheartrate;
        this.patientbp = patientbp;
        this.patienttemperature = patienttemperature;
        this.patientrespirationrate = patientrespirationrate;
        this.patientivname = patientivname;
        this.patientivfinalvalue = patientivfinalvalue;
        this.patientcurrentiv = patientcurrentiv;
        this.patientmedicalcondition = patientmedicalcondition;
    }

    public String getPatientid() {
        return patientid;
    }

    public String getPatientname() {
        return patientname;
    }

    public String getPatientage() {
        return patientage;
    }

    public String getPatientdob() {
        return patientdob;
    }

    public String getPatientphone() {
        return patientphone;
    }

    public String getPatientaddress() {
        return patientaddress;
    }

    public String getPatientbloodgrp() {
        return patientbloodgrp;
    }

    public String getPatientgender() {
        return patientgender;
    }

    public String getPatientheartrate() {
        return patientheartrate;
    }

    public String getPatientbp() {
        return patientbp;
    }

    public String getPatienttemperature() {
        return patienttemperature;
    }

    public String getPatientrespirationrate() {
        return patientrespirationrate;
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

    public String getPatientmedicalcondition() {
        return patientmedicalcondition;
    }
}

