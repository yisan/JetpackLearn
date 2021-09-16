package com.bingo.workmanager;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Created by ing on 2021/9/15
 */
public class MyWork extends Worker {
    public MyWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        // 接收数据
        String input = getInputData().getString("input");
        Log.d("bingo","data:"+input);
        Log.d("bingo", "MyWork do something...");
        // 任务执行完之后，返回数据
        Data outputData = new Data.Builder()
                .putString("output","执行成功")
                .build();
        return Result.success(outputData);
    }
}
