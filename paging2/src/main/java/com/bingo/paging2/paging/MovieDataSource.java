package com.bingo.paging2.paging;

import android.util.Log;

import com.bingo.paging2.api.RetrofitClient;
import com.bingo.paging2.model.Movie;
import com.bingo.paging2.model.Movies;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ing on 2021/9/16
 */
public class MovieDataSource extends PageKeyedDataSource<Integer, Movie> {
    private static final String TAG = "bingo";
    public static final int PER_PAGE = 8;
    public static final int FIRST_PAGE = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Movie> callback) {
        RetrofitClient.getInstance().getApi().getMovies(FIRST_PAGE, PER_PAGE).enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                callback.onResult(response.body().getMovies(), null, FIRST_PAGE + 1);
                Log.d(TAG, "loadInitial onResponse: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {
    }

    //下一页
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {
        RetrofitClient.getInstance().getApi().getMovies(params.key, PER_PAGE).enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                if (response.body() != null) {
                    Integer nextKey = response.body().isHasMore() ? params.key + 1 : null;
                    callback.onResult(response.body().getMovies(), nextKey);
                    Log.d(TAG, "loadAfter onResponse: "+response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {

            }
        });
    }
}