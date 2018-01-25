package cn.jufangbao.house.shhouse.wechat.req.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * BaseEvent.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:45:12.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class BaseEvent implements Serializable {

    public enum EventType {
        subscribe //订阅，扫描带参数的二维码（未关注）
        , unsubscribe //取消订阅
        , SCAN //扫描带参数的二维码（已关注）
        , LOCATION //上报位置信息
        , CLICK //点击菜单
        , VIEW; //点击菜单跳转事件

        public static EventType getEventType(String eventType) {
            return valueOf(eventType);
        }
    }

    @XStreamAlias("ToUserName")
    private String toUserName;

    @XStreamAlias("FromUserName")
    private String fromUserName;

    @XStreamAlias("CreateTime")
    private String createTime;

    @XStreamAlias("ReqMsgType")
    private String reqMsgType;

    @XStreamAlias("Event")
    private String event;

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

    public String getReqMsgType() {
        return reqMsgType;
    }

    public void setReqMsgType(String reqMsgType) {
        this.reqMsgType = reqMsgType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
