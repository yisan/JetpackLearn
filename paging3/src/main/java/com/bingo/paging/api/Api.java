
package com.bingo.paging.api;

import com.bingo.paging.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ing on 2021/9/16
 */
public interface Api {
    @GET("ikds.do")
    Call<List<Movie>> getMovies(@Query("since") int since, @Query("pagesize") int pagesize);
}
