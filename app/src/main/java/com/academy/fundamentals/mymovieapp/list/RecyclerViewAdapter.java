package com.academy.fundamentals.mymovieapp.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.academy.fundamentals.mymovieapp.R;
import com.academy.fundamentals.mymovieapp.model.MovieModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private OnMovieClickListener mClickListener;

    private final List<MovieModel> movies;

    public RecyclerViewAdapter(List<MovieModel> list, OnMovieClickListener clickListener) {
        movies = list;
        mClickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView movieImage;
        TextView movieTitle;
        TextView movieOverview;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.iv_movie_poster);
            movieTitle = itemView.findViewById(R.id.tv_title);
            movieOverview = itemView.findViewById(R.id.tv_summary);
            itemView.setOnClickListener(this);
        }

        public void bind(MovieModel movie) {
            movieImage.setImageResource(movie.getImageRes());
            movieTitle.setText(movie.getName());
            movieOverview.setText(movie.getOverview());
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) {
                mClickListener.onMovieClicked(getAdapterPosition());
            }
        }
    }
}
