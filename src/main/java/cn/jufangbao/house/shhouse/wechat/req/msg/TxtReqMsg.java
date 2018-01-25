package cn.jufangbao.house.shhouse.wechat.req.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * TxtReqMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:45:49.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class TxtReqMsg extends BaseReqMsg {

    @XStreamAlias("Content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
