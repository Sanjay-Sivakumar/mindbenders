package com.example.mindbenders;


import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Appointmentpatientlist1 extends AppCompatActivity {
    DatabaseReference databaseivrecord1;
    Appointmentpatient1 member1;
    TextView bedno2,currentivchanging1,ivnmaechanging1,fixedivvaluee1;
    int ids1=0;
    MediaPlayer notify1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_appointmentpatient1_list);

        member1 = new Appointmentpatient1();
        databaseivrecord1 = FirebaseDatabase.getInstance().getReference("Patient");
        bedno2=(TextView)findViewById(R.id.textViewappointbedno2);
        ivnmaechanging1=(TextView)findViewById(R.id.textViewivname2);
        currentivchanging1=(TextView)findViewById(R.id.textViewivcurrentvalue2);
        fixedivvaluee1=(TextView)findViewById(R.id.textViewivfinalvaluefixed2);
        databaseivrecord1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    ids1 = (int) dataSnapshot.getChildrenCount();
                }

                List<String> keys = new ArrayList<>();
                for (DataSnapshot keynode : dataSnapshot.getChildren()) {
                    keys.add(keynode.getKey());
                    Appointmentpatient1 member = keynode.getValue(Appointmentpatient1.class);

                    String n = member1.getPatientcurrentiv();
                    String n1 = member1.getPatientivfinalvalue();
                    String bednumbersecond=member1.getPatientid();
                    String ivnmaecange1=member1.getPatientivname();

                    bedno2.setText(bednumbersecond);
                    ivnmaechanging1.setText(ivnmaecange1);
                    currentivchanging1.setText(n);
                    fixedivvaluee1.setText(n1);

                    try {
                        int number = Integer.parseInt(n);
                        int number1 = Integer.parseInt(n1);
                        if (number < number1) {
                            notification(member.getPatientid().toString(), member1.getPatientmedicondition().toString(), member1.getPatientcurrentiv().toString());
                            Toast.makeText(Appointmentpatientlist1.this, "Currently Value Is  Updated From IV Bottle", Toast.LENGTH_LONG).show();
                        }
                    } catch (NumberFormatException e) {

                    }


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void notification(String nBedNo, String nname, String nIVreading){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("n", "n", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }

        if (!nIVreading.isEmpty()){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "n")
                    .setContentText("Code Sphere")
                    .setSmallIcon(R.drawable.ic_notifications_)
                    .setAutoCancel(true)
                    .setContentText(nIVreading + " Is Currently Available For Patient in BedNumber#" + nBedNo);
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
            managerCompat.notify(999, builder.build());

        }else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "n")
                    .setContentText("Code Sphere")
                    .setSmallIcon(R.drawable.ic_notifications_)
                    .setAutoCancel(true)
                    .setContentText("Patient record:" + nname + " is created successfully");
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
            managerCompat.notify(999, builder.build());
        }

    }


}


