package com.bingo.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "bingo";
    public StudentRecyclerViewAdapter adapter;
    private StudentDao studentDao;
    List<Student> students = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentRecyclerViewAdapter(students);
        recyclerView.setAdapter(adapter);
        MyDatabase database = MyDatabase.getInstance(this);
        studentDao = database.getStudentDao();
    }

    public void insert(View view) {
        Student s1 = new Student("Jack", 23);
        Student s2 = new Student("Tom", 19);
        new InsertStudentTask(studentDao).execute(s1, s2);
    }

    class InsertStudentTask extends AsyncTask<Student, Void, Void> {
        private StudentDao mStudentDao;

        public InsertStudentTask(StudentDao studentDao) {
            mStudentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            Log.d(TAG,"---insert");
            mStudentDao.insertStudent(students);
            return null;
        }
    }

    public void delete(View view) {
        Student s1 = new Student(2);

        new DeleteStudentTask(studentDao).execute(s1);
    }
    class DeleteStudentTask extends AsyncTask<Student,Void,Void>{
        private StudentDao mStudentDao;

        public DeleteStudentTask(StudentDao studentDao) {
            mStudentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            Log.d(TAG,"---delete");

            mStudentDao.deleteStudent(students);
            return null;
        }

    }

    public void update(View view) {
        Student s1 = new Student(3,"Bob", 33);
        new UpdateStudentTask(studentDao).execute(s1);
    }

    class UpdateStudentTask extends AsyncTask<Student, Void, Void> {
        private StudentDao mStudentDao;

        public UpdateStudentTask(StudentDao studentDao) {
            mStudentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            Log.d(TAG,"---update");

            mStudentDao.updateStudent(students);
            return null;
        }

    }

    public void query(View view) {
        new GetAllStudentTask(studentDao).execute();
    }

    class GetAllStudentTask extends AsyncTask<Void, Void, Void> {
        private StudentDao mStudentDao;

        public GetAllStudentTask(StudentDao studentDao) {
            mStudentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG,"---query");

            List<Student> students = mStudentDao.getAllStudents();
            adapter.setStudents(students);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            adapter.notifyDataSetChanged();
        }
    }
}