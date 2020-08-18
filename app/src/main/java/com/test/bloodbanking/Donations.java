package com.test.bloodbanking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Donations extends AppCompatActivity {


    ArrayList<DonationHelp> arrayList;
    ArrayAdapter<DonationHelp> adap;
    ListView view;
    Intent intent,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donations);
        final Toolbar toolbar=findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                back = new Intent(getApplicationContext(),BloodTypes.class);
//                startActivity(back);
                finish();
            }
        });


        arrayList = new ArrayList<DonationHelp>();
        final DatabaseReference db = FirebaseDatabase.getInstance().getReference("donations");
        final FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();
        view = findViewById(R.id.listofdonors);
        intent = getIntent();

        String get = intent.getStringExtra("Blood");

        switch (get) {

            case "AB+": {
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot x : dataSnapshot.getChildren()) {
                            if (x.child("bloodgroup").getValue().toString().equals("AB+")) {
//                                Donation d = new Donation();
//                                d.number = x.child("bloodgroup").getValue().toString();
//                                d.phone = x.child("phone").getValue().toString();
//                                d.number = x.child("number").getValue().toString();
//                                d.name = x.child("name").getValue().toString();
//                                d.email = x.child("email").getValue().toString();
//                                d.DID = x.getKey();
//                                arrayList.add(d);
                                DonationHelp D= new DonationHelp();
                                D.show = "Blood group : "+ x.child("bloodgroup").getValue().toString() + " \nNumber of Bags : " + x.child("number").getValue().toString()
                                        + "\nDonor Name : " + x.child("name").getValue().toString() + "\nPhone Number : " + x.child("phone").getValue().toString()  ;
                                D.DonId = x.getKey();
                                arrayList.add(D);
                            }

                        }
                        adap = new ArrayAdapter<DonationHelp>(Donations.this, android.R.layout.simple_list_item_1, arrayList);
                        view.setAdapter(adap);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            }

            case "AB-": {
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot x : dataSnapshot.getChildren()) {
                            if (x.child("bloodgroup").getValue().equals("AB-")) {
//                                Donation d = new Donation();
//                                d.number = x.child("bloodgroup").getValue().toString();
//                                d.phone = x.child("phone").getValue().toString();
//                                d.number = x.child("number").getValue().toString();
//                                d.name = x.child("name").getValue().toString();
//                                d.email = x.child("email").getValue().toString();
//                                d.DID = x.getKey();
//                                arrayList.add(d);

                                DonationHelp D= new DonationHelp();
                                D.show = "Blood group : "+ x.child("bloodgroup").getValue().toString() + " \nNumber of Bags : " + x.child("number").getValue().toString()
                                        + "\nDonor Name : " + x.child("name").getValue().toString() + "\nPhone Number : " + x.child("phone").getValue().toString()  ;
                                D.DonId = x.getKey();
                                arrayList.add(D);
                            }

                        }
                        adap = new ArrayAdapter<DonationHelp>(Donations.this, android.R.layout.simple_list_item_1, arrayList);
                        view.setAdapter(adap);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            case "B+": {
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot x : dataSnapshot.getChildren()) {
                            if (x.child("bloodgroup").getValue().toString().equals("B+")) {
//                                Donation d = new Donation();
//                                d.number = x.child("bloodgroup").getValue().toString();
//                                d.phone = x.child("phone").getValue().toString();
//                                d.number = x.child("number").getValue().toString();
//                                d.name = x.child("name").getValue().toString();
//                                d.email = x.child("email").getValue().toString();
//                                d.DID = x.getKey();
//                                arrayList.add(d);

                                DonationHelp D= new DonationHelp();
                                D.show = "Blood group : "+ x.child("bloodgroup").getValue().toString() + " \nNumber of Bags : " + x.child("number").getValue().toString()
                                        + "\nDonor Name : " + x.child("name").getValue().toString() + "\nPhone Number : " + x.child("phone").getValue().toString()  ;
                                D.DonId = x.getKey();
                                arrayList.add(D);
                            }

                        }
                        adap = new ArrayAdapter<DonationHelp>(Donations.this, android.R.layout.simple_list_item_1, arrayList);
                        view.setAdapter(adap);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            }

            case "B-": {
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot x : dataSnapshot.getChildren()) {
                            if (x.child("bloodgroup").getValue().toString().equals("B-")) {
//                                Donation d = new Donation();
//                                d.number = x.child("bloodgroup").getValue().toString();
//                                d.phone = x.child("phone").getValue().toString();
//                                d.number = x.child("number").getValue().toString();
//                                d.name = x.child("name").getValue().toString();
//                                d.email = x.child("email").getValue().toString();
//                                d.DID = x.getKey();
//                                arrayList.add(d);

                                DonationHelp D= new DonationHelp();
                                D.show = "Blood group : "+ x.child("bloodgroup").getValue().toString() + " \nNumber of Bags : " + x.child("number").getValue().toString()
                                        + "\nDonor Name : " + x.child("name").getValue().toString() + "\nPhone Number : " + x.child("phone").getValue().toString()  ;
                                D.DonId = x.getKey();
                                arrayList.add(D);
                            }

                        }
                        adap = new ArrayAdapter<DonationHelp>(Donations.this, android.R.layout.simple_list_item_1, arrayList);
                        view.setAdapter(adap);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            }

            case "A+": {
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot x : dataSnapshot.getChildren()) {
                            if (x.child("bloodgroup").getValue().toString().equals("A+")) {
//                                Donation d = new Donation();
//                                d.number = x.child("bloodgroup").getValue().toString();
//                                d.phone = x.child("phone").getValue().toString();
//                                d.number = x.child("number").getValue().toString();
//                                d.name = x.child("name").getValue().toString();
//                                d.email = x.child("email").getValue().toString();
//                                d.DID = x.getKey();
//                                arrayList.add(d);

                                DonationHelp D= new DonationHelp();
                                D.show = "Blood group : "+ x.child("bloodgroup").getValue().toString() + " \nNumber of Bags : " + x.child("number").getValue().toString()
                                        + "\nDonor Name : " + x.child("name").getValue().toString() + "\nPhone Number : " + x.child("phone").getValue().toString()  ;
                                D.DonId = x.getKey();
                                arrayList.add(D);
                            }

                        }
                        adap = new ArrayAdapter<DonationHelp>(Donations.this, android.R.layout.simple_list_item_1, arrayList);
                        view.setAdapter(adap);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            }

            case "A-": {
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot x : dataSnapshot.getChildren()) {
                            if (x.child("bloodgroup").getValue().toString().equals("A-")) {
//                                Donation d = new Donation();
//                                d.number = x.child("bloodgroup").getValue().toString();
//                                d.phone = x.child("phone").getValue().toString();
//                                d.number = x.child("number").getValue().toString();
//                                d.name = x.child("name").getValue().toString();
//                                d.email = x.child("email").getValue().toString();
//                                d.DID = x.getKey();
//                                arrayList.add(d);
                                DonationHelp D= new DonationHelp();
                                D.show = "Blood group : "+ x.child("bloodgroup").getValue().toString() + " \nNumber of Bags : " + x.child("number").getValue().toString()
                                        + "\nDonor Name : " + x.child("name").getValue().toString() + "\nPhone Number : " + x.child("phone").getValue().toString()  ;
                                D.DonId = x.getKey();
                                arrayList.add(D);
                            }

                        }
                        adap = new ArrayAdapter<DonationHelp>(Donations.this, android.R.layout.simple_list_item_1, arrayList);
                        view.setAdapter(adap);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            }

            case "O+": {
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot x : dataSnapshot.getChildren()) {
                            if (x.child("bloodgroup").getValue().toString().equals("O+")) {
//                                Donation d = new Donation();
//                                d.number = x.child("bloodgroup").getValue().toString();
//                                d.phone = x.child("phone").getValue().toString();
//                                d.number = x.child("number").getValue().toString();
//                                d.name = x.child("name").getValue().toString();
//                                d.email = x.child("email").getValue().toString();
//                                d.DID = x.getKey();
//                                arrayList.add(d);

                                DonationHelp D= new DonationHelp();
                                D.show = "Blood group : "+ x.child("bloodgroup").getValue().toString() + " \nNumber of Bags : " + x.child("number").getValue().toString()
                                        + "\nDonor Name : " + x.child("name").getValue().toString() + "\nPhone Number : " + x.child("phone").getValue().toString()  ;
                                D.DonId = x.getKey();
                                arrayList.add(D);
                            }

                        }
                        adap = new ArrayAdapter<DonationHelp>(Donations.this, android.R.layout.simple_list_item_1, arrayList);
                        view.setAdapter(adap);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            }

            case "O-": {
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot x : dataSnapshot.getChildren()) {
                            if (x.child("bloodgroup").getValue().equals("O-")) {
//                                Donation d = new Donation();
//                                d.number = x.child("bloodgroup").getValue().toString();
//                                d.phone = x.child("phone").getValue().toString();
//                                d.number = x.child("number").getValue().toString();
//                                d.name = x.child("name").getValue().toString();
//                                d.email = x.child("email").getValue().toString();
//                                d.DID = x.getKey();
//                                arrayList.add(d);

                                DonationHelp D= new DonationHelp();
                                D.show = "Blood group : "+ x.child("bloodgroup").getValue().toString() + " \nNumber of Bags : " + x.child("number").getValue().toString()
                                        + "\nDonor Name : " + x.child("name").getValue().toString() + "\nPhone Number : " + x.child("phone").getValue().toString()  ;
                                D.DonId = x.getKey();
                                arrayList.add(D);
                            }

                        }
                        adap = new ArrayAdapter<DonationHelp>(Donations.this, android.R.layout.simple_list_item_1, arrayList);
                        view.setAdapter(adap);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            }
            default:
                break;


        }

//        if(arrayList.size()==0){
//            Toast.makeText(Donations.this,"No donations yet .",Toast.LENGTH_LONG).show();
//        }
//        else  Toast.makeText(Donations.this,"Click to contact the owner .",Toast.LENGTH_LONG).show();

        view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final String E= auth.getEmail();

                final String did =  arrayList.get(position).getDonId();

                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if(dataSnapshot.child(did).child("email").getValue().toString().equals(E)){
                            AlertDialog.Builder builder=new AlertDialog.Builder(Donations.this);
                            builder.setTitle("Donation Delete");
                            builder.setMessage("Are you sure you want to delete the donation post ?");
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    db.child(arrayList.get(position).DonId).removeValue();
                                    arrayList.remove(position);
                                    adap.notifyDataSetChanged();
                                }
                            });
                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            builder.create();
                            AlertDialog dia=builder.show();

                        }

                        else{

                            AlertDialog.Builder builder=new AlertDialog.Builder(Donations.this);
                            builder.setTitle("Error ");
                            builder.setIcon(R.drawable.danger);
                            builder.setMessage("You Can't Delete a post unless it's yours !!");
                            builder.create();
                            AlertDialog dia=builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                return true;
            }
        });

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final String E= auth.getEmail();

                final String did =  arrayList.get(position).getDonId();

                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {


                        if(dataSnapshot.child(did).child("email").getValue().toString().equals(E)){
                            AlertDialog.Builder builder=new AlertDialog.Builder(Donations.this);
                            builder.setTitle("Error ");
                            builder.setIcon(R.drawable.danger);
                            builder.setMessage("It's your post.  !!");
                            builder.create();
                            AlertDialog dia=builder.show();
                        }

                        else{

                            AlertDialog alert = new AlertDialog.Builder(Donations.this).create();
                            alert.setIcon(R.drawable.appicon);
                            alert.setTitle("Contact Donor");
                            alert.setMessage("Call the donor to get this donation from him.");
                            alert.setButton(Dialog.BUTTON_POSITIVE, "CALL", null, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    ///////S//A//R//A//H////////I//S//M//A//I//L///////
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    intent.setData(Uri.parse("tel:"+ dataSnapshot.child(did).child("phone").getValue().toString()));
                                    startActivity(intent);
                                }
                            });
                            alert.setButton(Dialog.BUTTON_NEGATIVE, "Cancel", null, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });

                            alert.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

}

    @Override
    protected void onDestroy(){
        super.onDestroy();
        finish();
    }

}
