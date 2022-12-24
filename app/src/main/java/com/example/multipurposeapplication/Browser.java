package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends AppCompatActivity {
    Button b1;
    EditText e1;
    WebView w1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        b1 = (Button) findViewById(R.id.button18);
        w1 = (WebView) findViewById(R.id.webView);
        e1 = (EditText) findViewById(R.id.editText10);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                w1.loadUrl(s1);
            }
        });
    }
}