package com.bingo.room2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by ing on 2021/9/13
 */
@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;
    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    public String name;
    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.INTEGER)
    public int age;
    @ColumnInfo(name = "sex", typeAffinity = ColumnInfo.INTEGER)
    public int sex;
    @ColumnInfo(name = "score", typeAffinity = ColumnInfo.INTEGER)
    public int score;
    @Ignore
    public boolean flag;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Ignore
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Ignore
    public Student(int id) {
        this.id = id;
    }
}
