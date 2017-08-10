package com.example.danceapp.dance;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
* 用DiaologFragment实现的弹出框 ，用于创建新房间
*/
public class createroomFragment extends DialogFragment {

    private RadioGroup num;
    private RadioButton num1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉dialog的标题

        View view = inflater.inflate(R.layout.create_room, container);

        num= (RadioGroup)view.findViewById(R.id.num);
        //获取第一个单选按钮，并设置其为选中状态
        num1 = (RadioButton)view.findViewById(R.id.num1);
        num1.setChecked(true);

        //确认创建房间
        view.findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            //点击创建按钮后，调用回调函数，进行数据处理
            public void onClick(View v) {
                DataCallback callback = (DataCallback) getActivity();
                callback.getData("test");
            }
        });
        return view;

    }
    public void onResume() {
        //设置DialogFragment的大小
        super.onResume();
        getDialog().getWindow().setLayout(900, 1000);
    }
    //数据处理的回调函数
    public interface DataCallback {
        public void getData(String data);
    }
}

