package com.bingo.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ing on 2021/9/9
 */
public class EventHandlerListener {
    private Context mContext;

    public EventHandlerListener(Context context) {
        mContext = context;
    }
    public void buttonClick(View view){
        Toast.makeText(mContext,"喜欢",Toast.LENGTH_LONG).show();
    }
}
