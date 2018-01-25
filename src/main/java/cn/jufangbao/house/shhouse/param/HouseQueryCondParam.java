package cn.jufangbao.house.shhouse.param;

import cn.jufangbao.house.shhouse.base.BaseReq;

import java.util.List;

/**
 * HouseQueryCondParam.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:40:13.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class HouseQueryCondParam extends BaseReq {

    private String seachstr;

    private Long rent = 0l; //0售房，1租房

    private String county; //区县

    private String areaid; //商圈id

    private String metroline; //地铁线id

    private String metroid; //地铁站id

    private Long startprice = 0l; //开始价格区间

    private Long endprice; //结束价格区间

    private List<String> hlayoutlist; //户型集合

    private List<String> orilist; //朝向集合

    private Long startarea = 0l; //开始面积区间

    private Long endarea; //结束面积区间

    private List<String> hlabellist; //标签集合

    public String getSeachstr() {
        return seachstr;
    }

    public void setSeachstr(String seachstr) {
        this.seachstr = seachstr;
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getMetroline() {
        return metroline;
    }

    public void setMetroline(String metroline) {
        this.metroline = metroline;
    }

    public String getMetroid() {
        return metroid;
    }

    public void setMetroid(String metroid) {
        this.metroid = metroid;
    }

    public Long getStartprice() {
        return startprice;
    }

    public void setStartprice(Long startprice) {
        this.startprice = startprice;
    }

    public Long getEndprice() {
        return endprice;
    }

    public void setEndprice(Long endprice) {
        this.endprice = endprice;
    }

    public List<String> getHlayoutlist() {
        return hlayoutlist;
    }

    public void setHlayoutlist(List<String> hlayoutlist) {
        this.hlayoutlist = hlayoutlist;
    }

    public List<String> getOrilist() {
        return orilist;
    }

    public void setOrilist(List<String> orilist) {
        this.orilist = orilist;
    }

    public Long getStartarea() {
        return startarea;
    }

    public void setStartarea(Long startarea) {
        this.startarea = startarea;
    }

    public Long getEndarea() {
        return endarea;
    }

    public void setEndarea(Long endarea) {
        this.endarea = endarea;
    }

    public List<String> getHlabellist() {
        return hlabellist;
    }

    public void setHlabellist(List<String> hlabellist) {
        this.hlabellist = hlabellist;
    }
}
