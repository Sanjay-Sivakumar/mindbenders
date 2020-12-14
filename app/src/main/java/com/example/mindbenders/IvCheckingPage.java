package com.example.mindbenders;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class IvCheckingPage extends AppCompatActivity {

    DatabaseReference databaseivrecord;
    Appointmentpatient1 member;
    TextView bedno1,currentivchanging,ivnmaechanging,fixedivvaluee;
    int ids=0;
    MediaPlayer notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iv_checking_page);

        member = new Appointmentpatient1();
        databaseivrecord = FirebaseDatabase.getInstance().getReference("Patient");
        bedno1=(TextView)findViewById(R.id.textViewappointbedno1);
        ivnmaechanging=(TextView)findViewById(R.id.textViewivname);
        currentivchanging=(TextView)findViewById(R.id.textViewivcurrentvalue1);
        fixedivvaluee=(TextView)findViewById(R.id.textViewivfinalvaluefixed);
        databaseivrecord.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    ids = (int) dataSnapshot.getChildrenCount();
                }

                List<String> keys = new ArrayList<>();
                for (DataSnapshot keynode : dataSnapshot.getChildren()) {
                    keys.add(keynode.getKey());
                    Appointmentpatient1 member = keynode.getValue(Appointmentpatient1.class);

                    String num = member.getPatientcurrentiv();
                    String num1 = member.getPatientivfinalvalue();
                    String bednumberone=member.getPatientid();
                    String ivnmaecange=member.getPatientivname();

                    bedno1.setText(bednumberone);
                    ivnmaechanging.setText(ivnmaecange);
                    currentivchanging.setText(num);
                    fixedivvaluee.setText(num1);

                    try {
                        int numbers = Integer.parseInt(num);
                        int numbers1 = Integer.parseInt(num1);
                        if (numbers < numbers1) {
                            notification(member.getPatientid().toString(), member.getPatientmedicondition().toString(), member.getPatientcurrentiv().toString());
                            Toast.makeText(IvCheckingPage.this, "Currently Value Is  Updated From IV Bottle", Toast.LENGTH_LONG).show();
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