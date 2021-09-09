package com.bingo.lifecycle;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwnerInitializer;

/**
 * Created by ing on 2021/9/9
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new ApplicationObserver());
    }
}
