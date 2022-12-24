package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class TextToSpeech extends AppCompatActivity {
    EditText e1;
    Button b1;
    android.speech.tts.TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);
        b1 = (Button) findViewById(R.id.button32);
        e1 = (EditText) findViewById(R.id.editText15);
        ts = new android.speech.tts.TextToSpeech(getApplicationContext(), new android.speech.tts.TextToSpeech.OnInitListener() {
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
                ts.speak(s1, android.speech.tts.TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}