package com.bingo.paging;

import android.os.Bundle;

import com.bingo.paging.model.Movie;
import com.bingo.paging.paging.MoviePagedListAdapter;
import com.bingo.paging.paging.MovieViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwipeRefreshLayout swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MoviePagedListAdapter moviePagedListAdapter = new MoviePagedListAdapter(this);
        recyclerView.setAdapter(moviePagedListAdapter);

        MovieViewModel movieViewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MovieViewModel.class);
        movieViewModel.moviePagedList.observe(this, moviePagedListAdapter::submitList);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            movieViewModel.refresh();
            swipeRefreshLayout.setRefreshing(false);
        });
    }
}