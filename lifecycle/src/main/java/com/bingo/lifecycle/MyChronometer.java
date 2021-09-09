package com.bingo.lifecycle;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by ing on 2021/9/9
 *
 */
public class MyChronometer extends Chronometer implements LifecycleObserver {
    private long elapsedTime;

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void startMeter() {
        setBase(SystemClock.elapsedRealtime() - elapsedTime);
        start();
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void endMeter() {
        stop();
        elapsedTime = SystemClock.elapsedRealtime() - getBase();
    }
}
