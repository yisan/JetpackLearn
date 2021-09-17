
package com.bingo.paging2.api;

import com.bingo.paging2.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ing on 2021/9/16
 */
public interface Api {
    @GET("pkds.do")
    Call<Movies> getMovies(@Query("page") int page,@Query("pagesize") int pageSize);
}
