package com.example.multipurposeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageButton;

import java.lang.reflect.Method;

public class Controls extends AppCompatActivity {
    ImageButton i1, i2, i3, i4;
    BluetoothAdapter ba;
    Vibrator v1;
    WifiManager wm;
    CameraManager cm;
    private boolean torch = false;
    private boolean wifi = false;
    private boolean blue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);
        i1 = (ImageButton) findViewById(R.id.imageButton2);
        i2 = (ImageButton) findViewById(R.id.imageButton3);
        i3 = (ImageButton) findViewById(R.id.imageButton4);
        i4 = (ImageButton) findViewById(R.id.imageButton5);
        i4.setImageResource(R.drawable.nowifi);
        cm = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        v1 = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        ba = BluetoothAdapter.getDefaultAdapter();


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ba.isEnabled()) {
                    if (ActivityCompat.checkSelfPermission(Controls.this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                                Controls.this,
                                new String[] {Manifest.permission.BLUETOOTH_CONNECT},1);
                        return;
                    }
                    ba.enable();
                    i1.setImageResource(R.drawable.bluetoothon);
                }
                else{
                    ba.disable();
                    i1.setImageResource(R.drawable.bluetoothoff);
                }
            }
        });

        if(wm.isWifiEnabled()){
            wifi=true;
            i4.setImageResource(R.drawable.wifi);
        }

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wifi==false){
                    wm.setWifiEnabled(true);
                    wifi=true;
                    i4.setImageResource(R.drawable.wifi);
                }
                else{
                    wm.setWifiEnabled(false);
                    wifi=false;
                    i4.setImageResource(R.drawable.nowifi);
                }
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT>26) {

                    v1.vibrate(2000);

                }
                else{

                    v1.vibrate(2000);

                }
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(torch==false){
                    try{
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id,true);
                        i2.setImageResource(R.drawable.torchon);
                        torch = true;
                    }
                    catch(CameraAccessException e){

                    }
                }
                else{
                    try {
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id,false);
                        i2.setImageResource(R.drawable.torchoff);
                        torch = false;
                    }
                    catch(CameraAccessException e){

                    }
                }
            }
        });
    }
}