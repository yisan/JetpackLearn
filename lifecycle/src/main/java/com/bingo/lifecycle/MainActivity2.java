package com.bingo.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void startGps(View view) {
        Log.d("bingo","startGps");
        startService(new Intent(this, MyLocationService.class));
    }

    public void stopGps(View view) {
        Log.d("bingo","stopGps");
        stopService(new Intent(this, MyLocationService.class));
    }
}