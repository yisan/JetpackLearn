package com.bingo.databinding2;

import android.os.Bundle;

import com.bingo.databinding2.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Idol idol = new Idol("斯嘉丽", 5);
        activityMainBinding.setIdol(idol);
    }

}