package com.academy.fundamentals.mymovieapp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;

import com.academy.fundamentals.mymovieapp.R;
import com.academy.fundamentals.mymovieapp.model.MoviesContent;

public class ScreenSlidePagerActivity extends AppCompatActivity {

    static String EXTRA_ITEM_POSITION = "extraItemPos";
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        int startPosition = getIntent().getIntExtra(EXTRA_ITEM_POSITION, 0);

        mPager = findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.setCurrentItem(startPosition);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            DetailsFragment detailsFragment = DetailsFragment.newInstance(MoviesContent.MOVIES.get(position));
            return detailsFragment;
        }

        @Override
        public int getCount() {
            return MoviesContent.MOVIES.size();
        }
    }
}