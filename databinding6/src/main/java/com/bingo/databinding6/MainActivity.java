package com.bingo.databinding6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.bingo.databinding6.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        List<Idol> idolList = new ArrayList<>();
        Idol i1 = new Idol("陈伟霆","William Chan","https://pics2.baidu.com/feed/7c1ed21b0ef41bd53c38f74b365e32cf38db3daa.jpeg?token=356a2c632705c9d02f27e535a533036e&s=F380BB0D40332384724D7DA6030070C0");
        Idol i2 = new Idol("刘德华","Andy Lau","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fnimg.ws.126.net%2F%3Furl%3Dhttp%253A%252F%252Fdingyue.ws.126.net%252F2021%252F0909%252F3d7ae45aj00qz5mrj001ec000hs00mec.jpg%26thumbnail%3D650x2147483647%26quality%3D80%26type%3Djpg&refer=http%3A%2F%2Fnimg.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633861095&t=4c9eebb7e24c6a0db0f19be1def50913");
        Idol i3 = new Idol("陈伟霆","William Chan","https://pics2.baidu.com/feed/7c1ed21b0ef41bd53c38f74b365e32cf38db3daa.jpeg?token=356a2c632705c9d02f27e535a533036e&s=F380BB0D40332384724D7DA6030070C0");
        Idol i4 = new Idol("刘德华","Andy Lau","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fnimg.ws.126.net%2F%3Furl%3Dhttp%253A%252F%252Fdingyue.ws.126.net%252F2021%252F0909%252F3d7ae45aj00qz5mrj001ec000hs00mec.jpg%26thumbnail%3D650x2147483647%26quality%3D80%26type%3Djpg&refer=http%3A%2F%2Fnimg.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1633861095&t=4c9eebb7e24c6a0db0f19be1def50913");

        idolList.add(i1);
        idolList.add(i2);
        idolList.add(i3);
        idolList.add(i4);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(idolList);
        activityMainBinding.recycleView.setAdapter(adapter);


    }
}