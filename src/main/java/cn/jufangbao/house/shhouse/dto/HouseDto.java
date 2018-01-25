package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TResHouse;

/**
 * HouseDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:37:21.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class HouseDto extends TResHouse {

    private String decoName;

    private String orieName;

    private String statName;

    private String layoutName;

    private String hlabelNames;

    private String cname;

    private String btypename;

    private String lutypename;

    private String anames;

    private Long totalfloor;

    private String clabels;

    private String cipath;

    private Long housebrowse;

    private Long housefollow;

    private Long houseseen;

    public Long getHousebrowse() {
        return housebrowse;
    }

    public void setHousebrowse(Long housebrowse) {
        this.housebrowse = housebrowse;
    }

    public Long getHousefollow() {
        return housefollow;
    }

    public void setHousefollow(Long housefollow) {
        this.housefollow = housefollow;
    }

    public Long getHouseseen() {
        return houseseen;
    }

    public void setHouseseen(Long houseseen) {
        this.houseseen = houseseen;
    }

    public String getCipath() {
        return cipath;
    }

    public void setCipath(String cipath) {
        this.cipath = cipath;
    }

    public String getClabels() {
        return clabels;
    }

    public void setClabels(String clabels) {
        this.clabels = clabels;
    }

    public String getDecoName() {
        return decoName;
    }

    public void setDecoName(String decoName) {
        this.decoName = decoName;
    }

    public String getOrieName() {
        return orieName;
    }

    public void setOrieName(String orieName) {
        this.orieName = orieName;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    public String getHlabelNames() {
        return hlabelNames;
    }

    public void setHlabelNames(String hlabelNames) {
        this.hlabelNames = hlabelNames;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBtypename() {
        return btypename;
    }

    public void setBtypename(String btypename) {
        this.btypename = btypename;
    }

    public String getLutypename() {
        return lutypename;
    }

    public void setLutypename(String lutypename) {
        this.lutypename = lutypename;
    }

    public String getAnames() {
        return anames;
    }

    public void setAnames(String anames) {
        this.anames = anames;
    }

    public Long getTotalfloor() {
        return totalfloor;
    }

    public void setTotalfloor(Long totalfloor) {
        this.totalfloor = totalfloor;
    }
}
