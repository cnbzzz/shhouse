package cn.jufangbao.house.shhouse.base;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * BaseResp.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:34:46.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class BaseResp<T> implements Serializable {

    public final static String SUCC = "1";

    public final static String FAIL = "0";

    public final static String FAIL_MSG = "操作失败";

    protected String retCode;

    protected String retMsg;

    protected T data;


    public static BaseResp succResp(){
        return new BaseResp(SUCC);
    }

    public static BaseResp succResp(String msg){
        return new BaseResp(SUCC, msg);
    }

    public static BaseResp failResp(){
        return new BaseResp(FAIL, FAIL_MSG);
    }

    public static BaseResp failResp(String msg){
        return new BaseResp(FAIL, msg);
    }

    public BaseResp() {}

    public BaseResp(String retCode) {
        this.retCode = retCode;
    }

    public BaseResp(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public BaseResp(String retCode, String retMsg, T data) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
