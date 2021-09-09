package com.bingo.livedata2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by ing on 2021/9/9
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> progress;

    public MutableLiveData<Integer> getProgress() {
        if (progress == null) {
            progress = new MutableLiveData<>();
            progress.setValue(0);
        }
        return progress;
    }
}
