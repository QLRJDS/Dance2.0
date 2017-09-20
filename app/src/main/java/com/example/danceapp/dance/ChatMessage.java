package com.example.danceapp.dance;

/**
 * 定义聊天消息类
 */
public class ChatMessage {

    //定义3种布局类型，时间、发送、接收
    public static final int MessageType_Time=0;
    public static final int MessageType_From=1;
    public static final int MessageType_To=2;

    public ChatMessage(int Type,String Content,String name)//有消息类型、消息、姓名。用于创建接收方和发送发消息
    {
        this.mType=Type;
        this.mContent=Content;
        this.mName=name;
    }
    public ChatMessage(int Type,String Content)//有消息类型和消息。用于创建时间信息
    {
        this.mType=Type;
        this.mContent=Content;
    }

    //消息类型
    private int mType;
    //消息内容
    private String mContent;
    //姓名
    private String mName;
    //获取类型
    public int getType() {return mType;}
    //设置类型
    public void setType(int mType) {this.mType = mType;}
    //获取消息内容
    public String getContent() {
        return mContent;
    }
    //设置消息内容
    public void setContent(String mContent) {
        this.mContent = mContent;
    }
    //获取姓名
    public String getName() {return mName;}
    //设置姓名
    public void setName(String mName) {
        this.mName = mName;
    }
}
