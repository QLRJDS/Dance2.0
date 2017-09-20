package com.example.danceapp.dance;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
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
    private ImageView vptuijian,vpjianshencao,vpminzuwu,vpjiewu,vpxiandaiwu;
    Intent intent;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.homepage, container, false);

        //跳转到视频列表
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

        //跳转到视频播放
        vptuijian=(ImageView)view.findViewById(R.id.vptuijian);
        vptuijian.setOnClickListener(this);
        vpjianshencao=(ImageView)view.findViewById(R.id.vpjianshencao);
        vpjianshencao.setOnClickListener(this);
        vpminzuwu=(ImageView)view.findViewById(R.id.vpminzuwu);
        vpminzuwu.setOnClickListener(this);
        vpjiewu=(ImageView)view.findViewById(R.id.vpjiewu);
        vpjiewu.setOnClickListener(this);
        vpxiandaiwu=(ImageView)view.findViewById(R.id.vpxiandaiwu);
        vpxiandaiwu.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //这个是跳转到视频列表
            case R.id.tuijian:
                intent = new Intent(getActivity(), VedioListActivity.class);
                intent.putExtra("title", "推荐视频");
                startActivity(intent);
                break;
            case R.id.jianshencao:
                intent = new Intent(getActivity(), VedioListActivity.class);
                intent.putExtra("title", "健身操");
                startActivity(intent);
                break;
            case R.id.minzuwu:
                intent = new Intent(getActivity(), VedioListActivity.class);
                intent.putExtra("title", "民族舞");
                startActivity(intent);
                break;
            case R.id.jiewu:
                intent = new Intent(getActivity(), VedioListActivity.class);
                intent.putExtra("title", "街舞");
                startActivity(intent);
                break;
            case R.id.xiandaiwu:
                intent = new Intent(getActivity(), VedioListActivity.class);
                intent.putExtra("title", "现代舞");
                startActivity(intent);
                break;


            //这些是跳转到视频播放,传的数据写在这里
            //!!!!!!!!!!!!!!!!
            case R.id.vptuijian:
                intent = new Intent(getActivity(), vedioActivity.class);
                intent.putExtra("vedio_url", "E:\\xampp\\htdocs\\video");
                intent.putExtra("vedio_name","视频名称");
                intent.putExtra("vedio_class","视频分类");
                startActivity(intent);
                break;
            case R.id.vpjianshencao:
                intent = new Intent(getActivity(), vedioActivity.class);
                intent.putExtra("vedio_url", "");
                intent.putExtra("vedio_name","视频名称");
                intent.putExtra("vedio_class","视频分类");
                startActivity(intent);
                break;
            case R.id.vpminzuwu:
                intent = new Intent(getActivity(), vedioActivity.class);
                intent.putExtra("vedio_url", "");
                intent.putExtra("vedio_name","视频名称");
                intent.putExtra("vedio_class","视频分类");
                startActivity(intent);
                break;
            case R.id.vpjiewu:
                intent = new Intent(getActivity(), vedioActivity.class);
                intent.putExtra("vedio_url", "");
                intent.putExtra("vedio_name","视频名称");
                intent.putExtra("vedio_class","视频分类");
                startActivity(intent);
                break;
            case R.id.vpxiandaiwu:
                intent = new Intent(getActivity(), vedioActivity.class);
                intent.putExtra("vedio_url", "");
                intent.putExtra("vedio_name","视频名称");
                intent.putExtra("vedio_class","视频分类");
                startActivity(intent);
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

