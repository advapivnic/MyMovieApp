package com.academy.fundamentals.mymovieapp.presenter.threads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.academy.fundamentals.mymovieapp.R;

public class ThreadsHandlerActivity extends AppCompatActivity implements ClickButtonsEvents, IAsyncTaskEvents {

    CounterFragment counterFragment;
    MySimpleAsyncTask mySimpleAsyncTask;

    //Key for saving the state of the counter
    private static final String COUNTER_STATE = "counterState";
    private int currentNum = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_threadshandler);

        if (savedInstanceState != null) {
            currentNum = savedInstanceState.getInt(COUNTER_STATE);
        }

        counterFragment = new CounterFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id, counterFragment, "").commit();

    }

    @Override
    public void createBtnClicked() {
        mySimpleAsyncTask = new MySimpleAsyncTask(this);
    }

    @Override
    public void startBtnClicked() {
        if (mySimpleAsyncTask != null && !mySimpleAsyncTask.isCancelled()) {
            mySimpleAsyncTask.execute(currentNum);
        }
    }

    @Override
    public void cancelBtnClicked() {
        if (mySimpleAsyncTask != null) {
            mySimpleAsyncTask.cancel();
        }
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onPostExecute() {
        if (counterFragment != null) {
            counterFragment.updateTextView("Done!");
        }
        currentNum = 0;
        createBtnClicked();
    }

    @Override
    public void onProgressUpdate(Integer integer) {
        currentNum = integer;
        if (counterFragment != null) {
            counterFragment.updateTextView(integer+"");
        }
    }
}
