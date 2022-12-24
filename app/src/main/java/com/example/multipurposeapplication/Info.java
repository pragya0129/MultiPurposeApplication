package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Info extends AppCompatActivity {
    Button b1;
    EditText e1,e2,e3;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        b1 = (Button) findViewById(R.id.button7);
        e1 = (EditText) findViewById(R.id.editText7);
        e2 = (EditText) findViewById(R.id.editText8);
        e3 = (EditText) findViewById(R.id.editText9);
        firebaseDatabase = FirebaseDatabase.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = firebaseDatabase.getReference("Users");
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();

                if(s2.length()!=10){
                    e2.setError("Phone No. must be of 10 digits");
                }
                else{
                    Users users = new Users(s1,s2,s3);
                    databaseReference.child(s2).setValue(users);
                    Toast.makeText(Info.this, "Welcome", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Info.this,Home.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}