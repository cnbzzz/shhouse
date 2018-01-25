package cn.jufangbao.house.shhouse.base;

import cn.jufangbao.house.shhouse.utils.TokenUtils;

/**
 * BaseUserResp.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:34:29.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class BaseUserResp<T> extends BaseResp {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public BaseUserResp(String aoid) {
        this.token = TokenUtils.encodeToken(aoid);
    }

    public BaseUserResp(){}

    public BaseUserResp(String aoid, String retCode) {
        this.token = TokenUtils.encodeToken(aoid);
        this.retCode = retCode;
    }

    public BaseUserResp(String aoid, String retCode, String retMsg) {
        this.token = TokenUtils.encodeToken(aoid);
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public BaseUserResp(String aoid, String retCode, String retMsg, T data) {
        this.token = TokenUtils.encodeToken(aoid);
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.data = data;
    }

    public static BaseUserResp succResp(String aoid){
        return new BaseUserResp(aoid, BaseResp.SUCC);
    }

    public static BaseUserResp succResp(String aoid, String msg){
        return new BaseUserResp(aoid, BaseResp.SUCC, msg);
    }

    public static BaseUserResp failResp(String aoid){
        return new BaseUserResp(aoid, BaseResp.FAIL, BaseResp.FAIL_MSG);
    }

    public static BaseUserResp failResp(String aoid, String msg){
        return new BaseUserResp(aoid, BaseResp.FAIL, msg);
    }
}
