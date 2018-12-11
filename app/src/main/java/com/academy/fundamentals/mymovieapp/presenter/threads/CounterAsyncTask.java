package com.academy.fundamentals.mymovieapp.presenter.threads;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;

public class CounterAsyncTask extends AsyncTask<Integer, Integer, Void> {

    private IAsyncTaskEvents iAsyncTaskEvents;

    public CounterAsyncTask(IAsyncTaskEvents iAsyncTaskEvents) {
        this.iAsyncTaskEvents = iAsyncTaskEvents;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        iAsyncTaskEvents.onPreExecute();
    }



    @Override
    protected Void doInBackground(Integer... startingInt) {
        for (int i=startingInt[0]; i<11; i++) {
            if (!isCancelled()) {
                publishProgress(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        iAsyncTaskEvents.onProgressUpdate(values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        iAsyncTaskEvents.onPostExecute();
    }
}
