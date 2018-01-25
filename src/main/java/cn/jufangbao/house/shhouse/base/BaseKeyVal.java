package cn.jufangbao.house.shhouse.base;

/**
 * BaseKeyVal.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:34:56.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class BaseKeyVal extends BaseDto {


    private String key;

    private String val;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public BaseKeyVal(){}


    public BaseKeyVal(String key, String val) {
        this.key = key;
        this.val = val;
    }

}
