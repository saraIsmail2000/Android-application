package com.test.bloodbanking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MakeRequest extends AppCompatActivity {

    Button s;
    EditText n,ph,nb,reason,location;
    Spinner bg;
   // ArrayList <Request> array;
    DatabaseReference db;
     Intent intent,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_a_request);
        final Toolbar toolbar=findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        db = FirebaseDatabase.getInstance().getReference();
        n = findViewById(R.id.editText4);
        ph = findViewById(R.id.editText5);
        nb = findViewById(R.id.editText6);
        reason = findViewById(R.id.editText7);
        location = findViewById(R.id.editText8);
        bg = findViewById(R.id.spinner);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                back = new Intent(getApplicationContext(),Main2Activity.class);
//                startActivity(back);
                finish();
            }
        });

    }

    public void submit (View view) {

        if(n.getText().toString().equals("") || ph.getText().toString().equals("") || nb.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Please fill the necessary fields first .", Toast.LENGTH_LONG).show();
            return;
        }

//        Request req=new Request();
//        req.name = n.getText().toString();
//        req.phonenum = ph.getText().toString();
//        req.num = nb.getText().toString();
//        req.reason = reason.getText().toString();
//        req.Location = location.getText().toString();
//        req.bloodgroup = bg.getSelectedItem().toString();
//        req.email=getSharedPreferences("User",MODE_PRIVATE).getString("email","");

        String key=db.push().getKey();
        db.child("request").child(key).child("id").setValue(key);
        db.child("request").child(key).child("name").setValue(n.getText().toString());
        db.child("request").child(key).child("phone").setValue(ph.getText().toString());
        db.child("request").child(key).child("reason").setValue(reason.getText().toString());
        db.child("request").child(key).child("location").setValue(location.getText().toString());
        db.child("request").child(key).child("bloodgroup").setValue(bg.getSelectedItem().toString());
        db.child("request").child(key).child("number").setValue(nb.getText().toString());
        db.child("request").child(key).child("email").setValue(FirebaseAuth.getInstance().getCurrentUser().getEmail().toString());

        Toast.makeText(getApplicationContext(),"Done! Your Request is submitted .", Toast.LENGTH_SHORT).show();

        intent = new Intent(MakeRequest.this, Main2Activity.class);
        startActivity(intent);


//        db.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot x : dataSnapshot.getChildren()){
//                    if(x.child())
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
       // Toast.makeText(getApplicationContext(),key,Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        finish();
    }

}
