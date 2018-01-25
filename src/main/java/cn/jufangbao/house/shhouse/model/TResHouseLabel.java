package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import javax.persistence.*;

@Table(name = "t_res_house_label")
public class TResHouseLabel extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 小区主键
     */
    private String hoid;

    /**
     * 取字典 HOUSE_LABEL
     */
    private String hlabel;

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
     * 获取取字典 HOUSE_LABEL
     *
     * @return hlabel - 取字典 HOUSE_LABEL
     */
    public String getHlabel() {
        return hlabel;
    }

    /**
     * 设置取字典 HOUSE_LABEL
     *
     * @param hlabel 取字典 HOUSE_LABEL
     */
    public void setHlabel(String hlabel) {
        this.hlabel = hlabel == null ? null : hlabel.trim();
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