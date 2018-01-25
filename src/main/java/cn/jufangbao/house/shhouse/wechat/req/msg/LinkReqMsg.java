package cn.jufangbao.house.shhouse.wechat.req.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * LinkReqMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:45:36.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class LinkReqMsg extends BaseReqMsg {

    @XStreamAlias("Title")
    private String title;

    @XStreamAlias("Description")
    private String desc;

    @XStreamAlias("Url")
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
