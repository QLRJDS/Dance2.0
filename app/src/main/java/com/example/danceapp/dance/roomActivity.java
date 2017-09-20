package com.example.danceapp.dance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 * Created by Jinya LIANG on 2017/8/6.
 */
//音乐播放，聊天
public class roomActivity extends Activity
        implements View.OnClickListener {

    private TextView music_name;//音乐名称
    private RelativeLayout music_bar;
    private ChangeButton music_control_btn;//音乐播放暂停按钮
    //聊天
    private Button BtnSend,last,next,back;//发送，上一首、下一首
    private EditText InputBox;
    private List<ChatMessage> mData;
    private ChatAdapter mAdapter;

    private String title="无音乐";

    private String artist="佚名";

    private int musicPosition=-1;

    private Boolean isPause;

    private Boolean isPlaying;


    List<Mp3> mp3Infos = null;



    private boolean isOwner=true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_room);

        final ListView mListView=(ListView)findViewById(R.id.chatList);//聊天信息listview
        mData=LoadData();
        mAdapter=new ChatAdapter(this, mData);
        mListView.setAdapter(mAdapter);
        mListView.smoothScrollToPositionFromTop(mData.size(), 0);
        InputBox=(EditText)findViewById(R.id.InputBox);//输入框
        BtnSend=(Button)findViewById(R.id.BtnSend);//发送按钮
        BtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (InputBox.getText().toString() != "") {
                    //获取时间
                    Calendar c = Calendar.getInstance();
                    StringBuilder mBuilder = new StringBuilder();
                    mBuilder.append(Integer.toString(c.get(Calendar.YEAR)) + "年");
                    mBuilder.append(Integer.toString(c.get(Calendar.MONTH)) + "月");
                    mBuilder.append(Integer.toString(c.get(Calendar.DATE)) + "日");
                    mBuilder.append(Integer.toString(c.get(Calendar.HOUR_OF_DAY)) + ":");
                    mBuilder.append(Integer.toString(c.get(Calendar.MINUTE)));
                    //构造时间消息
                    ChatMessage Message = new ChatMessage(ChatMessage.MessageType_Time, mBuilder.toString(),"time1");
                    mData.add(Message);
                    //构造输入消息
                    Message = new ChatMessage(ChatMessage.MessageType_To, InputBox.getText().toString(),"time2");
                    mData.add(Message);
                    //构造返回消息，如果这里加入网络的功能，那么这里将变成一个网络机器人
                    Message = new ChatMessage(ChatMessage.MessageType_From, "收到！","机器人");
                    mData.add(Message);
                    //更新数据
                    mAdapter.Refresh();
                }
                //清空输入框
                InputBox.setText("");
                //关闭输入法
                imm.hideSoftInputFromWindow(null, InputMethodManager.HIDE_IMPLICIT_ONLY);
                //滚动列表到当前消息
                mListView.smoothScrollToPositionFromTop(mData.size(), 0);
            }
        });

        initView();

        //modified below.

        mp3Infos=MediaUtil.getMp3(getApplicationContext());
        if(isOwner){
            setOnClickListener();
        }

        Intent intent=getIntent();
        if(intent!=null){
            title=intent.getStringExtra("title");
            artist=intent.getStringExtra("artist");
            musicPosition=intent.getIntExtra("musicPosition",-1);
        }
        music_name.setText(title);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);    //运行时权限申请，申请访问SD卡的权限
        } else {
//            Toast.makeText(this, "onCreate..", Toast.LENGTH_SHORT).show();
//            initMediaPlayer();  //初始化播放器
        }
    }

    private void initView(){

        music_bar=(RelativeLayout)findViewById(R.id.music_bar);

        music_control_btn = (ChangeButton) findViewById(R.id.music_control_btn);

        last =(Button)findViewById(R.id.last);

        next = (Button) findViewById(R.id.next);

        back = (Button) findViewById(R.id.back);

        music_name =(TextView)findViewById(R.id.music_name);
    }

    private void setOnClickListener(){
        music_bar.setOnClickListener(this);
        music_control_btn.setOnClickListener(this) ;
        last.setOnClickListener(this) ;
        next.setOnClickListener(this) ;

        back.setOnClickListener(this) ;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "onRequestPermissionsResult..", Toast.LENGTH_SHORT).show();
//                    initMediaPlayer();
                } else {
                    Toast.makeText(this, "拒绝权限无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    @Override
    public void onClick(View v){
        Intent intent=new Intent(this,MusicService.class);
        switch (v.getId()) {

            case R.id.music_control_btn:
                if(musicPosition==-1){
                    Toast.makeText(this,"请先选择音乐",Toast.LENGTH_SHORT).show();
                } else if(isPause) {
                    //更改图标语句，下同
                    intent.putExtra("musicPosition",musicPosition);
                    intent.putExtra("MSG",Constant.PLAY_MSG);
                    startService(intent);
                    isPause=false;
                    isPlaying=true;
                } else if(isPlaying) {
                    intent.putExtra("url",mp3Infos.get(musicPosition).getUrl());
                    intent.putExtra("musicPosition",musicPosition);
                    intent.putExtra("MSG",Constant.PAUSE_MSG);
                    startService(intent);
                    isPause=true;
                    isPlaying=false;
                }
                break;
            case R.id.last:
                if(musicPosition==-1) {
                    Toast.makeText(this, "请先选择音乐", Toast.LENGTH_SHORT).show();
                } else {
                    musicPosition=musicPosition-1;
                    intent.putExtra("url",mp3Infos.get(musicPosition).getUrl());
                    intent.putExtra("musicPosition",musicPosition);
                    intent.putExtra("MSG",Constant.PREVIOUS_MSG);
                    startService(intent);
                    isPause=false;
                    isPlaying=true;
                }
                break;
            case R.id.next:
                if(musicPosition==-1) {
                    Toast.makeText(this, "请先选择音乐", Toast.LENGTH_SHORT).show();
                } else {
                    musicPosition=musicPosition+1;
                    intent.putExtra("url",mp3Infos.get(musicPosition).getUrl());
                    intent.putExtra("musicPosition",musicPosition);
                    intent.putExtra("MSG",Constant.NEXT_MSG);
                    startService(intent);
                    isPause=false;
                    isPlaying=true;
                }
                break;

            case R.id.music_bar:
                Intent intent2 = new Intent(this,MusicActivity.class);
                intent2.putExtra("title",title);
                intent2.putExtra("artist",artist);
                intent2.putExtra("musicPosition",musicPosition);
                startActivity(intent2);

            default:
                break;
        }
    }

    //测试数据
    private List<ChatMessage> LoadData()
    {
        List<ChatMessage> Messages=new ArrayList<ChatMessage>();

        ChatMessage Message=new ChatMessage(ChatMessage.MessageType_Time,"2017年8月8日","shijian");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_From,"山重水复疑无路","小李");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_To,"柳暗花明又一村","xiaoliu");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_From,"青青子衿，悠悠我心","xiaobing");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_To,"但为君故，沉吟至今","wo");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_Time,"19：25","");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_From,"这是你做的Android程序吗？");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_To,"是的是的是的是的我是一个长长长长长长长长长的消息，我长长长长长长长长长吗");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_From,"为什么对话框的颜色这么丑");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_To,"因为还没有进行调整");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_From,"哦哦，呵呵，你又在偷懒了");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_To,"因为时间紧迫");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_From,"好吧，可是怎么发语音啊");
        Messages.add(Message);

        Message=new ChatMessage(ChatMessage.MessageType_To,"过两天再发语音吧，这两天还是多练练打字");
        Messages.add(Message);
        return Messages;
    }

}

