package com.bingo.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private MyChronometer chronometer;
//    private Chronometer chronometer;
//    private long elapsedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(chronometer);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        chronometer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
//        chronometer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        chronometer.stop();
//        elapsedTime = SystemClock.elapsedRealtime() - chronometer.getBase();
    }
}