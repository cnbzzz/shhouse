package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_cm_agent_message")
public class TCmAgentMessage extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    @Column(name = "fromUserId")
    private String fromuserid;

    /**
     * 取字典 MESSAGE_USER_TYPE
     */
    @Column(name = "fromUserType")
    private String fromusertype;

    @Column(name = "toUserId")
    private String touserid;

    /**
     * 取字典 MESSAGE_USER_TYPE
     */
    @Column(name = "toUserType")
    private String tousertype;

    /**
     * 消息内容
     */
    private String content;

    @Column(name = "createTime")
    private Date createtime;

    /**
     * 预留，取字典组 MSG_TYPE
     */
    @Column(name = "msgType")
    private String msgtype;

    /**
     * 0未读
     1已读
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
     * @return fromUserId
     */
    public String getFromuserid() {
        return fromuserid;
    }

    /**
     * @param fromuserid
     */
    public void setFromuserid(String fromuserid) {
        this.fromuserid = fromuserid == null ? null : fromuserid.trim();
    }

    /**
     * 获取取字典 MESSAGE_USER_TYPE
     *
     * @return fromUserType - 取字典 MESSAGE_USER_TYPE
     */
    public String getFromusertype() {
        return fromusertype;
    }

    /**
     * 设置取字典 MESSAGE_USER_TYPE
     *
     * @param fromusertype 取字典 MESSAGE_USER_TYPE
     */
    public void setFromusertype(String fromusertype) {
        this.fromusertype = fromusertype == null ? null : fromusertype.trim();
    }

    /**
     * @return toUserId
     */
    public String getTouserid() {
        return touserid;
    }

    /**
     * @param touserid
     */
    public void setTouserid(String touserid) {
        this.touserid = touserid == null ? null : touserid.trim();
    }

    /**
     * 获取取字典 MESSAGE_USER_TYPE
     *
     * @return toUserType - 取字典 MESSAGE_USER_TYPE
     */
    public String getTousertype() {
        return tousertype;
    }

    /**
     * 设置取字典 MESSAGE_USER_TYPE
     *
     * @param tousertype 取字典 MESSAGE_USER_TYPE
     */
    public void setTousertype(String tousertype) {
        this.tousertype = tousertype == null ? null : tousertype.trim();
    }

    /**
     * 获取消息内容
     *
     * @return content - 消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置消息内容
     *
     * @param content 消息内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取预留，取字典组 MSG_TYPE
     *
     * @return msgType - 预留，取字典组 MSG_TYPE
     */
    public String getMsgtype() {
        return msgtype;
    }

    /**
     * 设置预留，取字典组 MSG_TYPE
     *
     * @param msgtype 预留，取字典组 MSG_TYPE
     */
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype == null ? null : msgtype.trim();
    }

    /**
     * 获取0未读
     1已读
     *
     * @return status - 0未读
    1已读
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0未读
     1已读
     *
     * @param status 0未读
    1已读
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}