package com.bingo.paging.paging;

import android.graphics.Movie;
import android.util.Log;


import com.bingo.paging.api.RetrofitClient;
import com.bingo.paging.model.Movies;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ing on 2021/9/16
 */
public class MovieDataSource extends PositionalDataSource<Movie> {
    public static final int PER_PAGE  = 8;
    // 页面首次加载数据
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Movie> callback) {
        int startPosition = 0;
        RetrofitClient.getInstance().getApi().getMovies(startPosition,PER_PAGE)
        .enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                if (response.body()!=null){
                    // 数据传递给PageList
                    callback.onResult(response.body().getMovies(),response.body().getStart(),response.body().getTotal());
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });
    }
    // 加载下一页
    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Movie> callback) {
        RetrofitClient.getInstance().getApi().getMovies(params.startPosition,PER_PAGE).enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                if (response.body()!=null){
                    callback.onResult(response.body().getMovies());
                    Log.d("bingo", "loadRange onResponse: "+response.body().getMovies());
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });
    }
}