package com.example.danceapp.dance;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态添加视频listview
 */
public class VedioListActivity extends Activity{

    private Button back_to_home;
    private List<VedioData> mData;
    private VedioAdapter mAdapter;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vedios);

        final ListView mListView=(ListView)findViewById(R.id.vedio_list);//listview
        mData=LoadData();//测试数据
        mAdapter=new VedioAdapter(this, mData);
        mListView.setAdapter(mAdapter);
        mListView.smoothScrollToPositionFromTop(mData.size(), 0);

    }

    //测试数据
    private List<VedioData> LoadData() {
        List<VedioData> datas = new ArrayList<VedioData>();

        VedioData data = new VedioData(R.mipmap.p3,"视频名称");
        datas.add(data);
        data = new VedioData(R.mipmap.p1,"视频名称视频名称");
        datas.add(data);
        data = new VedioData(R.mipmap.p2, "视频名称视频名称");
        datas.add(data);
        data = new VedioData(R.mipmap.p3,"视频名");
        datas.add(data);
        data = new VedioData(R.mipmap.p1,"视频名称22222222");
        datas.add(data);
        data = new VedioData(R.mipmap.p2, "333视频名称333");
        datas.add(data);
        data = new VedioData(R.mipmap.p3,"4444444444444");
        datas.add(data);

        return datas;
    }
}
