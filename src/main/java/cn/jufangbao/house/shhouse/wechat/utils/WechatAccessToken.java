package cn.jufangbao.house.shhouse.wechat.utils;

/**
 * WechatAccessToken.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:52:54.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class WechatAccessToken {
    // 获取到的凭证
    private String token;
    // 凭证有效时间，单位：秒
    private int expiresIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
