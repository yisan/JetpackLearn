package com.bingo.navigation3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = getView().findViewById(R.id.button2);
        Bundle args = getArguments();
        if (args != null) {
            String name = args.getString("name");
            if (name != null) {
                Log.d("bingo", "name:" + name);
            }
            // 通过adb shell am start -a android.intent.action.VIEW -d "http://www.bingo.com/fromWeb"模拟网页点击跳转到该fragment
            String params = args.getString("params");
            if (params != null) {
                Log.d("bingo", "params:" + params);
            }
        }
        button.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_detailFragment_to_homeFragment);
        });
    }
}