package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuizThree extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_three);
        b1 = (Button) findViewById(R.id.button38);
        r1 = (RadioButton) findViewById(R.id.radioButton9);
        r2 = (RadioButton) findViewById(R.id.radioButton10);
        r3 = (RadioButton) findViewById(R.id.radioButton11);
        r4 = (RadioButton) findViewById(R.id.radioButton12);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r4.isChecked()){
                    ++QuizOne.score;
                }
                else {
                    --QuizOne.score;
                }
                Intent i = new Intent(QuizThree.this,Result.class);
                startActivity(i);
                finish();
            }
        });
    }
}