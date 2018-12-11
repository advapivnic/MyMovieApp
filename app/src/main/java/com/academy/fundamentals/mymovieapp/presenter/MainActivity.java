package com.academy.fundamentals.mymovieapp.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.academy.fundamentals.mymovieapp.R;

public class MainActivity extends AppCompatActivity implements MoviesFragment.itemClickedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MoviesFragment moviesFragment = new MoviesFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_id, moviesFragment, "tag").commit();

    }

    @Override
    public void itemClicked(int itemPosition) {
        Intent pagerActivity = new Intent(this,ScreenSlidePagerActivity.class);
        pagerActivity.putExtra(ScreenSlidePagerActivity.EXTRA_ITEM_POSITION, itemPosition);
        startActivity(pagerActivity);
    }
}