package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import javax.persistence.*;

@Table(name = "t_res_house_clazz")
public class TResHouseClazz extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 取字典 HOUSE_QT_TYPE
     */
    private String qttype;

    private String clazzname;

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
     * @return clazzname
     */
    public String getClazzname() {
        return clazzname;
    }

    /**
     * @param clazzname
     */
    public void setClazzname(String clazzname) {
        this.clazzname = clazzname == null ? null : clazzname.trim();
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