package com.example.danceapp.dance;

/**
 * vedio
 */
public class VedioData {
    public VedioData(int imgId,String title)
    {
        this.imgId=imgId;
        this.title=title;
    }

    //消息内容
    private int imgId;//视频的图片
    private String title;//视频的名称

    //获取内容
    public int getImgId() {
        return imgId;
    }
    public String getContent() {
        return title;
    }
    //设置内容
    public void setContent(int imgId,String title) {
        this.imgId = imgId;
        this.title=title;
    }
}
