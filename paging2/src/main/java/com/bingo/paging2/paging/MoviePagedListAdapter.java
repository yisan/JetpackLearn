package com.bingo.paging2.paging;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingo.paging2.R;
import com.bingo.paging2.model.Movie;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ing on 2021/9/17
 */
public class MoviePagedListAdapter extends PagedListAdapter<Movie, MoviePagedListAdapter.MovieViewHolder> {
    private final Context context;
    private static final DiffUtil.ItemCallback<Movie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.equals(newItem);
        }
    };

    public MoviePagedListAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MovieViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = getItem(position);
        if (movie != null) {
            Glide.with(context).load(movie.getCover()).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(holder.imageView);
            holder.title.setText(movie.getTitle());
            holder.rate.setText(movie.getRate());
        }
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private TextView rate;
        private TextView title;
        private ImageView imageView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.title = itemView.findViewById(R.id.title);
            this.rate = itemView.findViewById(R.id.rate);
        }
    }
}