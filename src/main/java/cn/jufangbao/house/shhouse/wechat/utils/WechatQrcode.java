package cn.jufangbao.house.shhouse.wechat.utils;

import java.io.Serializable;

/**
 * WechatQrcode.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:53:00.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class WechatQrcode implements Serializable {

    private String qrcodeTicket;

    private String qrcodePath;

    public String getQrcodeTicket() {
        return qrcodeTicket;
    }

    public void setQrcodeTicket(String qrcodeTicket) {
        this.qrcodeTicket = qrcodeTicket;
    }

    public String getQrcodePath() {
        return qrcodePath;
    }

    public void setQrcodePath(String qrcodePath) {
        this.qrcodePath = qrcodePath;
    }
}
