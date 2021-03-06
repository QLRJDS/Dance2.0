package com.example.danceapp.dance;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * 视频播放页 对应vedio_item.xml
 */
public class vedioActivity extends Activity implements View.OnClickListener {

    ImageButton collect, download, xuan;
    private VideoView mVideoView01;
    MediaController mediaController;
    TextView vedio_name_tv,vedio_class_tv;
    int h;
    float density;
    Configuration mConfiguration;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vedio_item);
        initView();

        //接收传过来的数据，，，设置视频
        Intent intent=getIntent();
        String vedio_class=intent.getStringExtra("vedio_url");//接收视频分类
        vedio_class_tv = (TextView) findViewById(R.id.vedio_type);
        vedio_class_tv.setText(vedio_class);

        String vedio_name=intent.getStringExtra("vedio_name");//接收视频名称
        vedio_name_tv= (TextView) findViewById(R.id.vedio_name);
        vedio_name_tv.setText(vedio_name);

        String vedio=intent.getStringExtra("vedio_class");//接收视频url
        mVideoView01 = (VideoView) findViewById(R.id.videoView);//设置视频
        mVideoView01.setVideoURI(Uri.parse("http://www.huaishuo123.cn:8080/HouTai/video/1.mp4"));

        //mVideoView01.setVideoURI(Uri.parse("http://www.huaishuo123.cn:8080/HouTai/video/1.mp4"));
        mediaController = new MediaController(vedioActivity.this);

        mVideoView01.requestFocus();
        h = this.getWindowManager().getDefaultDisplay().getHeight();
        System.err.println(h);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
        System.err.println(density);
        mConfiguration = this.getResources().getConfiguration(); //获取设置的配置信息
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mVideoView01.setLayoutParams(layoutParams);
        mVideoView01.setMediaController(mediaController);
        mVideoView01.start();
    }


    private void initView()//初始化控件
    {
        mConfiguration = this.getResources().getConfiguration(); //获取设置的配置信息
        int ori = mConfiguration.orientation; //获取屏幕方向
        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {

            xuan = (ImageButton) findViewById(R.id.xuan);
            xuan.setOnClickListener(this);
        } else {
            collect = (ImageButton) findViewById(R.id.collect);
            collect.setOnClickListener(this);

            download = (ImageButton) findViewById(R.id.download);
            download.setOnClickListener(this);

            xuan = (ImageButton) findViewById(R.id.xuan);
            xuan.setOnClickListener(this);
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.collect://返回上一页
                //收藏
                Toast.makeText(getApplicationContext(), "收藏成功",//测试数据
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.download:
                //下载
                Toast.makeText(getApplicationContext(), "进行下载",//测试数据
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.xuan:
                int ori = mConfiguration.orientation; //获取屏幕方向
                if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
                break;
        }

    }
}