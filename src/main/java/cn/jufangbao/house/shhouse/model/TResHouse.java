package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_res_house")
public class TResHouse extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String boid;

    private String coid;

    private String hname;

    private String serialnum;

    private String hnum;

    /**
     * 楼层/总楼层 格式
     例如：1/28
     */
    private String floor;

    /**
     * 取字典 HOUSE_DECORATION
     */
    private String decoration;

    /**
     * 取字典 HOUSE_ORIENTATION
     */
    private String orientation;

    /**
     * 取字典 HOUSE_LAYOUT
     */
    private String hlayout;

    /**
     * 格式：yyyy
     */
    private Short year;

    /**
     * 单位 平米
     */
    private Long area;

    /**
     * 单位 分
     */
    private Long totalprice;

    /**
     * 单位 分
     */
    private Long unitprice;

    /**
     * 单位：分
     */
    private Long downpayment;

    /**
     * 列表缩略图路径
     */
    private String ipath;

    /**
     * 图片表igroupoid字段
     */
    private String igroupoid;

    private Long icount;

    private Long recomindex;

    /**
     * 0 售房
     1 租房
     */
    private Integer rent;

    /**
     * 用户表主键
     */
    private String fuoid;

    /**
     * 用户表主键
     */
    private String suoid;

    /**
     * 用户表主键
     */
    private String cuoid;

    private Date cdate;

    /**
     * 取字典 HOUSE_SALE_STATUS
     */
    private String status;

    /**
     * @return oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid
     */
    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    /**
     * @return boid
     */
    public String getBoid() {
        return boid;
    }

    /**
     * @param boid
     */
    public void setBoid(String boid) {
        this.boid = boid == null ? null : boid.trim();
    }

    /**
     * @return coid
     */
    public String getCoid() {
        return coid;
    }

    /**
     * @param coid
     */
    public void setCoid(String coid) {
        this.coid = coid == null ? null : coid.trim();
    }

    /**
     * @return hname
     */
    public String getHname() {
        return hname;
    }

    /**
     * @param hname
     */
    public void setHname(String hname) {
        this.hname = hname == null ? null : hname.trim();
    }

    /**
     * @return serialnum
     */
    public String getSerialnum() {
        return serialnum;
    }

    /**
     * @param serialnum
     */
    public void setSerialnum(String serialnum) {
        this.serialnum = serialnum == null ? null : serialnum.trim();
    }

    /**
     * @return hnum
     */
    public String getHnum() {
        return hnum;
    }

    /**
     * @param hnum
     */
    public void setHnum(String hnum) {
        this.hnum = hnum == null ? null : hnum.trim();
    }

    /**
     * 获取楼层/总楼层 格式
     例如：1/28
     *
     * @return floor - 楼层/总楼层 格式
    例如：1/28
     */
    public String getFloor() {
        return floor;
    }

    /**
     * 设置楼层/总楼层 格式
     例如：1/28
     *
     * @param floor 楼层/总楼层 格式
    例如：1/28
     */
    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    /**
     * 获取取字典 HOUSE_DECORATION
     *
     * @return decoration - 取字典 HOUSE_DECORATION
     */
    public String getDecoration() {
        return decoration;
    }

    /**
     * 设置取字典 HOUSE_DECORATION
     *
     * @param decoration 取字典 HOUSE_DECORATION
     */
    public void setDecoration(String decoration) {
        this.decoration = decoration == null ? null : decoration.trim();
    }

    /**
     * 获取取字典 HOUSE_ORIENTATION
     *
     * @return orientation - 取字典 HOUSE_ORIENTATION
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * 设置取字典 HOUSE_ORIENTATION
     *
     * @param orientation 取字典 HOUSE_ORIENTATION
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation == null ? null : orientation.trim();
    }

    /**
     * 获取取字典 HOUSE_LAYOUT
     *
     * @return hlayout - 取字典 HOUSE_LAYOUT
     */
    public String getHlayout() {
        return hlayout;
    }

    /**
     * 设置取字典 HOUSE_LAYOUT
     *
     * @param hlayout 取字典 HOUSE_LAYOUT
     */
    public void setHlayout(String hlayout) {
        this.hlayout = hlayout == null ? null : hlayout.trim();
    }

    /**
     * 获取格式：yyyy
     *
     * @return year - 格式：yyyy
     */
    public Short getYear() {
        return year;
    }

    /**
     * 设置格式：yyyy
     *
     * @param year 格式：yyyy
     */
    public void setYear(Short year) {
        this.year = year;
    }

    /**
     * 获取单位 平米
     *
     * @return area - 单位 平米
     */
    public Long getArea() {
        return area;
    }

    /**
     * 设置单位 平米
     *
     * @param area 单位 平米
     */
    public void setArea(Long area) {
        this.area = area;
    }

    /**
     * 获取单位 分
     *
     * @return totalprice - 单位 分
     */
    public Long getTotalprice() {
        return totalprice;
    }

    /**
     * 设置单位 分
     *
     * @param totalprice 单位 分
     */
    public void setTotalprice(Long totalprice) {
        this.totalprice = totalprice;
    }

    /**
     * 获取单位 分
     *
     * @return unitprice - 单位 分
     */
    public Long getUnitprice() {
        return unitprice;
    }

    /**
     * 设置单位 分
     *
     * @param unitprice 单位 分
     */
    public void setUnitprice(Long unitprice) {
        this.unitprice = unitprice;
    }

    /**
     * 获取单位：分
     *
     * @return downpayment - 单位：分
     */
    public Long getDownpayment() {
        return downpayment;
    }

    /**
     * 设置单位：分
     *
     * @param downpayment 单位：分
     */
    public void setDownpayment(Long downpayment) {
        this.downpayment = downpayment;
    }

    /**
     * 获取列表缩略图路径
     *
     * @return ipath - 列表缩略图路径
     */
    public String getIpath() {
        return ipath;
    }

    /**
     * 设置列表缩略图路径
     *
     * @param ipath 列表缩略图路径
     */
    public void setIpath(String ipath) {
        this.ipath = ipath == null ? null : ipath.trim();
    }

    /**
     * 获取图片表igroupoid字段
     *
     * @return igroupoid - 图片表igroupoid字段
     */
    public String getIgroupoid() {
        return igroupoid;
    }

    /**
     * 设置图片表igroupoid字段
     *
     * @param igroupoid 图片表igroupoid字段
     */
    public void setIgroupoid(String igroupoid) {
        this.igroupoid = igroupoid == null ? null : igroupoid.trim();
    }

    /**
     * @return icount
     */
    public Long getIcount() {
        return icount;
    }

    /**
     * @param icount
     */
    public void setIcount(Long icount) {
        this.icount = icount;
    }

    /**
     * @return recomindex
     */
    public Long getRecomindex() {
        return recomindex;
    }

    /**
     * @param recomindex
     */
    public void setRecomindex(Long recomindex) {
        this.recomindex = recomindex;
    }

    /**
     * 获取0 售房
     1 租房
     *
     * @return rent - 0 售房
    1 租房
     */
    public Integer getRent() {
        return rent;
    }

    /**
     * 设置0 售房
     1 租房
     *
     * @param rent 0 售房
    1 租房
     */
    public void setRent(Integer rent) {
        this.rent = rent;
    }

    /**
     * 获取用户表主键
     *
     * @return fuoid - 用户表主键
     */
    public String getFuoid() {
        return fuoid;
    }

    /**
     * 设置用户表主键
     *
     * @param fuoid 用户表主键
     */
    public void setFuoid(String fuoid) {
        this.fuoid = fuoid == null ? null : fuoid.trim();
    }

    /**
     * 获取用户表主键
     *
     * @return suoid - 用户表主键
     */
    public String getSuoid() {
        return suoid;
    }

    /**
     * 设置用户表主键
     *
     * @param suoid 用户表主键
     */
    public void setSuoid(String suoid) {
        this.suoid = suoid == null ? null : suoid.trim();
    }

    /**
     * 获取用户表主键
     *
     * @return cuoid - 用户表主键
     */
    public String getCuoid() {
        return cuoid;
    }

    /**
     * 设置用户表主键
     *
     * @param cuoid 用户表主键
     */
    public void setCuoid(String cuoid) {
        this.cuoid = cuoid == null ? null : cuoid.trim();
    }

    /**
     * @return cdate
     */
    public Date getCdate() {
        return cdate;
    }

    /**
     * @param cdate
     */
    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    /**
     * 获取取字典 HOUSE_SALE_STATUS
     *
     * @return status - 取字典 HOUSE_SALE_STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置取字典 HOUSE_SALE_STATUS
     *
     * @param status 取字典 HOUSE_SALE_STATUS
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}