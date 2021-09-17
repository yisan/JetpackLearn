package com.bingo.paging.db;

import android.content.Context;

import com.bingo.paging.model.Movie;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by ing on 2021/9/17
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
