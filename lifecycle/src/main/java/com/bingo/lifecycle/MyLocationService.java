package com.bingo.lifecycle;

import android.nfc.Tag;
import android.util.Log;

import androidx.lifecycle.LifecycleService;

/**
 * Created by ing on 2021/9/9
 */
public class MyLocationService extends LifecycleService  {
    private static final String TAG = "MyLocationService";
    public MyLocationService(){
        Log.d("bingo","MyLocationService");
        MyLocationObserver observer = new MyLocationObserver(this);
        getLifecycle().addObserver(observer);
    }
}
