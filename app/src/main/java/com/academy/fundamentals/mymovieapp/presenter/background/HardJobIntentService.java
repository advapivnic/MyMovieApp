package com.academy.fundamentals.mymovieapp.presenter.background;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;

public class HardJobIntentService extends IntentService {

    private boolean isDestroyed;

    public HardJobIntentService() {
        super(HardJobIntentService.class.getName());

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        isDestroyed = false;
        for (int i = 0; i <= 100 && !isDestroyed; i++) {
            SystemClock.sleep(100);
            Intent broadcastIntent = new Intent(BackgroundProgressReceiver.PROGRESS_UPDATE_ACTION);
            broadcastIntent.putExtra(BackgroundProgressReceiver.PROGRESS_VALUE_KEY, i);
            sendBroadcast(broadcastIntent);
        }

    }
}
