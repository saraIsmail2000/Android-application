package com.test.bloodbanking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyRequests extends AppCompatActivity {
    Req req;
    Intent intent;
    ListView listview;
    ArrayList<Req> arraylist=new ArrayList<>();
    DatabaseReference db= FirebaseDatabase.getInstance().getReference("request");
    ArrayAdapter<Req> adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_requests);

         Toolbar toolbar=findViewById(R.id.toolbar5);
         setSupportActionBar(toolbar);


        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                intent = new Intent(getApplicationContext(),Requests.class);
//                startActivity(intent);
                finish();
            }
        });


        listview = findViewById(R.id.myrequest);
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot x : dataSnapshot.getChildren()){
                    String E=FirebaseAuth.getInstance().getCurrentUser().getEmail();

                    if(E.equals(x.child("email").getValue().toString())) {
                        req = new Req();
                        req.reqId = x.getKey();
                        req.view = "Blood group :" + x.child("bloodgroup").getValue().toString() + "\n" + x.child("location").getValue().toString()
                            + "\nNumber of bags : " + x.child("number").getValue().toString() + "\nReason : " + x.child("reason");
                        arraylist.add(req);
                    }

                }
                if(arraylist.size() == 0){
                    Toast.makeText(MyRequests.this, "You Still Don't have any Requests !", Toast.LENGTH_LONG).show();
                }
                adapter=new ArrayAdapter<Req>(MyRequests.this,android.R.layout.simple_list_item_1,arraylist);
                listview.setAdapter(adapter);

//                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Intent n = new Intent(getApplicationContext(),ShowRequest.class);
//                        n.putExtra("id",arraylist.get(position).getReqId());
//                        startActivity(n);
//                    }
//                });

                listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                        final AlertDialog.Builder builder=new AlertDialog.Builder(MyRequests.this);
                        builder.setTitle("Request Delete");
                        builder.setIcon(R.drawable.questionicon);
                        builder.setMessage("Are you sure you want to delete the request ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                db.child(arraylist.get(position).getReqId()).removeValue();
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
                        return true;
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
