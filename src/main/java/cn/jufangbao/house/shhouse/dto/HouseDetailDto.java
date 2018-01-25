package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.*;

import java.util.List;

/**
 * HouseDetailDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:37:17.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class HouseDetailDto extends HouseDto {

    private Integer isFollowComm = 0;//是否关注小区,1关注 0未关注

    private Integer isFollowHouse = 0;//是否关注小区,1关注 0未关注

    private List<TSaImages> imageList;

    private List<TResHouseParam> paramList;

    private List<HouseQtType> houseQtList;

    private List<TResCommProp> commPropList;

    private TResHouseHot houseHot;

    private TResHouseLoan houseLoan;

    private TResComm community;

    private TResCommSale commSale;

    private String hlipath;

    private List<TResCommPtrend> commPtrendList;

    public List<TResCommPtrend> getCommPtrendList() {
        return commPtrendList;
    }

    public void setCommPtrendList(List<TResCommPtrend> commPtrendList) {
        this.commPtrendList = commPtrendList;
    }

    public String getHlipath() {
        return hlipath;
    }

    public void setHlipath(String hlipath) {
        this.hlipath = hlipath;
    }

    public Integer getIsFollowComm() {
        return isFollowComm;
    }

    public void setIsFollowComm(Integer isFollowComm) {
        this.isFollowComm = isFollowComm;
    }

    public Integer getIsFollowHouse() {
        return isFollowHouse;
    }

    public void setIsFollowHouse(Integer isFollowHouse) {
        this.isFollowHouse = isFollowHouse;
    }

    public TResComm getCommunity() {
        return community;
    }

    public void setCommunity(TResComm community) {
        this.community = community;
    }

    public List<TResHouseParam> getParamList() {
        return paramList;
    }

    public void setParamList(List<TResHouseParam> paramList) {
        this.paramList = paramList;
    }

    public List<HouseQtType> getHouseQtList() {
        return houseQtList;
    }

    public void setHouseQtList(List<HouseQtType> houseQtList) {
        this.houseQtList = houseQtList;
    }

    public List<TResCommProp> getCommPropList() {
        return commPropList;
    }

    public void setCommPropList(List<TResCommProp> commPropList) {
        this.commPropList = commPropList;
    }

    public TResHouseHot getHouseHot() {
        return houseHot;
    }

    public void setHouseHot(TResHouseHot houseHot) {
        this.houseHot = houseHot;
    }

    public TResHouseLoan getHouseLoan() {
        return houseLoan;
    }

    public void setHouseLoan(TResHouseLoan houseLoan) {
        this.houseLoan = houseLoan;
    }

    public TResCommSale getCommSale() {
        return commSale;
    }

    public void setCommSale(TResCommSale commSale) {
        this.commSale = commSale;
    }

    public List<TSaImages> getImageList() {
        return imageList;
    }

    public void setImageList(List<TSaImages> imageList) {
        this.imageList = imageList;
    }
}
