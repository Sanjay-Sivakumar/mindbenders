package com.example.mindbenders;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class IVPatientContact extends AppCompatActivity {

    public ListView listViewBusestime2;
    List<Appointmentpatient1> busestime2;
    DatabaseReference databaseBustime2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_ivpatientcontact);

        databaseBustime2 = FirebaseDatabase.getInstance().getReference("Patient");
        listViewBusestime2=(ListView)findViewById(R.id.listViewappoints);

        busestime2=new ArrayList<>();
    }
    @Override
    protected void onStart() {
        super.onStart();
        databaseBustime2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                busestime2.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Appointmentpatient1 busno2 = postSnapshot.getValue(Appointmentpatient1.class);
                    busestime2.add(busno2);
                }
                Appointmentpatientlist1 BustimeAdapter2 = new Appointmentpatientlist1(IVPatientContact.this, busestime2);
                listViewBusestime2.setAdapter(BustimeAdapter2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
