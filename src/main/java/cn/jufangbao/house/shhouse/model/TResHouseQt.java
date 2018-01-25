package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_res_house_qt")
public class TResHouseQt extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 小区主键
     */
    private String hoid;

    /**
     * 取字典 HOUSE_QT_TYPE
     */
    private String qttype;

    private String clazoid;

    private String smclazoid;

    /**
     * 取字典 HOUSE_QT_RESULT
     */
    private String result;

    private String rdesc;

    /**
     * 图片表igroupoid字段
     */
    private String igroupoid;

    private Long icount;

    /**
     * 房源质检结果主键
     */
    private String qtroid;

    /**
     * 用户表主键
     */
    private String qtuoid;

    /**
     * 用户表主键
     */
    private String cuoid;

    private Date cdate;

    private Integer sort;

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
     * 获取小区主键
     *
     * @return hoid - 小区主键
     */
    public String getHoid() {
        return hoid;
    }

    /**
     * 设置小区主键
     *
     * @param hoid 小区主键
     */
    public void setHoid(String hoid) {
        this.hoid = hoid == null ? null : hoid.trim();
    }

    /**
     * 获取取字典 HOUSE_QT_TYPE
     *
     * @return qttype - 取字典 HOUSE_QT_TYPE
     */
    public String getQttype() {
        return qttype;
    }

    /**
     * 设置取字典 HOUSE_QT_TYPE
     *
     * @param qttype 取字典 HOUSE_QT_TYPE
     */
    public void setQttype(String qttype) {
        this.qttype = qttype == null ? null : qttype.trim();
    }

    /**
     * @return clazoid
     */
    public String getClazoid() {
        return clazoid;
    }

    /**
     * @param clazoid
     */
    public void setClazoid(String clazoid) {
        this.clazoid = clazoid == null ? null : clazoid.trim();
    }

    /**
     * @return smclazoid
     */
    public String getSmclazoid() {
        return smclazoid;
    }

    /**
     * @param smclazoid
     */
    public void setSmclazoid(String smclazoid) {
        this.smclazoid = smclazoid == null ? null : smclazoid.trim();
    }

    /**
     * 获取取字典 HOUSE_QT_RESULT
     *
     * @return result - 取字典 HOUSE_QT_RESULT
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置取字典 HOUSE_QT_RESULT
     *
     * @param result 取字典 HOUSE_QT_RESULT
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * @return rdesc
     */
    public String getRdesc() {
        return rdesc;
    }

    /**
     * @param rdesc
     */
    public void setRdesc(String rdesc) {
        this.rdesc = rdesc == null ? null : rdesc.trim();
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
     * 获取房源质检结果主键
     *
     * @return qtroid - 房源质检结果主键
     */
    public String getQtroid() {
        return qtroid;
    }

    /**
     * 设置房源质检结果主键
     *
     * @param qtroid 房源质检结果主键
     */
    public void setQtroid(String qtroid) {
        this.qtroid = qtroid == null ? null : qtroid.trim();
    }

    /**
     * 获取用户表主键
     *
     * @return qtuoid - 用户表主键
     */
    public String getQtuoid() {
        return qtuoid;
    }

    /**
     * 设置用户表主键
     *
     * @param qtuoid 用户表主键
     */
    public void setQtuoid(String qtuoid) {
        this.qtuoid = qtuoid == null ? null : qtuoid.trim();
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
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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