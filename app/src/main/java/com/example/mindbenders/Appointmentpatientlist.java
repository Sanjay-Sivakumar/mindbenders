package com.example.mindbenders;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Appointmentpatientlist extends ArrayAdapter<Appointmentpatient> {
    private Activity context;
    List<Appointmentpatient> busestime;

    public Appointmentpatientlist(Activity context, List<Appointmentpatient> busestime) {
        super(context, R.layout.layout_appointmentpatient_list, busestime);
        this.context = context;
        this.busestime = busestime;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_appointmentpatient_list, null, true);

        TextView textViewname = (TextView) listViewItem.findViewById(R.id.textViewappointername);
        TextView textViewage = (TextView) listViewItem.findViewById(R.id.textViewappointerage);
        TextView textViewdob = (TextView) listViewItem.findViewById(R.id.textViewappointerdob);
        TextView textViewphone = (TextView) listViewItem.findViewById(R.id.textViewappointerphone);
        TextView textViewaddress = (TextView) listViewItem.findViewById(R.id.textViewappointeraddress);
        TextView textViewbloodgrp = (TextView) listViewItem.findViewById(R.id.textViewappointerbloodgrp);
        TextView textViewngender = (TextView) listViewItem.findViewById(R.id.textViewappointergender);
        TextView textViewdeprt = (TextView) listViewItem.findViewById(R.id.textViewappointbedno);


        Appointmentpatient appointmentpatient = busestime.get(position);
        textViewname.setText(appointmentpatient.getPatientname());
        textViewage.setText(appointmentpatient.getPatientage());
        textViewdob.setText(appointmentpatient.getPatientdob());
        textViewphone.setText(appointmentpatient.getPatientphone());
        textViewaddress.setText(appointmentpatient.getPatientaddress());
        textViewbloodgrp.setText(appointmentpatient.getPatientbloodgrp());
        textViewngender.setText(appointmentpatient.getPatientgender());
        textViewdeprt.setText(appointmentpatient.getPatientid());


        return listViewItem;
    }
}
