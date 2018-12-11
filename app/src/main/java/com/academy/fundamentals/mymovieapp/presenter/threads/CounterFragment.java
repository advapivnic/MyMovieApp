package com.academy.fundamentals.mymovieapp.presenter.threads;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.academy.fundamentals.mymovieapp.R;

public class CounterFragment extends Fragment {

    private Activity activity;
    private TextView tv;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        activity = getActivity();
        tv = view.findViewById(R.id.tv_countertext);
        if (activity instanceof AsyncTaskActivity) {
            tv.setText("this is AsyncTask Activity");
        } else if (activity instanceof ThreadsHandlerActivity) {
            tv.setText("this is ThreadsHandlerActivity");
        }

        Button createBtn = view.findViewById(R.id.btn_create);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity instanceof AsyncTaskActivity) {
                     ((AsyncTaskActivity) activity).createBtnClicked();
                }
            }
        });

        Button startBtn = view.findViewById(R.id.btn_start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity instanceof AsyncTaskActivity) {
                    ((AsyncTaskActivity) activity).startBtnClicked();
                }
            }
        });

        Button cancelBtn = view.findViewById(R.id.btn_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity instanceof AsyncTaskActivity) {
                    ((AsyncTaskActivity) activity).cancelBtnClicked();
                }
            }
        });


        return view;
    }

    public void updateTextView(String text) {
        if (tv != null) {
            tv.setText(text);
        }
    }

}
