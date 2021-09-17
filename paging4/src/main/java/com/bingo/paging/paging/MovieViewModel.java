package com.bingo.paging.paging;

import com.bingo.paging.model.Movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

/**
 * Created by ing on 2021/9/17
 */
public class MovieViewModel extends ViewModel {
    public LiveData<PagedList<Movie>> moviePagedList;

    public MovieViewModel(){
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(MovieDataSource.PER_PAGE)
                // 当距离底部还有多少条数据时开始加载下一页
                .setPrefetchDistance(2)
                .setMaxSize(100*MovieDataSource.PER_PAGE)
                .build();
        moviePagedList = new LivePagedListBuilder<>(new MovieDataSourceFactory(),config).build();
    }
}