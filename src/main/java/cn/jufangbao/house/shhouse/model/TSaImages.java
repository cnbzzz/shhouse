package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sa_images")
public class TSaImages extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String igroupoid;

    private String iname;

    private String smipath;

    private String ipath;

    /**
     * 取字典 IMAGE_TYPE
     */
    private String itype;

    private Integer sort;

    /**
     * 字典组 IMAGE_SOURCE
     */
    private String isource;

    private Date cdate;

    private String cuoid;

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
     * @return igroupoid
     */
    public String getIgroupoid() {
        return igroupoid;
    }

    /**
     * @param igroupoid
     */
    public void setIgroupoid(String igroupoid) {
        this.igroupoid = igroupoid == null ? null : igroupoid.trim();
    }

    /**
     * @return iname
     */
    public String getIname() {
        return iname;
    }

    /**
     * @param iname
     */
    public void setIname(String iname) {
        this.iname = iname == null ? null : iname.trim();
    }

    /**
     * @return smipath
     */
    public String getSmipath() {
        return smipath;
    }

    /**
     * @param smipath
     */
    public void setSmipath(String smipath) {
        this.smipath = smipath == null ? null : smipath.trim();
    }

    /**
     * @return ipath
     */
    public String getIpath() {
        return ipath;
    }

    /**
     * @param ipath
     */
    public void setIpath(String ipath) {
        this.ipath = ipath == null ? null : ipath.trim();
    }

    /**
     * 获取取字典 IMAGE_TYPE
     *
     * @return itype - 取字典 IMAGE_TYPE
     */
    public String getItype() {
        return itype;
    }

    /**
     * 设置取字典 IMAGE_TYPE
     *
     * @param itype 取字典 IMAGE_TYPE
     */
    public void setItype(String itype) {
        this.itype = itype == null ? null : itype.trim();
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
     * 获取字典组 IMAGE_SOURCE
     *
     * @return isource - 字典组 IMAGE_SOURCE
     */
    public String getIsource() {
        return isource;
    }

    /**
     * 设置字典组 IMAGE_SOURCE
     *
     * @param isource 字典组 IMAGE_SOURCE
     */
    public void setIsource(String isource) {
        this.isource = isource == null ? null : isource.trim();
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
     * @return cuoid
     */
    public String getCuoid() {
        return cuoid;
    }

    /**
     * @param cuoid
     */
    public void setCuoid(String cuoid) {
        this.cuoid = cuoid == null ? null : cuoid.trim();
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}