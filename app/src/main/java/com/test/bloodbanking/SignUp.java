package com.test.bloodbanking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    Button S;
    EditText e,p,n;
    private FirebaseAuth Auth;
    FirebaseUser user;
    String name;
    Intent intent;
    String[] Bgroups ={"A+","A-","AB+","AB-","O+","O-","B+","B-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        n = findViewById(R.id.password);
        p = findViewById(R.id.pass);
        e = findViewById(R.id.editText3);
        Auth = FirebaseAuth.getInstance();

    }

    public void signup(View v){

        if(e.getText().toString().equals("") || p.getText().toString().equals("") || n.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Some Fields are missing.", Toast.LENGTH_LONG).show();
            return;
        }
        if(!p.getText().toString().equals(n.getText().toString())){
            Toast.makeText(getApplicationContext(), "You didn't enter the same password in the confirmation field.", Toast.LENGTH_LONG).show();
            return;
        }
        Auth.createUserWithEmailAndPassword(e.getText().toString(), p.getText().toString())
                .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            user = Auth.getCurrentUser();
                            updateUI(user);
                            Toast.makeText(getApplicationContext(), "Authentication Succeed.", Toast.LENGTH_LONG).show();
                             intent = new Intent(SignUp.this, Main2Activity.class);
                             startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            updateUI(null);
                        }
                    }
                });
    }

    public void updateUI (FirebaseUser user) {
        if (user != null) Toast.makeText(getApplicationContext(),user.getDisplayName(),Toast.LENGTH_LONG).show();
        else Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_LONG).show();
    }
}
