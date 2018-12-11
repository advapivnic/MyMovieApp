package com.academy.fundamentals.mymovieapp.presenter.threads;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.academy.fundamentals.mymovieapp.R;

public class AsyncTaskActivity extends AppCompatActivity implements ClickButtonsEvents,IAsyncTaskEvents {

    CounterFragment counterFragment;
    CounterAsyncTask asynctask;

    //Key for saving the state of the counter
    private static final String COUNTER_STATE = "counterState";
    private int currentNum = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_asynctask);

        if (savedInstanceState != null) {
            currentNum = savedInstanceState.getInt(COUNTER_STATE);
        }

        counterFragment = new CounterFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id, counterFragment, "").commit();
    }

    @Override
    public void createBtnClicked() {
        asynctask = new CounterAsyncTask(this);
    }

    @Override
    public void startBtnClicked() {
        if (asynctask != null && !asynctask.isCancelled()) {
            if (!(asynctask.getStatus() == AsyncTask.Status.RUNNING)) {
                asynctask.execute(currentNum);
            }
        }
    }

    @Override
    public void cancelBtnClicked() {
        if (asynctask != null) {
            asynctask.cancel(true);
        }
        asynctask = null;
        currentNum = 0;
        createBtnClicked();
    }

    @Override
    public void onPreExecute() {
//        if (counterFragment != null) {
//            counterFragment.updateTextView("this is AsyncTask activity");
//        }

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_STATE, currentNum);
    }
}
