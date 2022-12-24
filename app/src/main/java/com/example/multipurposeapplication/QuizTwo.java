package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuizTwo extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_two);
        b1 = (Button) findViewById(R.id.button37);
        r1 = (RadioButton) findViewById(R.id.radioButton5);
        r2 = (RadioButton) findViewById(R.id.radioButton6);
        r3 = (RadioButton) findViewById(R.id.radioButton7);
        r4 = (RadioButton) findViewById(R.id.radioButton8);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r3.isChecked()){
                    ++QuizOne.score;
                }
                else {
                    --QuizOne.score;
                }
                Intent i = new Intent(QuizTwo.this,QuizThree.class);
                startActivity(i);
                finish();
            }
        });
    }
}