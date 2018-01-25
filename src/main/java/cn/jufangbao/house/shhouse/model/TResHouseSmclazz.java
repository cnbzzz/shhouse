package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import javax.persistence.*;

@Table(name = "t_res_house_smclazz")
public class TResHouseSmclazz extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 取字典 HOUSE_QT_TYPE
     */
    private String qttype;

    private String sclazzname;

    private String clzoid;

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
     * @return sclazzname
     */
    public String getSclazzname() {
        return sclazzname;
    }

    /**
     * @param sclazzname
     */
    public void setSclazzname(String sclazzname) {
        this.sclazzname = sclazzname == null ? null : sclazzname.trim();
    }

    /**
     * @return clzoid
     */
    public String getClzoid() {
        return clzoid;
    }

    /**
     * @param clzoid
     */
    public void setClzoid(String clzoid) {
        this.clzoid = clzoid == null ? null : clzoid.trim();
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