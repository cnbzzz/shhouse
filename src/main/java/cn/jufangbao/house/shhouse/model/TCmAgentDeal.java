package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_cm_agent_deal")
public class TCmAgentDeal extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String aoid;

    private String soid;

    private String boid;

    private String hoid;

    /**
     * 0 售房
     1 租房
     */
    private Long rent;

    /**
     * 单位：分
     */
    private Long dealprice;

    private Date browsetime;

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
     * @return soid
     */
    public String getSoid() {
        return soid;
    }

    /**
     * @param soid
     */
    public void setSoid(String soid) {
        this.soid = soid == null ? null : soid.trim();
    }

    /**
     * @return boid
     */
    public String getBoid() {
        return boid;
    }

    /**
     * @param boid
     */
    public void setBoid(String boid) {
        this.boid = boid == null ? null : boid.trim();
    }

    /**
     * @return hoid
     */
    public String getHoid() {
        return hoid;
    }

    /**
     * @param hoid
     */
    public void setHoid(String hoid) {
        this.hoid = hoid == null ? null : hoid.trim();
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
     * 获取单位：分
     *
     * @return dealprice - 单位：分
     */
    public Long getDealprice() {
        return dealprice;
    }

    /**
     * 设置单位：分
     *
     * @param dealprice 单位：分
     */
    public void setDealprice(Long dealprice) {
        this.dealprice = dealprice;
    }

    /**
     * @return browsetime
     */
    public Date getBrowsetime() {
        return browsetime;
    }

    /**
     * @param browsetime
     */
    public void setBrowsetime(Date browsetime) {
        this.browsetime = browsetime;
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