package com.example.multipurposeapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoRecording extends AppCompatActivity {
    Button b1;
    VideoView v1;
    Uri u1;
    MediaController m1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==99){
            u1 = data.getData();
            v1.setVideoURI(u1);
            v1.setMediaController(m1);
            m1.setAnchorView(v1);
            v1.start();
        }
        else{
            Toast.makeText(this, "Camera Not Working", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_recording);
        b1 = (Button) findViewById(R.id.button17);
        v1 = (VideoView) findViewById(R.id.videoView);
        m1 = new MediaController(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,99);
            }
        });

    }
}