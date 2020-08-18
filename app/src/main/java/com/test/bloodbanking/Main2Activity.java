package com.test.bloodbanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {

    ImageButton r,m,d,D;
    Intent intent,first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        r = (ImageButton)findViewById(R.id.imageButton2);
        m = (ImageButton)findViewById(R.id.imageButton);
        d = (ImageButton)findViewById(R.id.imageButton4);
        D=(ImageButton)findViewById(R.id.imageButton3);
       // first = getIntent();

    }

    public void requests(View view){
       intent = new Intent(getApplicationContext(), Requests.class);
       startActivity(intent);

    }
    public void makerequest(View view){
        intent = new Intent(getApplicationContext(), MakeRequest.class);
        startActivity(intent);

    }

    public void donate(View view){
        intent = new Intent(getApplicationContext(), Donate.class);
        startActivity(intent);

    }

    public void donations(View view){
        intent = new Intent(getApplicationContext(), BloodTypes.class);
        startActivity(intent);

    }


    public  void logout(View view){
        FirebaseAuth.getInstance().signOut();
        intent = new Intent(getApplicationContext(), FirstPage.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        finish();
    }

}
