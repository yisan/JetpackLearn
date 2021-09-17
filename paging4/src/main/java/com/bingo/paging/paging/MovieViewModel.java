package com.bingo.paging.paging;

import android.app.Application;
import android.os.AsyncTask;

import com.bingo.paging.db.MovieDao;
import com.bingo.paging.db.MyDatabase;
import com.bingo.paging.model.Movie;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.loader.content.AsyncTaskLoader;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.room.Dao;
import androidx.room.Database;

/**
 * Created by ing on 2021/9/17
 */
public class MovieViewModel extends AndroidViewModel {
    public static final int PER_PAGE = 8;
    public LiveData<PagedList<Movie>> moviePagedList;
   private MovieDao movieDao;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieDao = MyDatabase.getInstance(application).getMovieDao();
        moviePagedList = new LivePagedListBuilder<>(movieDao.getMovies(),PER_PAGE)
                .setBoundaryCallback(new MovieBoundaryCallback(application))
                .build();
    }
    public  void refresh(){
        AsyncTask.execute(()->{
            // 清空数据库，boundarycallback会自动重新请求数据。
            movieDao.clear();
        });
    }
}