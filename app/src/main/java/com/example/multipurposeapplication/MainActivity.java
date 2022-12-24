package com.example.multipurposeapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    EditText e1,e2;
    FirebaseAuth firebaseAuth;
    ProgressBar p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        b3 = (Button) findViewById(R.id.button3);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);

        p1 = (ProgressBar) findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PhoneLogin.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("Fill Email");
                    return;

                }
                else{
                    if(s2.isEmpty()){
                        e2.setError("Fill Password");
                        return;
                    }
                    else{
                        p1.setVisibility(View.VISIBLE);
                        firebaseAuth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(MainActivity.this,Info.class);
                                    startActivity(i);
                                    finish();
                                }
                                else{
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity.this, "Not done", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });

    }
}