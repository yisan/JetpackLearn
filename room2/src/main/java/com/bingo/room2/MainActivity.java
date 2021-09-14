package com.bingo.room2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "bingo";
    public StudentRecyclerViewAdapter adapter;
    private MyViewModel studentViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Student> students = new ArrayList<>();
        adapter = new StudentRecyclerViewAdapter(students);
        recyclerView.setAdapter(adapter);
        studentViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        studentViewModel.getAllStudentsLive().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                adapter.setStudents(students);
                adapter.notifyDataSetChanged();
            }
        });
    }


    public void clear(View view) {
        studentViewModel.deleteAll();
    }

    public void update(View view) {
        Student s1 = new Student("Alice", 21);
        studentViewModel.update(s1);
    }

    public void delete(View view) {
        Student s1 = new Student(33);
        studentViewModel.delete(s1);
    }

    public void insert(View view) {
        Student s1 = new Student("Jack", 20);
        Student s2 = new Student("Rose", 30);
        studentViewModel.insert(s1, s2);
    }
}