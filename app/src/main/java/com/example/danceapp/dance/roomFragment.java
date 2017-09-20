package com.example.danceapp.dance;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
//房间
/**
 * Created by Jinya LIANG on 2017/7/24.
 */
public class roomFragment extends Fragment {

    private Context mContent;
    RadioGroup num,time;
    RadioButton num1,time1;
    Button add,decrease;
    //EditText time;
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.room, container, false);

        num= (RadioGroup)view.findViewById(R.id.num);
        //获取第一个人数单选按钮，并设置其为选中状态
        num1 = (RadioButton)view.findViewById(R.id.num1);
        num1.setChecked(true);

        time= (RadioGroup)view.findViewById(R.id.time);
        //获取第一个时间单选按钮，并设置其为选中状态
        time1 = (RadioButton)view.findViewById(R.id.time1);
        time1.setChecked(true);

        //点击创建房间按钮
        view.findViewById(R.id.newroom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean enter=true;//判断是否进入
                if(enter=true) {
                    Intent intent = new Intent(getActivity(), roomActivity.class);
                    startActivity(intent);
                }
                //else
            }
        });

        //点击加入房间按钮
        view.findViewById(R.id.enterroom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean enter=true;//判断是否进入
                if(enter=true) {
                    Intent intent = new Intent(getActivity(), roomActivity.class);
                    startActivity(intent);
                }
                //else
            }
        });
        return view;
    }
}

