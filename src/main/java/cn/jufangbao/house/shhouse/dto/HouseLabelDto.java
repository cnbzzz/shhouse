package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TResHouseLabel;

/**
 * HouseLabelDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:37:31.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class HouseLabelDto extends TResHouseLabel {

    private String dictid;

    private String dictname;

    public String getDictid() {
        return dictid;
    }

    public void setDictid(String dictid) {
        this.dictid = dictid;
    }

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname;
    }
}
