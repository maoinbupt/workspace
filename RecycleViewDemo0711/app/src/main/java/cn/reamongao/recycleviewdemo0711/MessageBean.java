package cn.reamongao.recycleviewdemo0711;

import android.app.PendingIntent;

/**
 * Created by GaoFeng on 2017.07.12.
 */

public class MessageBean {

    private String title;
    private String content;
    private int picId;

    public MessageBean(String title, String content, int picId) {
        this.title = title;
        this.content = content;
        this.picId = picId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }
}
