package com.bingo.workmanager2;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Created by ing on 2021/9/15
 */
public class BWorker extends Worker {
    public BWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("bingo", this.getClass().getSimpleName() + " doWork.");
        return Result.success();
    }
}
