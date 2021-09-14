package com.bingo.room2;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * Created by ing on 2021/9/14
 */
public class MyViewModel extends AndroidViewModel {
    private StudentRepository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new StudentRepository(application);
    }

    public void insert(Student... students) {
        repository.insert(students);
    }

    public void delete(Student... students) {

        repository.delete(students);
    }

    public void deleteAll() {
        repository.deleteAll();
    }


    public void update(Student... students) {
        repository.update(students);
    }

    public LiveData<List<Student>> getAllStudentsLive() {
        return repository.getAllStudentsLive();
    }
}
