package com.academy.fundamentals.mymovieapp.presenter.threads;


import android.os.Handler;

public class MySimpleAsyncTask {

    boolean isCancelled = false;
    Thread mThread;
    Handler mHandler = new Handler();



    public void onPreExecute() {
        isCancelled = false;
    }

    public void doInBackground() {

    }

    public void onPostExecute() {

    }

    public void execute() {
        onPreExecute();
        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!mThread.isInterrupted()) {
                    doInBackground();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            onPostExecute();
                        }
                    });
                }
            }
        });

        mThread.start();

    }

    public void onProgressUpdate() {

    }

    public void cancel() {
        isCancelled = true;
    }
}