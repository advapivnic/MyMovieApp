package com.academy.fundamentals.mymovieapp.presenter.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

class BackgroundProgressReceiver extends BroadcastReceiver {

    private AppReceiver appReceiver;

    public static final String PROGRESS_UPDATE_ACTION = "PROGRESS_UPDATE_ACTION";
    public static final String PROGRESS_VALUE_KEY = "PROGRESS_VALUE_KEY";
    public static final String SERVICE_STATUS = "SERVICE_STATUS";

    public BackgroundProgressReceiver(AppReceiver receiver) {
        appReceiver = receiver;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int progress = intent.getIntExtra(PROGRESS_VALUE_KEY, -1);
        if (appReceiver != null) {
            appReceiver.onReceiveResult(progress);
        }
    }

    public interface AppReceiver {
        public void onReceiveResult(int resultCode);
    }
}
