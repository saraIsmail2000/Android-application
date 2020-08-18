package com.test.bloodbanking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowRequest extends AppCompatActivity {
    TextView name;
    TextView phone;
    TextView bloodgroup;
    TextView num;
    TextView reason;
    TextView location;
    TextView email;
    Button c,s;
    DatabaseReference db= FirebaseDatabase.getInstance().getReference("request");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_request);

        name = findViewById(R.id.textView);
        phone = findViewById(R.id.textView2);
        bloodgroup = findViewById(R.id.textView3);
        num = findViewById(R.id.textView4);
        reason = findViewById(R.id.textView5);
        location = findViewById(R.id.textView6);
        email = findViewById(R.id.textView13);
        c = findViewById(R.id.call);
        s = findViewById(R.id.sms);
        final String s  = getIntent().getStringExtra("id");

        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name.setText(dataSnapshot.child(s).child("name").getValue().toString());
                phone.setText(dataSnapshot.child(s).child("phone").getValue().toString());
                bloodgroup.setText(dataSnapshot.child(s).child("bloodgroup").getValue().toString());
                num.setText(dataSnapshot.child(s).child("number").getValue().toString());
                reason.setText(dataSnapshot.child(s).child("reason").getValue().toString());
                location.setText(dataSnapshot.child(s).child("location").getValue().toString());
                email.setText(dataSnapshot.child(s).child("email").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void call(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+ phone.getText()));
        startActivity(intent);
    }

    public void message(View view){

//       // To launch the sms activity all you need is :
//
//        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
//        sendIntent.setType("vnd.android-dir/mms-sms");
//        //You can add extras to populate your own message and such as
//
//        sendIntent.putExtra("sms_body", "Hello");
//       // then just startActivity with the intent.
//        startActivity(sendIntent);

        Uri smsUri = Uri.parse("tel:"+ phone.getText());
        Intent intent = new Intent(Intent.ACTION_VIEW, smsUri);
        intent.putExtra("sms_body", "");
        intent.setType("vnd.android-dir/mms-sms");
        startActivity(intent);

    }


}
