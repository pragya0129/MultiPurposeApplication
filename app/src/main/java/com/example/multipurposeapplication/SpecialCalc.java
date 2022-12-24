package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class SpecialCalc extends AppCompatActivity {
    Button b1,b2,b3,b4;
    EditText e1,e2;
    TextView t1;
    TextToSpeech ts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_calc);
        b1 = (Button) findViewById(R.id.button25);
        b2 = (Button) findViewById(R.id.button26);
        b3 = (Button) findViewById(R.id.button27);
        b4 = (Button) findViewById(R.id.button28);
        e1 = (EditText) findViewById(R.id.editText13);
        e2 = (EditText) findViewById(R.id.editText14);
        t1 = (TextView) findViewById(R.id.textView2);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.8f);
            }
        });

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
                ts.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
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
                ts.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
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
                ts.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
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
                ts.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}