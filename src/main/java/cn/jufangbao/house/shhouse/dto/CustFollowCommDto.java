package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TResComm;

import java.util.Date;

/**
 * CustFollowCommDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:36:27.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class CustFollowCommDto extends TResComm {

    private Date followdate;

    private String custid;

    private String custname;

    private Long phonenum;

    private Long salecount;

    private Long rentcount;

    private Long saledcount;

    private Long rentedcount;

    private String hlayouts; //户型

    private String commfollowcount; //小区关注数

    private String buildingtypes; //楼型

    public String getHlayouts() {
        return hlayouts;
    }

    public void setHlayouts(String hlayouts) {
        this.hlayouts = hlayouts;
    }

    public String getCommfollowcount() {
        return commfollowcount;
    }

    public void setCommfollowcount(String commfollowcount) {
        this.commfollowcount = commfollowcount;
    }

    public String getBuildingtypes() {
        return buildingtypes;
    }

    public void setBuildingtypes(String buildingtypes) {
        this.buildingtypes = buildingtypes;
    }

    public Long getSalecount() {
        return salecount;
    }

    public void setSalecount(Long salecount) {
        this.salecount = salecount;
    }

    public Long getRentcount() {
        return rentcount;
    }

    public void setRentcount(Long rentcount) {
        this.rentcount = rentcount;
    }

    public Long getSaledcount() {
        return saledcount;
    }

    public void setSaledcount(Long saledcount) {
        this.saledcount = saledcount;
    }

    public Long getRentedcount() {
        return rentedcount;
    }

    public void setRentedcount(Long rentedcount) {
        this.rentedcount = rentedcount;
    }

    public Long getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(Long phonenum) {
        this.phonenum = phonenum;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public Date getFollowdate() {
        return followdate;
    }

    public void setFollowdate(Date followdate) {
        this.followdate = followdate;
    }
}
