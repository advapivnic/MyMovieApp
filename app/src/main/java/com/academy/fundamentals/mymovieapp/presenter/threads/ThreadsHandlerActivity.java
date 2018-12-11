package com.academy.fundamentals.mymovieapp.presenter.threads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.academy.fundamentals.mymovieapp.R;

public class ThreadsHandlerActivity extends AppCompatActivity implements ClickButtonsEvents {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_threadshandler);

        CounterFragment counterFragment = new CounterFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id, counterFragment, "").commit();

    }

    @Override
    public void createBtnClicked() {

    }

    @Override
    public void startBtnClicked() {

    }

    @Override
    public void cancelBtnClicked() {

    }
}
