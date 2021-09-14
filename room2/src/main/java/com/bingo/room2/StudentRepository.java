package com.bingo.room2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * Created by ing on 2021/9/14
 */
public class StudentRepository {
    private static final String TAG = "StudentRepository";
    private StudentDao studentDao;

    public StudentRepository(Context context) {
        MyDatabase database = MyDatabase.getInstance(context);
        this.studentDao = database.getStudentDao();
    }

    public void insert(Student... students) {
        new InsertStudentTask(studentDao).execute(students);
    }

    public void delete(Student... students) {

        new DeleteStudentTask(studentDao).execute(students);
    }

    public void deleteAll() {
        new DeleteAllStudentsTask(studentDao).execute();
    }


    public void update(Student... students) {
        new UpdateStudentTask(studentDao).execute(students);
    }
    public LiveData<List<Student>> getAllStudentsLive() {
        return studentDao.getAllStudentsLive();
    }


    class InsertStudentTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        public InsertStudentTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            Log.d(TAG, "---insert");
            studentDao.insertStudent(students);
            return null;
        }
    }

    class DeleteStudentTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        public DeleteStudentTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            Log.d(TAG, "---delete");

            studentDao.deleteStudent(students);
            return null;
        }

    }

    class DeleteAllStudentsTask extends AsyncTask<Void, Void, Void> {
        private StudentDao studentDao;

        public DeleteAllStudentsTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "---delete all");
            studentDao.deleteAllStudent();
            return null;
        }
    }

    class UpdateStudentTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        public UpdateStudentTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            Log.d(TAG, "---update");

            studentDao.updateStudent(students);
            return null;
        }

    }




}
