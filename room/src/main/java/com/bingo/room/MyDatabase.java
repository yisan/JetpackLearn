package com.bingo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by ing on 2021/9/13
 */
@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "my_db.db";
    private static MyDatabase mInstance;

    //这里不能写私有的构造函数,会报错。room会自动生成实现类。
//    private MyDatabase(){}
    public static synchronized MyDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, DATABASE_NAME).build();
        }
        return mInstance;
    }
    // room会帮我们自动实现
    public abstract StudentDao getStudentDao();
}
