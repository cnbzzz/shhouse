package cn.jufangbao.house.shhouse.wechat.resp.msg.news;

import java.io.Serializable;

/**
 * NewsArticle.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:46:05.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class NewsArticle implements Serializable {

    private String title;

    private String desc;

    private String picUrl;

    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
