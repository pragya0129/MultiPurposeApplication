package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MediaPlayer extends AppCompatActivity {
    ImageButton i1;
    android.media.MediaPlayer mp;
    private boolean song = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        i1 = (ImageButton) findViewById(R.id.imageButton);
        mp = android.media.MediaPlayer.create(this,R.raw.h);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(song==false){
                    mp.start();
                    song = true;
                    i1.setImageResource(R.drawable.u);

                }
                else{
                    mp.pause();
                    song=false;
                    i1.setImageResource(R.drawable.t);
                }
            }
        });
    }
}