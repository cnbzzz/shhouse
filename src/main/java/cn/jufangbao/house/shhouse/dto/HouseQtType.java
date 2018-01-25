package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.base.BaseKeyVal;

import java.util.List;

/**
 * HouseQtType.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:37:59.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class HouseQtType extends BaseKeyVal {

    private List<HouseQtClazz> children;

    public List<HouseQtClazz> getChildren() {
        return children;
    }

    public void setChildren(List<HouseQtClazz> children) {
        this.children = children;
    }

    public HouseQtType() {
    }

    public HouseQtType(String key, String val) {
        super(key, val);
    }

}
