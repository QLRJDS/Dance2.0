package com.example.danceapp.dance;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
//房间
/**
 * Created by Jinya LIANG on 2017/7/24.
 */
public class roomFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.room, container, false);

        //点击创建房间按钮
        view.findViewById(R.id.newroom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //createroomFragment cr=new createroomFragment();
                //cr.show(getFragmentManager(),"createroomDialog");
                Intent intent=new Intent(getActivity(), roomActivity.class);
                startActivity(intent);
            }
        });

        //点击加入房间按钮
        view.findViewById(R.id.enterroom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new MyDialogFragment()
                //      .show(getFragmentManager(), "MyDialogFragment");
                Intent intent=new Intent(getActivity(), roomActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}

