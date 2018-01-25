package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import javax.persistence.*;

@Table(name = "t_cm_agent_recom")
public class TCmAgentRecom extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String aoid;

    private String hoid;

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