package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import javax.persistence.*;

@Table(name = "t_cm_agent_dealcount")
public class TCmAgentDealcount extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String aoid;

    private Long accuprice;

    private Long surprice;

    /**
     * 0 售房
            1 租房
     */
    private Long rent;

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
     * @return aoid
     */
    public String getAoid() {
        return aoid;
    }

    /**
     * @param aoid
     */
    public void setAoid(String aoid) {
        this.aoid = aoid == null ? null : aoid.trim();
    }

    /**
     * @return accuprice
     */
    public Long getAccuprice() {
        return accuprice;
    }

    /**
     * @param accuprice
     */
    public void setAccuprice(Long accuprice) {
        this.accuprice = accuprice;
    }

    /**
     * @return surprice
     */
    public Long getSurprice() {
        return surprice;
    }

    /**
     * @param surprice
     */
    public void setSurprice(Long surprice) {
        this.surprice = surprice;
    }

    /**
     * 获取0 售房
            1 租房
     *
     * @return rent - 0 售房
            1 租房
     */
    public Long getRent() {
        return rent;
    }

    /**
     * 设置0 售房
            1 租房
     *
     * @param rent 0 售房
            1 租房
     */
    public void setRent(Long rent) {
        this.rent = rent;
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