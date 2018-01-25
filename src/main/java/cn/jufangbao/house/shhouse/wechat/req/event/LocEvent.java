package cn.jufangbao.house.shhouse.wechat.req.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * LocEvent.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:45:15.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
@XStreamAlias("xml")
public class LocEvent extends BaseEvent {

    @XStreamAlias("Latitude")
    private String latitude;

    @XStreamAlias("Longitude")
    private String longitude;

    @XStreamAlias("Precision")
    private String precision;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
