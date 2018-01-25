package cn.jufangbao.house.shhouse.wechat.req.msg;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * BaseReqMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:45:29.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class BaseReqMsg implements Serializable {

    public enum ReqMsgType {
        text, image, voice, video, shortvideo, location, link, event;

        public static ReqMsgType getReqMsgType(String msgType) {
            return valueOf(msgType.toLowerCase());
        }
    }

    @XStreamAlias("ToUserName")
    private String toUserName;

    @XStreamAlias("FromUserName")
    private String fromUserName;

    @XStreamAlias("CreateTime")
    private String createTime;

    @XStreamAlias("MsgType")
    private String msgType;

    @XStreamAlias("MsgId")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

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

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
