package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuizOne extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;
    static int score = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_one);
        b1 = (Button) findViewById(R.id.button36);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);
        r4 = (RadioButton) findViewById(R.id.radioButton4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0;
                if(r2.isChecked()){
                    ++score;
                }
                else {
                    --score;
                }
                Intent i = new Intent(QuizOne.this,QuizTwo.class);
                startActivity(i);
                finish();
            }
        });
    }
}