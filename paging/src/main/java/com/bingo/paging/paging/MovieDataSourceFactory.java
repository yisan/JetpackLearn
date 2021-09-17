package com.bingo.paging.paging;

import com.bingo.paging.model.Movie;
import com.bingo.paging.model.Movies;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

/**
 * Created by ing on 2021/9/17
 */
public class MovieDataSourceFactory extends DataSource.Factory<Integer,Movie> {
    @NonNull
    @Override
    public DataSource create() {
        return new MovieDataSource();
    }
}