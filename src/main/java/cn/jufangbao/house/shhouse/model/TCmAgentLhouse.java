package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;

public class TCmAgentLhouse extends BaseDto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_cm_agent_lhouse.oid
     *
     * @mbg.generated
     */
    private String oid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_cm_agent_lhouse.aoid
     *
     * @mbg.generated
     */
    private String aoid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_cm_agent_lhouse.hoid
     *
     * @mbg.generated
     */
    private String hoid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_cm_agent_lhouse.addtime
     *
     * @mbg.generated
     */
    private Date addtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_cm_agent_lhouse.oid
     *
     * @return the value of t_cm_agent_lhouse.oid
     *
     * @mbg.generated
     */
    public String getOid() {
        return oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_cm_agent_lhouse.oid
     *
     * @param oid the value for t_cm_agent_lhouse.oid
     *
     * @mbg.generated
     */
    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_cm_agent_lhouse.aoid
     *
     * @return the value of t_cm_agent_lhouse.aoid
     *
     * @mbg.generated
     */
    public String getAoid() {
        return aoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_cm_agent_lhouse.aoid
     *
     * @param aoid the value for t_cm_agent_lhouse.aoid
     *
     * @mbg.generated
     */
    public void setAoid(String aoid) {
        this.aoid = aoid == null ? null : aoid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_cm_agent_lhouse.hoid
     *
     * @return the value of t_cm_agent_lhouse.hoid
     *
     * @mbg.generated
     */
    public String getHoid() {
        return hoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_cm_agent_lhouse.hoid
     *
     * @param hoid the value for t_cm_agent_lhouse.hoid
     *
     * @mbg.generated
     */
    public void setHoid(String hoid) {
        this.hoid = hoid == null ? null : hoid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_cm_agent_lhouse.addtime
     *
     * @return the value of t_cm_agent_lhouse.addtime
     *
     * @mbg.generated
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_cm_agent_lhouse.addtime
     *
     * @param addtime the value for t_cm_agent_lhouse.addtime
     *
     * @mbg.generated
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}