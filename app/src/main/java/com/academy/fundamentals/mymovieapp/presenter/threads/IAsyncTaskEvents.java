package com.academy.fundamentals.mymovieapp.presenter.threads;

public interface IAsyncTaskEvents {

    void onPreExecute();
    void onPostExecute();
    void onProgressUpdate(Integer integer);
}
