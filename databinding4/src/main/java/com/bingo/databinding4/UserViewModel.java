package com.bingo.databinding4;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Created by ing on 2021/9/10
 */
public class UserViewModel extends BaseObservable {
    private User user;

    public UserViewModel() {
        this.user = new User("Tom");
    }
    //通过绑定注解 @Bindable 用户名发生变化会影响edittext的显示
    @Bindable
    public String getUserName() {
        return user.userName;
    }
    //EditText里的内容变化了，会自动调用该方法。
    public void setUserName(String userName) {
        if (userName != null && !userName.equals(user.userName)) {
            user.userName = userName;
            Log.d("bingo", "setUserName: " + userName);
            notifyPropertyChanged(BR.userName);
        }
    }
}
