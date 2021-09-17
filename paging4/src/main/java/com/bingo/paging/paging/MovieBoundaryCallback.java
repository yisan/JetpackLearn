package com.bingo.paging.paging;

import com.bingo.paging.model.Movie;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;

/**
 * Created by ing on 2021/9/17
 */
public class MovieBoundaryCallback extends PagedList.BoundaryCallback<Movie> {
    //加载第一页数据
    @Override
    public void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
        getTopData();
    }

    private void getTopData() {
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
