package cn.jufangbao.house.shhouse.wechat.utils;

/**
 * WechatButton.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:52:54.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class WechatButton {

    private String name;

    private String type; //click是点击事件，view是跳转事件

    private String key;

    private String url;

    private WechatButton[] sub_button;

    public WechatButton[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(WechatButton[] sub_button) {
        this.sub_button = sub_button;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
