package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_res_hlayout")
public class TResHlayout extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 小区表主键
     */
    private String coid;

    /**
     * 楼盘表主键
     */
    private String boid;

    /**
     * 取字典 HOUSE_LAYOUT
     */
    private String hlayout;

    private String hlipath;

    /**
     * 用户表主键
     */
    private String cuoid;

    private Date cdate;

    /**
     * 1显示
     0不显示
     */
    private Integer status;

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
     * 获取小区表主键
     *
     * @return coid - 小区表主键
     */
    public String getCoid() {
        return coid;
    }

    /**
     * 设置小区表主键
     *
     * @param coid 小区表主键
     */
    public void setCoid(String coid) {
        this.coid = coid == null ? null : coid.trim();
    }

    /**
     * 获取楼盘表主键
     *
     * @return boid - 楼盘表主键
     */
    public String getBoid() {
        return boid;
    }

    /**
     * 设置楼盘表主键
     *
     * @param boid 楼盘表主键
     */
    public void setBoid(String boid) {
        this.boid = boid == null ? null : boid.trim();
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
     * @return hlipath
     */
    public String getHlipath() {
        return hlipath;
    }

    /**
     * @param hlipath
     */
    public void setHlipath(String hlipath) {
        this.hlipath = hlipath == null ? null : hlipath.trim();
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
     * 获取1显示
     0不显示
     *
     * @return status - 1显示
    0不显示
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1显示
     0不显示
     *
     * @param status 1显示
    0不显示
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}