package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class PhoneLogin extends AppCompatActivity {

    EditText e1;
    Button b1;
    CountryCodePicker c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);
        b1 = (Button) findViewById(R.id.button5);
        e1 = (EditText) findViewById(R.id.editText5);
        c1 = (CountryCodePicker) findViewById(R.id.ccp);
        c1.registerCarrierNumberEditText(e1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(PhoneLogin.this,Code.class);
                k.putExtra("mobile",c1.getFullNumberWithPlus());
                startActivity(k);
            }
        });
    }
}