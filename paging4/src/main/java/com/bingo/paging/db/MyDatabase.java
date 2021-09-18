package com.bingo.paging.db;

import android.content.Context;

import com.bingo.paging.model.Movie;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by ing on 2021/9/17
 * 数据库持有者，作为与应用持久化相关数据的底层连接的主要接入点。需要使用注解 @Database 标记
 * 需满足三个条件：
 * 定义的类必须是一个继承于RoomDatabase的抽象类。
 * 在注解中需要定义与数据库相关联的实体类列表。
 * 必须包含一个无参数的抽象方法并且返回一个带有注解的 @Dao。
 *
 *
 */
@Database(entities = {Movie.class}, version = 1, exportSchema = true)
public abstract class MyDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "my_db.db";
    private static MyDatabase mInstance;

    public static synchronized MyDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    MyDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return mInstance;
    }
    public abstract MovieDao getMovieDao();
}
