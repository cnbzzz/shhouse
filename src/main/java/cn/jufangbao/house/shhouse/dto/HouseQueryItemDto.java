package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.base.BaseDto;

import java.util.List;

/**
 * HouseQueryItemDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:38:04.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class HouseQueryItemDto extends BaseDto {

    public static final String METRO = "metro";

    public static final String COUNTY = "county";

    public static final String LAYOUT = "layout";

    public static final String ORIE = "orie";

    public static final String LABEL = "label";

    private String dictid;

    private String dictname;

    private Long leaf;

    private String pid;

    private String type;

    private List<HouseQueryItemDto> children;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public Long getLeaf() {
        return leaf;
    }

    public void setLeaf(Long leaf) {
        this.leaf = leaf;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<HouseQueryItemDto> getChildren() {
        return children;
    }

    public void setChildren(List<HouseQueryItemDto> children) {
        this.children = children;
    }
}
