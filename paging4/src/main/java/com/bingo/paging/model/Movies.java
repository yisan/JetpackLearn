package com.bingo.paging.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ing on 2021/9/16
 */
public class Movies {
    private int count;
    private int start;
    private int total;
    @SerializedName("subjects")
    private List<Movie> movies;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", movies=" + movies +
                '}';
    }
}
