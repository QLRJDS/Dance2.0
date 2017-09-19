package com.example.danceapp.dance;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * 视频播放页 对应vedio_item.xml
 */
public class vedioActivity extends Activity implements View.OnClickListener{

    ImageButton collect,download;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vedio_item);

        initView();
    }

    private void initView()//初始化控件
    {
        collect= (ImageButton) findViewById(R.id.collect);
        collect.setOnClickListener(this);

       download = (ImageButton) findViewById(R.id.download);
        download.setOnClickListener(this) ;
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
        }

    }
}
