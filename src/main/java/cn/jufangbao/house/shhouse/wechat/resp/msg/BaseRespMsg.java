package cn.jufangbao.house.shhouse.wechat.resp.msg;

import java.io.Serializable;

/**
 * BaseRespMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:46:09.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class BaseRespMsg implements Serializable {

    public enum RespMsgType{
        text, image, voice, video, music, news
    }

    private String toUserName;

    private String fromUserName;

    private String createTime;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
