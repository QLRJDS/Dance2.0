package com.example.danceapp.dance;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinya LIANG on 2017/9/17.
 */
public class HistoryActivity extends Activity{
    private List<VedioData> vData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_history);

        vData=LoadData();//测试数据
        ListView lv_history = (ListView)findViewById(R.id.lv_history);
        lv_history.setAdapter(new MyListAdapter(this, vData));

    }

    //
    private class MyListAdapter extends BaseAdapter{private Context mContext;
        private List<VedioData> vData;

        public MyListAdapter(Context context,List<VedioData> data)
        {
            this.mContext=context;
            this.vData=data;
        }
        @Override
        public int getCount(){
            return vData.size();
        }
        @Override
        public Object getItem(int position){
            return vData.get(position);
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View view;
            ImageView image;
            TextView title;

            view = View.inflate(getApplicationContext(),R.layout.videolist_item,null);
            image = (ImageView)view.findViewById(R.id.vl_image);
            //image.setImage什么(vData.get(position).getImgId());                 //这一行搞不定，舞蹈图片
            title = (TextView)view.findViewById(R.id.vl_name);
            title.setText(vData.get(position).getContent());

            return view;
        }
    }//测试数据
    private List<VedioData> LoadData() {
        List<VedioData> datas = new ArrayList<VedioData>();

        VedioData data = new VedioData("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505792787888&di=c67252f22deb9cdacdb19095ec1e4f0c&imgtype=0&src=http%3A%2F%2Fi54.photobucket.com%2Falbums%2Fg85%2Fthslang%2F15.jpg","111111111111111");
        datas.add(data);
        data = new VedioData("path1","四小天鹅舞");
        datas.add(data);
        data = new VedioData("cccccccccccc", "小苹果");
        datas.add(data);
        data = new VedioData("dddddddddddddd","4444444444444");
        datas.add(data);
        data = new VedioData("eeeeeeeeeeeeee", "55555555555");
        datas.add(data);
        data = new VedioData("fffff", "666666666666");
        datas.add(data);
        data = new VedioData("gggggggggggg", "77");
        datas.add(data);

        return datas;
    }
}
