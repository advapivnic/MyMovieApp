package com.academy.fundamentals.mymovieapp.presenter.threads;


import android.os.Handler;

public class MySimpleAsyncTask {

    boolean isCancelled = false;
    Handler handler = new Handler();



    public void onPreExecute() {
        isCancelled = false;
    }

    public void doInBackground() {

    }

    public void onPostExecute() {

    }

    public void execute() {
        onPreExecute();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (!isCancelled) {
                    doInBackground();
                }

            }
        });



        onPostExecute();
    }

    public void onProgressUpdate() {

    }

    public void cancel() {
        isCancelled = true;
    }
}
