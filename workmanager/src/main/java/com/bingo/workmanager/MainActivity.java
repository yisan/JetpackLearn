package com.bingo.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 添加任务
    public void addWork(View view) {

        // 配置任务
        //定义触发条件 [有网的时候] 不一定立即触发
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .build();
        //参数
        Data inputData = new Data.Builder()
                .putString("input", "Alice")
                .build();
        // 1. 一次性执行的任务
        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWork.class)
                //设置触发条件
                .setConstraints(constraints)
                // 延迟5秒钟执行
                .setInitialDelay(1, TimeUnit.SECONDS)
                // 重试指数退避策略
                .setBackoffCriteria(BackoffPolicy.LINEAR, 2, TimeUnit.SECONDS)
                // 设置标签
                .addTag("work-1")
                // 参数传递
                .setInputData(inputData)
                .build();
        // 任务提交给WorkManager
        WorkManager workManager = WorkManager.getInstance(this);
        workManager.enqueue(oneTimeWorkRequest);

        // 2.周期性任务
        // 周期性任务最少间隔15分钟执行
        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(MyWork.class,15,TimeUnit.MINUTES).build();
        workManager.enqueue(periodicWorkRequest);
        // 观察任务状态
        workManager.getWorkInfoByIdLiveData(oneTimeWorkRequest.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                Log.d("bingo", workInfo.toString());
                if(workInfo.getState()==WorkInfo.State.SUCCEEDED){
                    String output = workInfo.getOutputData().getString("output");
                    Log.d("bingo", "output data:" + output);

                }
            }
        });
        // 取消任务
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
//                workManager.cancelWorkById(oneTimeWorkRequest.getId());
                workManager.cancelAllWork();
            }
        }, 10000);
    }
}