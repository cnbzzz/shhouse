package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sa_wechat")
public class TSaWechat extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String appid;

    private String secret;

    private String authtoken;

    private String accesstoken;

    private Date stime;

    private Date etime;

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
     * @return appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    /**
     * @return secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @param secret
     */
    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    /**
     * @return authtoken
     */
    public String getAuthtoken() {
        return authtoken;
    }

    /**
     * @param authtoken
     */
    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken == null ? null : authtoken.trim();
    }

    /**
     * @return accesstoken
     */
    public String getAccesstoken() {
        return accesstoken;
    }

    /**
     * @param accesstoken
     */
    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken == null ? null : accesstoken.trim();
    }

    /**
     * @return stime
     */
    public Date getStime() {
        return stime;
    }

    /**
     * @param stime
     */
    public void setStime(Date stime) {
        this.stime = stime;
    }

    /**
     * @return etime
     */
    public Date getEtime() {
        return etime;
    }

    /**
     * @param etime
     */
    public void setEtime(Date etime) {
        this.etime = etime;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}