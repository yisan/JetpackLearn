package com.bingo.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Created by ing on 2021/9/13
 */
@Dao
public interface StudentDao {
    @Insert
    void insertStudent(Student... students);

    @Delete
    void deleteStudent(Student... students);

    @Update
    void updateStudent(Student... students);

    @Query("SELECT * FROM student")
    List<Student> getAllStudents();

    @Query("SELECT * FROM student WHERE id = :id")
    List<Student> getStudentById(int id);
}
