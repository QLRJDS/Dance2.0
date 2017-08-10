package com.example.danceapp.dance;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

//主页
/**
 * 主页
 */
public class homePageFragment extends Fragment implements View.OnClickListener{

    private RelativeLayout tuijian,jianshencao,minzuwu,jiewu,xiandaiwu;
    //private ViewPager vptuijian,vpjianshencao,vpminzuwu,vpjiewu,vpxiandaiwu;
    private ImageView vptuijian;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.homepage, container, false);


        tuijian=(RelativeLayout)view.findViewById(R.id.tuijian);
        tuijian.setOnClickListener(this);
        jianshencao=(RelativeLayout)view.findViewById(R.id.jianshencao);
        jianshencao.setOnClickListener(this);
        minzuwu=(RelativeLayout)view.findViewById(R.id.minzuwu);
        minzuwu.setOnClickListener(this);
        jiewu=(RelativeLayout)view.findViewById(R.id.jiewu);
        jiewu.setOnClickListener(this);
        xiandaiwu=(RelativeLayout)view.findViewById(R.id.xiandaiwu);
        xiandaiwu.setOnClickListener(this);

        vptuijian=(ImageView)view.findViewById(R.id.vptuijian);
        vptuijian.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tuijian://调用回调函数，进行数据处理
                VedioListCallback list_callback = (VedioListCallback) getActivity();
                list_callback.getVedioList("test");
                break;
            case R.id.vptuijian:
                Log.i("hahahha", "onClick: ");
                VedioCallback callback=(VedioCallback) getActivity();
                callback.getVedio("test");
                break;

        }
    }
    //数据处理的回调函数
    public interface VedioListCallback {
        public void getVedioList(String data);
    }
    //数据处理的回调函数
    public interface VedioCallback {
        public void getVedio(String data);
    }
}

