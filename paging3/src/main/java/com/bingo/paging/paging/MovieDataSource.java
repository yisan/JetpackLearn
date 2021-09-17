package com.bingo.paging.paging;

import android.util.Log;

import com.bingo.paging.api.RetrofitClient;
import com.bingo.paging.model.Movie;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.PositionalDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ing on 2021/9/16
 */
public class MovieDataSource extends ItemKeyedDataSource<Integer,Movie> {
    private static final String TAG = "bingo";
    public static final int PER_PAGE  = 8;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Movie> callback) {
        int since = 0;
    RetrofitClient.getInstance().getApi().getMovies(since,PER_PAGE).enqueue(new Callback<List<Movie>>() {
        @Override
        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
            if (response.body()!=null){
                callback.onResult(response.body());
                Log.d(TAG, "loadInitial onResponse: "+response.body().toString());
            }
        }

        @Override
        public void onFailure(Call<List<Movie>> call, Throwable t) {

        }
    });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Movie> callback) {
        RetrofitClient.getInstance().getApi().getMovies(params.key,PER_PAGE).enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.body()!=null){
                    callback.onResult(response.body());
                    Log.d(TAG, "loadAfter onResponse: "+response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Movie> callback) {

    }

    @NonNull
    @Override
    public Integer getKey(@NonNull Movie movie) {
        return movie.getId();
    }
}