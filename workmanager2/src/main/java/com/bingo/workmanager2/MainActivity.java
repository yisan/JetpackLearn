package com.bingo.workmanager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务链
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doWork(View view) {
        // 任务链
        OneTimeWorkRequest workRequestA = new OneTimeWorkRequest.Builder(AWorker.class).build();
        OneTimeWorkRequest workRequestB = new OneTimeWorkRequest.Builder(BWorker.class).build();
        OneTimeWorkRequest workRequestC = new OneTimeWorkRequest.Builder(CWorker.class).build();
        OneTimeWorkRequest workRequestD = new OneTimeWorkRequest.Builder(DWorker.class).build();
        OneTimeWorkRequest workRequestE = new OneTimeWorkRequest.Builder(EWorker.class).build();
        // 先执行A 后执行B
//        WorkManager.getInstance(this).beginWith(workRequestA).then(workRequestB).enqueue();
        // 任务链组合A,B
        WorkContinuation workContinuation1 = WorkManager.getInstance(this).beginWith(workRequestA).then(workRequestB);
        // 任务链组合C,D
        WorkContinuation workContinuation2 = WorkManager.getInstance(this).beginWith(workRequestC).then(workRequestD);
        List<WorkContinuation> taskList = new ArrayList<>();
        taskList.add(workContinuation1);
        taskList.add(workContinuation2);
        WorkContinuation.combine(taskList).then(workRequestE).enqueue();
    }
}