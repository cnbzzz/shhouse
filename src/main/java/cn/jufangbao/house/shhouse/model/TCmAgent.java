package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_cm_agent")
public class TCmAgent extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String worknum;

    private Long phonenum;

    private String passwd;

    private String name;

    private String sex;

    private String idcardnum;

    private Integer workyear;

    private Date lastlogindate;

    private Date createdate;

    private String igroupid;

    private Long icount;

    private String shopname;

    private String ipath;

    private String bgipath;

    /**
     * 取字典 COUNTY
     */
    private String servicearea;

    private String company;

    private String addr;

    private String qrcodeticket;

    private String qrcodepath;

    /**
     * 介绍人
     */
    private String introducer;

    /**
     * 介绍人电话
     */
    private Long introducerphonenum;

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
     * @return worknum
     */
    public String getWorknum() {
        return worknum;
    }

    /**
     * @param worknum
     */
    public void setWorknum(String worknum) {
        this.worknum = worknum == null ? null : worknum.trim();
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
     * @return idcardnum
     */
    public String getIdcardnum() {
        return idcardnum;
    }

    /**
     * @param idcardnum
     */
    public void setIdcardnum(String idcardnum) {
        this.idcardnum = idcardnum == null ? null : idcardnum.trim();
    }

    /**
     * @return workyear
     */
    public Integer getWorkyear() {
        return workyear;
    }

    /**
     * @param workyear
     */
    public void setWorkyear(Integer workyear) {
        this.workyear = workyear;
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
     * @return igroupid
     */
    public String getIgroupid() {
        return igroupid;
    }

    /**
     * @param igroupid
     */
    public void setIgroupid(String igroupid) {
        this.igroupid = igroupid == null ? null : igroupid.trim();
    }

    /**
     * @return icount
     */
    public Long getIcount() {
        return icount;
    }

    /**
     * @param icount
     */
    public void setIcount(Long icount) {
        this.icount = icount;
    }

    /**
     * @return shopname
     */
    public String getShopname() {
        return shopname;
    }

    /**
     * @param shopname
     */
    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
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
     * @return bgipath
     */
    public String getBgipath() {
        return bgipath;
    }

    /**
     * @param bgipath
     */
    public void setBgipath(String bgipath) {
        this.bgipath = bgipath == null ? null : bgipath.trim();
    }

    /**
     * 获取取字典 COUNTY
     *
     * @return servicearea - 取字典 COUNTY
     */
    public String getServicearea() {
        return servicearea;
    }

    /**
     * 设置取字典 COUNTY
     *
     * @param servicearea 取字典 COUNTY
     */
    public void setServicearea(String servicearea) {
        this.servicearea = servicearea == null ? null : servicearea.trim();
    }

    /**
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * @return addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * @return qrcodeticket
     */
    public String getQrcodeticket() {
        return qrcodeticket;
    }

    /**
     * @param qrcodeticket
     */
    public void setQrcodeticket(String qrcodeticket) {
        this.qrcodeticket = qrcodeticket == null ? null : qrcodeticket.trim();
    }

    /**
     * @return qrcodepath
     */
    public String getQrcodepath() {
        return qrcodepath;
    }

    /**
     * @param qrcodepath
     */
    public void setQrcodepath(String qrcodepath) {
        this.qrcodepath = qrcodepath == null ? null : qrcodepath.trim();
    }

    /**
     * 获取介绍人
     *
     * @return introducer - 介绍人
     */
    public String getIntroducer() {
        return introducer;
    }

    /**
     * 设置介绍人
     *
     * @param introducer 介绍人
     */
    public void setIntroducer(String introducer) {
        this.introducer = introducer == null ? null : introducer.trim();
    }

    /**
     * 获取介绍人电话
     *
     * @return introducerphonenum - 介绍人电话
     */
    public Long getIntroducerphonenum() {
        return introducerphonenum;
    }

    /**
     * 设置介绍人电话
     *
     * @param introducerphonenum 介绍人电话
     */
    public void setIntroducerphonenum(Long introducerphonenum) {
        this.introducerphonenum = introducerphonenum;
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