package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_res_comm_label")
public class TResCommLabel extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 小区主键
     */
    private String coid;

    /**
     * 取字典 COMM_LABEL
     */
    private String clabel;

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
     * 获取小区主键
     *
     * @return coid - 小区主键
     */
    public String getCoid() {
        return coid;
    }

    /**
     * 设置小区主键
     *
     * @param coid 小区主键
     */
    public void setCoid(String coid) {
        this.coid = coid == null ? null : coid.trim();
    }

    /**
     * 获取取字典 COMM_LABEL
     *
     * @return clabel - 取字典 COMM_LABEL
     */
    public String getClabel() {
        return clabel;
    }

    /**
     * 设置取字典 COMM_LABEL
     *
     * @param clabel 取字典 COMM_LABEL
     */
    public void setClabel(String clabel) {
        this.clabel = clabel == null ? null : clabel.trim();
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