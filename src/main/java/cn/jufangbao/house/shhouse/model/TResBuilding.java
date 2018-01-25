package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_res_building")
public class TResBuilding extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String coid;

    private String bname;

    private Long floor;

    /**
     * 图片表igroupoid字段
     */
    private String igroupoid;

    private Long icount;

    /**
     * 用户表主键
     */
    private String cuoid;

    private Date cdate;

    /**
     * 取字典 BUILDING_TYPE
     */
    private String btype;

    /**
     * 取字典 LAND_USE_TYPE
     */
    private String lutype;

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
     * @return bname
     */
    public String getBname() {
        return bname;
    }

    /**
     * @param bname
     */
    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    /**
     * @return floor
     */
    public Long getFloor() {
        return floor;
    }

    /**
     * @param floor
     */
    public void setFloor(Long floor) {
        this.floor = floor;
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
     * 获取取字典 BUILDING_TYPE
     *
     * @return btype - 取字典 BUILDING_TYPE
     */
    public String getBtype() {
        return btype;
    }

    /**
     * 设置取字典 BUILDING_TYPE
     *
     * @param btype 取字典 BUILDING_TYPE
     */
    public void setBtype(String btype) {
        this.btype = btype == null ? null : btype.trim();
    }

    /**
     * 获取取字典 LAND_USE_TYPE
     *
     * @return lutype - 取字典 LAND_USE_TYPE
     */
    public String getLutype() {
        return lutype;
    }

    /**
     * 设置取字典 LAND_USE_TYPE
     *
     * @param lutype 取字典 LAND_USE_TYPE
     */
    public void setLutype(String lutype) {
        this.lutype = lutype == null ? null : lutype.trim();
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