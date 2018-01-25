package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_cm_agent_follow")
public class TCmAgentFollow extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String aoid;

    /**
     * 取字典 FOLLOW_TYPE
     包括：小区，房源，客户
     */
    private String followtype;

    private String follow;

    private Date createdate;

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
     * 获取取字典 FOLLOW_TYPE
     包括：小区，房源，客户
     *
     * @return followtype - 取字典 FOLLOW_TYPE
    包括：小区，房源，客户
     */
    public String getFollowtype() {
        return followtype;
    }

    /**
     * 设置取字典 FOLLOW_TYPE
     包括：小区，房源，客户
     *
     * @param followtype 取字典 FOLLOW_TYPE
    包括：小区，房源，客户
     */
    public void setFollowtype(String followtype) {
        this.followtype = followtype == null ? null : followtype.trim();
    }

    /**
     * @return follow
     */
    public String getFollow() {
        return follow;
    }

    /**
     * @param follow
     */
    public void setFollow(String follow) {
        this.follow = follow == null ? null : follow.trim();
    }

    /**
     * @return createdate
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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