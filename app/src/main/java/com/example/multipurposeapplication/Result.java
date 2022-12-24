package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {
    Button b1,b2;
    TextView t1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        b1 = (Button) findViewById(R.id.button35);
        b2 = (Button) findViewById(R.id.button39);
        t1 = (TextView) findViewById(R.id.textView15);

        t1.setText("Your result is "+QuizOne.score);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Result.this,QuizOne.class);
                startActivity(i);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Result.this,Home.class);
                startActivity(i);
                finish();
            }
        });
    }
}