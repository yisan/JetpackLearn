package com.bingo.paging.db;

import com.bingo.paging.model.Movie;

import java.util.List;


import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by ing on 2021/9/17
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
