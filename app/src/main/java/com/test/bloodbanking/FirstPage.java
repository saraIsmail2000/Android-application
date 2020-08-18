package com.test.bloodbanking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class FirstPage extends AppCompatActivity {

    Button s1,s2;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        s1 = findViewById(R.id.signin);
        s2 = findViewById(R.id.signup);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            intent = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);
            finish();
        }

        View.OnClickListener lis1= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener lis2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        };

        s1.setOnClickListener(lis1);
        s2.setOnClickListener(lis2);

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        finish();
    }
}
