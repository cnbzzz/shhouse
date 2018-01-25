package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_res_house_waiting")
public class TResHouseWaiting extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String cname;

    private String city;

    private String floor;

    private String unit;

    private String hnum;

    private String attr;

    /**
     * 0售房
     1租房
     */
    private String rent;

    /**
     * 单位 分
     */
    private Long price;

    private String callname;

    private Long phonenum;

    /**
     * 客户表主键
     */
    private String coid;

    /**
     * 经纪人表主键
     */
    private String aoid;

    /**
     * 用户表主键
     */
    private String cuoid;

    private Date cdate;

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
     * @return cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * @param floor
     */
    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    /**
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
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
     * @return attr
     */
    public String getAttr() {
        return attr;
    }

    /**
     * @param attr
     */
    public void setAttr(String attr) {
        this.attr = attr == null ? null : attr.trim();
    }

    /**
     * 获取0售房
     1租房
     *
     * @return rent - 0售房
    1租房
     */
    public String getRent() {
        return rent;
    }

    /**
     * 设置0售房
     1租房
     *
     * @param rent 0售房
    1租房
     */
    public void setRent(String rent) {
        this.rent = rent == null ? null : rent.trim();
    }

    /**
     * 获取单位 分
     *
     * @return price - 单位 分
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 设置单位 分
     *
     * @param price 单位 分
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return callname
     */
    public String getCallname() {
        return callname;
    }

    /**
     * @param callname
     */
    public void setCallname(String callname) {
        this.callname = callname == null ? null : callname.trim();
    }

    /**
     * @return phonenum
     */
    public Long getPhonenum() {
        return phonenum;
    }

    /**
     * @param phonenum
     */
    public void setPhonenum(Long phonenum) {
        this.phonenum = phonenum;
    }

    /**
     * 获取客户表主键
     *
     * @return coid - 客户表主键
     */
    public String getCoid() {
        return coid;
    }

    /**
     * 设置客户表主键
     *
     * @param coid 客户表主键
     */
    public void setCoid(String coid) {
        this.coid = coid == null ? null : coid.trim();
    }

    /**
     * 获取经纪人表主键
     *
     * @return aoid - 经纪人表主键
     */
    public String getAoid() {
        return aoid;
    }

    /**
     * 设置经纪人表主键
     *
     * @param aoid 经纪人表主键
     */
    public void setAoid(String aoid) {
        this.aoid = aoid == null ? null : aoid.trim();
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
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}