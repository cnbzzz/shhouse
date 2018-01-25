package cn.jufangbao.house.shhouse.wechat.req.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * LocReqMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:45:45.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class LocReqMsg extends BaseReqMsg {

    @XStreamAlias("Location_X")
    private String locX;

    @XStreamAlias("Location_Y")
    private String locY;

    @XStreamAlias("Scale")
    private String scale;

    @XStreamAlias("Label")
    private String label;

    public String getLocX() {
        return locX;
    }

    public void setLocX(String locX) {
        this.locX = locX;
    }

    public String getLocY() {
        return locY;
    }

    public void setLocY(String locY) {
        this.locY = locY;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
