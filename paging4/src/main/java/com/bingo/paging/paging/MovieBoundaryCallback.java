package com.bingo.paging.paging;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.bingo.paging.api.RetrofitClient;
import com.bingo.paging.db.MyDatabase;
import com.bingo.paging.model.Movie;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ing on 2021/9/17
 */
public class MovieBoundaryCallback extends PagedList.BoundaryCallback<Movie> {
    private static final String TAG = "bingo";
    public static final int PER_PAGE = 8;
    private Application mApplication;

    public MovieBoundaryCallback(Application application) {
        mApplication = application;
    }

    //加载第一页数据
    @Override
    public void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
        getTopData();
    }

    private void getTopData() {
        int since = 0;
        RetrofitClient.getInstance().getApi().getMovies(since, PER_PAGE).enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.body() != null) {
                    // 将数据保存到数据库
                    insertMovies(response.body());
                    Log.d(TAG, "getTopData onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }

    //保存数据到数据库，异步操作数据库
    private void insertMovies(List<Movie> movies) {
        AsyncTask.execute(() -> MyDatabase.getInstance(mApplication).getMovieDao().insertMovies(movies));
    }

    //加载第二页数据
    @Override
    public void onItemAtEndLoaded(@NonNull Movie movie) {
        super.onItemAtEndLoaded(movie);
        getTopAfterData(movie);
    }

    private void getTopAfterData(Movie movie) {
    }

}
