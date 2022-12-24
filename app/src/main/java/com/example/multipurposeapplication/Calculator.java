package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    Button b1,b2,b3,b4;
    EditText e1,e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        b1 = (Button) findViewById(R.id.button21);
        b2 = (Button) findViewById(R.id.button22);
        b3 = (Button) findViewById(R.id.button23);
        b4 = (Button) findViewById(R.id.button24);
        e1 = (EditText) findViewById(R.id.editText11);
        e2 = (EditText) findViewById(R.id.editText12);
        t1 = (TextView) findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);
                Integer i2 = Integer.parseInt(s2);
                Integer i3 = i1+i2;
                String s3 = Integer.toString(i3);
                t1.setText(s3);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);
                Integer i2 = Integer.parseInt(s2);
                Integer i3 = i1-i2;
                String s3 = Integer.toString(i3);
                t1.setText(s3);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);
                Integer i2 = Integer.parseInt(s2);
                Integer i3 = i1*i2;
                String s3 = Integer.toString(i3);
                t1.setText(s3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);
                Integer i2 = Integer.parseInt(s2);
                Integer i3 = i1/i2;
                String s3 = Integer.toString(i3);
                t1.setText(s3);
            }
        });
    }
}