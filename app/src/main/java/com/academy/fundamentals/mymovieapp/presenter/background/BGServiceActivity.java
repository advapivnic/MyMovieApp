package com.academy.fundamentals.mymovieapp.presenter.background;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.academy.fundamentals.mymovieapp.R;

import static com.academy.fundamentals.mymovieapp.presenter.background.BackgroundProgressReceiver.PROGRESS_UPDATE_ACTION;

public class BGServiceActivity extends AppCompatActivity implements BackgroundProgressReceiver.AppReceiver {

    TextView tv_progress;
    private BackgroundProgressReceiver mBackgroundProgressReceiver;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bgservice);

        tv_progress = findViewById(R.id.tv_percent);
        Button btnStartService = findViewById(R.id.btn_startservice);
        Button btnStartIntentService = findViewById(R.id.btn_startintentservice);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent service = new Intent(getApplicationContext(), HardJobService.class);
                startService(service);
            }
        });

        btnStartIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentService = new Intent(getApplicationContext(), HardJobIntentService.class);
                startService(intentService);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        subscribeForProgressUpdates();

    }

    private void subscribeForProgressUpdates() {
        if (mBackgroundProgressReceiver == null) {
            mBackgroundProgressReceiver = new BackgroundProgressReceiver(this);
        }
        IntentFilter progressUpdateActionFilter = new IntentFilter(PROGRESS_UPDATE_ACTION);
        registerReceiver(mBackgroundProgressReceiver, progressUpdateActionFilter);

    }

    @Override
    protected void onPause() {
        if(mBackgroundProgressReceiver != null) {
            unregisterReceiver(mBackgroundProgressReceiver);
        }
        super.onPause();

    }

    @Override
    public void onReceiveResult(int resultCode) {
        if (tv_progress != null) {
            tv_progress.setText(resultCode+"%");
        }
    }
}
