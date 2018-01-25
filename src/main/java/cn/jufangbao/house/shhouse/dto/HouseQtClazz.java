package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.base.BaseKeyVal;

import java.util.List;

/**
 * HouseQtClazz.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:37:51.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class HouseQtClazz extends BaseKeyVal {

    private List<HouseQtDto> children;

    public List<HouseQtDto> getChildren() {
        return children;
    }

    public void setChildren(List<HouseQtDto> children) {
        this.children = children;
    }

    public HouseQtClazz() {
    }

    public HouseQtClazz(String key, String val) {
        super(key, val);
    }
}
