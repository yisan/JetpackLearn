package com.bingo.paging2.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ing on 2021/9/16
 */
public class Movies {
    @SerializedName("has_more")
    private boolean hasMore;
    @SerializedName("subjects")
    private List<Movie> movies;

    public boolean isHasMore() {
        return hasMore;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "hasMore=" + hasMore +
                ", movies=" + movies +
                '}';
    }
}
