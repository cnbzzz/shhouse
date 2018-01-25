package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import javax.persistence.*;

@Table(name = "t_cm_cust_label")
public class TCmCustLabel extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String coid;

    /**
     * 取字典 CUST_LABEL
     */
    private String clabel;

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
     * 获取取字典 CUST_LABEL
     *
     * @return clabel - 取字典 CUST_LABEL
     */
    public String getClabel() {
        return clabel;
    }

    /**
     * 设置取字典 CUST_LABEL
     *
     * @param clabel 取字典 CUST_LABEL
     */
    public void setClabel(String clabel) {
        this.clabel = clabel == null ? null : clabel.trim();
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