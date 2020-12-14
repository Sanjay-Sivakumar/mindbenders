package com.example.mindbenders;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Appointmentpatientlist1 extends ArrayAdapter<Appointmentpatient1> {
    private Activity context;
    List<Appointmentpatient1> busestime1;

    public Appointmentpatientlist1(Activity context, List<Appointmentpatient1> busestime1) {
        super(context, R.layout.layout_appointmentpatient1_list, busestime1);
        this.context = context;
        this.busestime1 = busestime1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_appointmentpatient1_list, null, true);

        TextView textViewname = (TextView) listViewItem.findViewById(R.id.textViewivname);
        TextView textViewage = (TextView) listViewItem.findViewById(R.id.textViewivcurrentvalue1);
        TextView textViewdob = (TextView) listViewItem.findViewById(R.id.textViewivfinalvaluefixed);
        TextView textViewdeprt = (TextView) listViewItem.findViewById(R.id.textViewappointbedno);


        Appointmentpatient1 appointmentpatient = busestime1.get(position);
        textViewname.setText(appointmentpatient.getPatientivname());
        textViewage.setText(appointmentpatient.getPatientcurrentiv());
        textViewdob.setText(appointmentpatient.getPatientivfinalvalue());
        textViewdeprt.setText(appointmentpatient.getPatientid());


        return listViewItem;
    }
}
