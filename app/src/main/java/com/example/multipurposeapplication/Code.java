package com.example.multipurposeapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Code extends AppCompatActivity {
    Button b1;
    EditText e1;
    String phone;
    String otp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        phone = getIntent().getStringExtra("mobile").toString();
        b1 = (Button) findViewById(R.id.button6);
        e1 = (EditText) findViewById(R.id.editText6);
        firebaseAuth = FirebaseAuth.getInstance();
        genotp();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                if(s1.isEmpty()){
                    e1.setError("Enter OTP");
                }
                else{
                    if(s1.length()!=6){
                        e1.setError("Enter 6 digit OTP");
                    }
                    else{
                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otp,s1);
                        signInWithPhoneCredential(credential);
                    }
                }
            }
        });

    }
    private void genotp() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        otp = s;
                        super.onCodeSent(s, forceResendingToken);
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(Code.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void signInWithPhoneCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Code.this, "Welcome", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Code.this,Info.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(Code.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}