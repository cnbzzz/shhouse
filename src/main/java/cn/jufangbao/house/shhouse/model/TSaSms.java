package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sa_sms")
public class TSaSms extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String sendplatform;

    private String recnum;

    private String content;

    private String authcode;

    private Integer sendcount;

    private Date sendtime;

    private Date invalidtime;

    private Date chktime;

    /**
     * 0 失败
     1 成功
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
     * @return sendplatform
     */
    public String getSendplatform() {
        return sendplatform;
    }

    /**
     * @param sendplatform
     */
    public void setSendplatform(String sendplatform) {
        this.sendplatform = sendplatform == null ? null : sendplatform.trim();
    }

    /**
     * @return recnum
     */
    public String getRecnum() {
        return recnum;
    }

    /**
     * @param recnum
     */
    public void setRecnum(String recnum) {
        this.recnum = recnum == null ? null : recnum.trim();
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return authcode
     */
    public String getAuthcode() {
        return authcode;
    }

    /**
     * @param authcode
     */
    public void setAuthcode(String authcode) {
        this.authcode = authcode == null ? null : authcode.trim();
    }

    /**
     * @return sendcount
     */
    public Integer getSendcount() {
        return sendcount;
    }

    /**
     * @param sendcount
     */
    public void setSendcount(Integer sendcount) {
        this.sendcount = sendcount;
    }

    /**
     * @return sendtime
     */
    public Date getSendtime() {
        return sendtime;
    }

    /**
     * @param sendtime
     */
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    /**
     * @return invalidtime
     */
    public Date getInvalidtime() {
        return invalidtime;
    }

    /**
     * @param invalidtime
     */
    public void setInvalidtime(Date invalidtime) {
        this.invalidtime = invalidtime;
    }

    /**
     * @return chktime
     */
    public Date getChktime() {
        return chktime;
    }

    /**
     * @param chktime
     */
    public void setChktime(Date chktime) {
        this.chktime = chktime;
    }

    /**
     * 获取0 失败
     1 成功
     *
     * @return status - 0 失败
    1 成功
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0 失败
     1 成功
     *
     * @param status 0 失败
    1 成功
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}