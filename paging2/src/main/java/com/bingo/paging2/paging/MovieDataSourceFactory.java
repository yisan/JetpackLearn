package com.bingo.paging2.paging;

import com.bingo.paging2.model.Movie;
import com.bingo.paging2.model.Movies;

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