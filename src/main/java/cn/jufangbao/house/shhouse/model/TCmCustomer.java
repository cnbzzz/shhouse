package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_cm_customer")
public class TCmCustomer extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private Long phonenum;

    private String passwd;

    private String name;

    private String sex;

    /**
     * 字典组 CUST_CLAZZ
     */
    private String custclazz;

    private Date lastlogindate;

    private Date createdate;

    private String ipath;

    private String wechatid;

    /**
     * 对应经纪人表主键
     */
    private String founder;

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
     * @return phonenum
     */
    public Long getPhonenum() {
        return phonenum;
    }

    /**
     * @param phonenum
     */
    public void setPhonenum(Long phonenum) {
        this.phonenum = phonenum;
    }

    /**
     * @return passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取字典组 CUST_CLAZZ
     *
     * @return custclazz - 字典组 CUST_CLAZZ
     */
    public String getCustclazz() {
        return custclazz;
    }

    /**
     * 设置字典组 CUST_CLAZZ
     *
     * @param custclazz 字典组 CUST_CLAZZ
     */
    public void setCustclazz(String custclazz) {
        this.custclazz = custclazz == null ? null : custclazz.trim();
    }

    /**
     * @return lastlogindate
     */
    public Date getLastlogindate() {
        return lastlogindate;
    }

    /**
     * @param lastlogindate
     */
    public void setLastlogindate(Date lastlogindate) {
        this.lastlogindate = lastlogindate;
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
     * @return ipath
     */
    public String getIpath() {
        return ipath;
    }

    /**
     * @param ipath
     */
    public void setIpath(String ipath) {
        this.ipath = ipath == null ? null : ipath.trim();
    }

    /**
     * @return wechatid
     */
    public String getWechatid() {
        return wechatid;
    }

    /**
     * @param wechatid
     */
    public void setWechatid(String wechatid) {
        this.wechatid = wechatid == null ? null : wechatid.trim();
    }

    /**
     * 获取对应经纪人表主键
     *
     * @return founder - 对应经纪人表主键
     */
    public String getFounder() {
        return founder;
    }

    /**
     * 设置对应经纪人表主键
     *
     * @param founder 对应经纪人表主键
     */
    public void setFounder(String founder) {
        this.founder = founder;
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