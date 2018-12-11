package com.academy.fundamentals.mymovieapp.presenter;

import android.content.Intent;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.academy.fundamentals.mymovieapp.R;
import com.academy.fundamentals.mymovieapp.model.MovieModel;


public class DetailsFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "DetailsFragment";
    private static final String ARG_MOVIE = "MovieModel-data";
    private TextView tv_title;
    private TextView tv_date;
    private TextView tv_overviewtext;
    private ImageView iv_backgroundImage;
    private ImageView iv_movie_poster;

    MovieModel movie;

    public static DetailsFragment newInstance (MovieModel movie) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle args =  new Bundle();
        args.putParcelable(ARG_MOVIE, movie);
        detailsFragment.setArguments(args);
        Log.d(TAG, "newInstance: " + movie.toString());

        return detailsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movie = getArguments().getParcelable(ARG_MOVIE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_details, container, false);

        tv_title = view.findViewById(R.id.tv_title);
        tv_date = view.findViewById(R.id.tv_date);
        tv_overviewtext = view.findViewById(R.id.tv_overviewtext);
        iv_backgroundImage = view.findViewById(R.id.iv_backgroundImage);
        iv_movie_poster = view.findViewById(R.id.iv_movie_poster);

        Button btnTrailer = view.findViewById(R.id.btn_trailer);
        btnTrailer.setOnClickListener(this);

        setMovieDetails();

        return view;
    }

    private void setMovieDetails() {
        if (movie == null) {
            return;
        }

        tv_title.setText(movie.getName());
        tv_date.setText(movie.getDate());
        tv_overviewtext.setText(movie.getOverview());
        iv_backgroundImage.setImageResource(movie.getBgImageRes());
        iv_movie_poster.setImageResource(movie.getImageRes());
    }

    @Override
    // trailer button clicked
    public void onClick(View v) {
        if (movie == null) {
            return;
        }

        String trailerUrl = movie.getTrailerUrl();
        if (TextUtils.isEmpty(trailerUrl)) return;

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(trailerUrl));
        startActivity(browserIntent);
    }
}