package com.bingo.paging.db;

import com.bingo.paging.model.Movie;

import java.util.List;


import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by ing on 2021/9/17
 * 包含访问一系列访问数据库的方法。需要使用注解 @Dao 标记
 * Dao类是一个 interface 。
 * 其中定义了一系列的操作数据库的方法。通常我们操作数据库无非就是增删改查。
 * Room也为我们的提供了相关的注解，有@Insert、@Delete、@Update 和 @Query
 */
@Dao
public interface MovieDao {
    @Insert
    void insertMovies(List<Movie> movies);

    @Query("DELETE FROM movie")
    void clear();

    @Query("SELECT * FROM movie")
    DataSource.Factory<Integer, Movie> getMovies();
}
