package com.bingo.paging.api;

import com.bingo.paging.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ing on 2021/9/16
 */
public interface Api {
    @GET("pds.do")
    Call<Movies> getMovies(@Query("start") int since,@Query("count") int perpage);
}