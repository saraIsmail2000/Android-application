package com.test.bloodbanking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class Donate extends AppCompatActivity {

    EditText n, ph, nb;
    Spinner bg;
    Intent intent;
    //ArrayList<Donation> array;
    DatabaseReference db;
    Intent back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        n = findViewById(R.id.editText4);
        ph = findViewById(R.id.editText5);
        nb = findViewById(R.id.editText6);
        bg = (Spinner) findViewById(R.id.spinner);
        db = FirebaseDatabase.getInstance().getReference();
        final Toolbar toolbar=findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    public void apply(View view) {


        if(n.getText().toString().equals("") || ph.getText().toString().equals("") || nb.getText().toString().equals("") ){
            Toast.makeText(getApplicationContext(),"Please fill all the fields first .", Toast.LENGTH_LONG).show();
            return;
        }

        String key=db.push().getKey();
        db.child("donations").child(key).child("id").setValue(key);
        db.child("donations").child(key).child("name").setValue(n.getText().toString());
        db.child("donations").child(key).child("phone").setValue(ph.getText().toString());
        db.child("donations").child(key).child("bloodgroup").setValue(bg.getSelectedItem().toString());
        db.child("donations").child(key).child("number").setValue(nb.getText().toString());
        db.child("donations").child(key).child("email").setValue(FirebaseAuth.getInstance().getCurrentUser().getEmail().toString());

//        Donation D = new Donation();
//        D.DID = key;
//        D.bloodgroup = bg.getSelectedItem().toString();
//        D.name= n.getText().toString();
//        D.phone= ph.getText().toString();
//        D.number = nb.getText().toString();
//        D.email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//        db.child("donations").child(key).setValue(D);


        Toast.makeText(getApplicationContext(),"Done! Your Donation is applied .", Toast.LENGTH_SHORT).show();

        intent = new Intent(Donate.this, Main2Activity.class);
        startActivity(intent);
        finish();
    }



       /* final FirebaseFirestore db = FirebaseFirestore.getInstance();
        final FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();

        final Donation donation = new Donation();

        donation.name = n.getText().toString();
        donation.phonenum = ph.getText().toString();
        donation.num = Integer.parseInt(nb.getText().toString());
        donation.bloodgroup = bg.getSelectedItem().toString();



        db.collection("Donations").document(auth.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        array = (ArrayList<Donation>)document.getData().get("donations");
                        array.add(donation);
                        HashMap<String,Object> hash = new HashMap<>();
                        hash.put("donations",array);

                        db.collection("Donations").document(auth.getUid()).set(hash).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Done! Your Donation is applied.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        //failed
                                        Toast.makeText(getApplicationContext(),"Falied !", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        array = new ArrayList<>();
                        array.add(donation);
                        HashMap<String,Object> hash = new HashMap<>();
                        hash.put("donations",array);

                        db.collection("Donations").document(auth.getUid()).set(hash).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Done! Your Donation is applied .", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        //failed
                                    }
                                });
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Error Please Try Again.",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}


*/
       @Override
       protected void onDestroy(){
           super.onDestroy();
           finish();
       }

}

