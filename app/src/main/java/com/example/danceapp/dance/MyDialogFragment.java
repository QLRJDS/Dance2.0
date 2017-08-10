package com.example.danceapp.dance;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 加入房间弹出窗口的布局及大小
 */
public class MyDialogFragment extends DialogFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.enter_dialog, null);
    }
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        //设置DialogFragment的大小，在onResume()中设置；
        getDialog().getWindow().setLayout(800, 650);
    }

}
