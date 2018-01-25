package cn.jufangbao.house.shhouse.wechat.req.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * SubsScanClickEvent.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:45:22.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
@XStreamAlias("xml")
public class SubsScanClickEvent extends BaseEvent {

    public enum EventKey {
        ershoufang //已看房源
        , zufang //看房日程
        , woyaochushou //我要出售
        , woyaochuzu //我要出租
        , wodefangyuan //我的房源
        , yikanfangyuan //已看房源
        , guanzhufangyuan //关注房源
        , dianhuazixun //电话咨询
        , lianxijingjiren; //联系经纪人

        public static SubsScanClickEvent.EventKey getEventKey(String eventKey) {
            return valueOf(eventKey);
        }
    }

    @XStreamAlias("EventKey")
    private String eventKey;

    @XStreamAlias("Ticket")
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
