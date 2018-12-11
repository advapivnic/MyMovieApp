package com.academy.fundamentals.mymovieapp.presenter.threads;


import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;

public class MySimpleAsyncTask {

    private static final String TAG = "MySimpleAsyncTask";
    private Activity myActivity;
    boolean isCancelled = false;
    Thread thread;
    Handler handler = new Handler();

    public MySimpleAsyncTask(Activity activity) {
        this.myActivity = activity;

    }

    public void onPreExecute() {
        isCancelled = false;
        Log.d(TAG, "onPreExecute: " + Thread.currentThread().getId());
    }

    public void doInBackground(Integer... startingInt) {
        Log.d(TAG, "doInBackground: " + Thread.currentThread().getId());

        for (int i=startingInt[0]; i<11; i++) {
            if (!isCancelled()) {
                onProgressUpdate(i);

                //never use it on ui thread
                SystemClock.sleep(500);
            }
        }
    }

    public void onPostExecute() {
        Log.d(TAG, "onPostExecute: " + Thread.currentThread().getId());

        if (myActivity instanceof ThreadsHandlerActivity) {
            ((ThreadsHandlerActivity)myActivity).onPostExecute();
        }
    }

    public void execute(final Integer... startingInt) {

        Log.d(TAG, "execute");

        onPreExecute();

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (!thread.isInterrupted()) {
                    doInBackground(startingInt);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onPostExecute();
                        }
                    });
                }
            }
        });

        if (thread != null) {
            thread.start();
        }
    }

    public void onProgressUpdate(final Integer... values) {
        Log.d(TAG, "onProgressUpdate: " + Thread.currentThread().getId());

        handler.post(new Runnable() {
            @Override
            public void run() {
                if (myActivity instanceof ThreadsHandlerActivity) {
                    ((ThreadsHandlerActivity)myActivity).onProgressUpdate(values[0]);
                }
            }
        });

    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void cancel() {
        isCancelled = true;
        if (thread != null) {
            thread.interrupt();
        }
    }
}