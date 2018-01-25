package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TResHouseQt;

/**
 * HouseQtDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:37:55.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class HouseQtDto extends TResHouseQt {

    private String clazzname;

    private String sclazzname;

    private String dictname;

    public String getClazzname() {
        return clazzname;
    }

    public void setClazzname(String clazzname) {
        this.clazzname = clazzname;
    }

    public String getSclazzname() {
        return sclazzname;
    }

    public void setSclazzname(String sclazzname) {
        this.sclazzname = sclazzname;
    }

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname;
    }
}
