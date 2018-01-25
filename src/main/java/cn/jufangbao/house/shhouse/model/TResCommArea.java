package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import javax.persistence.*;

@Table(name = "t_res_comm_area")
public class TResCommArea extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 小区主键
     */
    private String coid;

    /**
     * 取字典 AREA
     */
    private String aoid;

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
     * 获取取字典 AREA
     *
     * @return aoid - 取字典 AREA
     */
    public String getAoid() {
        return aoid;
    }

    /**
     * 设置取字典 AREA
     *
     * @param aoid 取字典 AREA
     */
    public void setAoid(String aoid) {
        this.aoid = aoid == null ? null : aoid.trim();
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