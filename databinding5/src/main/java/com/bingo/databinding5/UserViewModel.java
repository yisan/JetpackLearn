package com.bingo.databinding5;

import android.util.Log;

import androidx.databinding.ObservableField;

/**
 * Created by ing on 2021/9/10
 */
public class UserViewModel {
    private ObservableField<User> userObservableField;

    public UserViewModel() {
        User user = new User("Jack");
        userObservableField = new ObservableField<>();
        userObservableField.set(user);
    }

    public String getUserName() {
        return userObservableField.get().userName;
    }

    public void setUserName(String userName) {
        Log.d("bingo", "userObservableFiled:" + userName);
        userObservableField.get().userName = userName;
    }
}
