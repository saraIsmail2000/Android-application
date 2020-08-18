package com.test.bloodbanking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BloodTypes extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_types);
    }

    public void Click(View view) {

        DatabaseReference db= FirebaseDatabase.getInstance().getReference("donations");
        FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();


        switch (view.getId()) {
            case (R.id.abn): {
                intent = new Intent(getApplicationContext(),Donations.class);
                intent.putExtra("Blood","AB-");
                startActivity(intent);
                break;
            }

            case (R.id.abp): {
                intent = new Intent(getApplicationContext(),Donations.class);
                intent.putExtra("Blood","AB+");
                startActivity(intent);
                break;
            }

            case (R.id.bp): {
                intent = new Intent(getApplicationContext(),Donations.class);
                intent.putExtra("Blood","B+");
                startActivity(intent);
                break;
            }

            case (R.id.bn): {
                intent = new Intent(getApplicationContext(),Donations.class);
                intent.putExtra("Blood","B-");
                startActivity(intent);
                break;
            }

            case (R.id.ap): {
                intent = new Intent(getApplicationContext(),Donations.class);
                intent.putExtra("Blood","A+");
                startActivity(intent);
                break;
            }

            case (R.id.an): {
                intent = new Intent(getApplicationContext(),Donations.class);
                intent.putExtra("Blood","A-");
                startActivity(intent);
                break;
            }

            case (R.id.op): {
                intent = new Intent(getApplicationContext(),Donations.class);
                intent.putExtra("Blood","O+");
                startActivity(intent);
                break;
            }

            case (R.id.on): {
                intent = new Intent(getApplicationContext(),Donations.class);
                intent.putExtra("Blood","O-");
                startActivity(intent);
                break;
            }
            default:
                break;

        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        finish();
    }
}
