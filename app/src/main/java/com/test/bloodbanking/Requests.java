package com.test.bloodbanking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Requests extends AppCompatActivity {
    ListView listview;
    Intent intent;
    Intent myR;
    ArrayList<Req> arraylist = new ArrayList<>();
    ArrayList<Req> newArray = new ArrayList<>();
    DatabaseReference db= FirebaseDatabase.getInstance().getReference("request");
    ArrayAdapter<Req> adapter ,searchAdapter;
    ImageButton s;
    Button m;
    Spinner S;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Toolbar toolbar=findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        setContentView(R.layout.requests);
        listview = findViewById(R.id.listofrequests);
        s = findViewById(R.id.search);
        S= findViewById(R.id.bgroup);
        m = findViewById(R.id.button5);

        final FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();
//        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Back clicked!",     Toast.LENGTH_SHORT).show();
//                intent = new Intent(getApplicationContext(),Main2Activity.class);
//                startActivity(intent);
//            }
//        });



        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot x : dataSnapshot.getChildren()){
                     Req req= new Req();
                    req.view = "Blood group :" + x.child("bloodgroup").getValue().toString() + "\nLocation : " + x.child("location").getValue().toString()
                            + "\nNumber of bags : " + x.child("number").getValue().toString() + "\nReason : " + x.child("reason").getValue().toString() +
                            "\nName : " + x.child("name").getValue().toString() + "\nPhone Number : " + x.child("phone").getValue().toString();
                     req.reqId = x.getKey();
                    arraylist.add(req);

                }
                adapter=new ArrayAdapter<Req>(Requests.this,android.R.layout.simple_list_item_1,arraylist);
                listview.setAdapter(adapter);

                if(arraylist.size() == 0){
                    Toast.makeText(Requests.this, "No Requests Yet !", Toast.LENGTH_LONG).show();
                }

//                listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//                    @Override
//                    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//                        AlertDialog.Builder builder=new AlertDialog.Builder(Requests.this);
//                        builder.setTitle("Request Delete");
//                        builder.setMessage("Are you sure you want to delete the request ?");
//                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                db.child(arraylist.get(position).getReqId()).removeValue();
//                                arraylist.remove(position);
//                                adapter.notifyDataSetChanged();
//                            }
//                        });
//
//
//                        builder.create();
//                        AlertDialog dia=builder.show();
//                        return true;
//                    }
//
//                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                adapter.notifyDataSetChanged();
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final String E= auth.getEmail();
                final String Rid =  arraylist.get(position).getReqId();
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(!dataSnapshot.child(Rid).child("email").getValue().toString().equals(E)){
                            Intent n = new Intent(getApplicationContext(),ShowRequest.class);
                            n.putExtra("id",arraylist.get(position).getReqId());
                            startActivity(n);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

            }
        });

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final String E= auth.getEmail();

                final String Rid =  arraylist.get(position).getReqId();

                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        if(dataSnapshot.child(Rid).child("email").getValue().toString().equals(E)){
                            AlertDialog.Builder builder=new AlertDialog.Builder(Requests.this);
                            builder.setTitle("Request Delete");
                            builder.setMessage("Are you sure you want to delete the request post ?");
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    db.child(arraylist.get(position).reqId).removeValue();
                                    arraylist.remove(position);
                                    adapter.notifyDataSetChanged();
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

                            AlertDialog.Builder builder=new AlertDialog.Builder(Requests.this);
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


        //Search Button
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String bd = S.getSelectedItem().toString();


                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot x : dataSnapshot.getChildren()){

                            if(x.child("bloodgroup").getValue().equals(bd)) {
                                Req req= new Req();
                                req.view += "" + x.child("bloodgroup").getValue().toString() + "\n" + x.child("location").getValue().toString();
                                req.reqId = x.getKey();
                                newArray.add(req);
                            }

                        }
                        searchAdapter =  new ArrayAdapter<Req>(Requests.this,android.R.layout.simple_list_item_1,newArray);
                        listview.setAdapter(searchAdapter);

                        if(newArray.size() == 0){
                            Toast.makeText(Requests.this, "No Requests Yet !", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Requests.this, "You can long click to delete your own post.", Toast.LENGTH_LONG).show();
                        }





                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        searchAdapter.notifyDataSetChanged();
                    }
                });

            }
        });

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MyRequests.class);
                startActivity(intent);
            }
        });



    }

}
