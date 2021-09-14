package com.bingo.navigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = getView().findViewById(R.id.button);
        button.setOnClickListener(v -> {
            // 普通传参
//            Bundle args = new Bundle();
//            args.putString("name","Alice");
            //safe传参
            Bundle args = new HomeFragmentArgs.Builder().
                    setName("rose").setAge(19).
                    build().toBundle();
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_homeFragment_to_detailFragment, args);
        });
    }
}