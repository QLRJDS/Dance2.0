package com.example.danceapp.dance;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinya LIANG on 2017/8/9.
 */
public class MusicListActivity extends Activity implements View.OnClickListener{
    private Button back,add_song,delete_btn;
    private List<MusicData> mData;
    private MusicAdapter mAdapter;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.musiclist);

        final ListView mListView=(ListView)findViewById(R.id.my_music_list);//音乐信息listview
        mData=LoadData();//测试数据
        mAdapter=new MusicAdapter(this, mData);
        mListView.setAdapter(mAdapter);
        mListView.smoothScrollToPositionFromTop(mData.size(), 0);
        //mAdapter.setOnDelItem(this);//删除
        add_song=(Button)findViewById(R.id.add_song);//添加
        add_song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicData data = new MusicData("abcdf", "1234567");
                mData.add(data);
                //构造输入消息
                mAdapter.Refresh();
            }
        });

        initView();
    }
    private void initView()
    {
        back= (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }

    //测试数据
    private List<MusicData> LoadData() {
        List<MusicData> datas = new ArrayList<MusicData>();

        MusicData data = new MusicData("om%2Falbums%2Fg85%2","111111111111111");
        datas.add(data);
        data = new MusicData("bbbbbbbbbbbb","2222222222222");
        datas.add(data);
        data = new MusicData("cccccccccccc", "333333333");
        datas.add(data);
        data = new MusicData("dddddddddddddd","4444444444444");
        datas.add(data);
        data = new MusicData("eeeeeeeeeeeeee", "55555555555");
        datas.add(data);
        data = new MusicData("fffff", "666666666666");
        datas.add(data);
        data = new MusicData("gggggggggggg", "77");
        datas.add(data);

        return datas;
    }
}
