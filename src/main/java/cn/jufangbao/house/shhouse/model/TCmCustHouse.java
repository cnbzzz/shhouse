package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_cm_cust_house")
public class TCmCustHouse extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 客户表主键
     */
    private String seller;

    /**
     * 字典组 TRANS_TYPE
            1 待售
            2 待租
            3 已售
            4 已租
     */
    private String transtype;

    /**
     * 客户表主键
     */
    private String buyer;

    private String hoid;

    private Date cdate;

    private Date transtime;

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
     * 获取客户表主键
     *
     * @return seller - 客户表主键
     */
    public String getSeller() {
        return seller;
    }

    /**
     * 设置客户表主键
     *
     * @param seller 客户表主键
     */
    public void setSeller(String seller) {
        this.seller = seller == null ? null : seller.trim();
    }

    /**
     * 获取字典组 TRANS_TYPE
            1 待售
            2 待租
            3 已售
            4 已租
     *
     * @return transtype - 字典组 TRANS_TYPE
            1 待售
            2 待租
            3 已售
            4 已租
     */
    public String getTranstype() {
        return transtype;
    }

    /**
     * 设置字典组 TRANS_TYPE
            1 待售
            2 待租
            3 已售
            4 已租
     *
     * @param transtype 字典组 TRANS_TYPE
            1 待售
            2 待租
            3 已售
            4 已租
     */
    public void setTranstype(String transtype) {
        this.transtype = transtype == null ? null : transtype.trim();
    }

    /**
     * 获取客户表主键
     *
     * @return buyer - 客户表主键
     */
    public String getBuyer() {
        return buyer;
    }

    /**
     * 设置客户表主键
     *
     * @param buyer 客户表主键
     */
    public void setBuyer(String buyer) {
        this.buyer = buyer == null ? null : buyer.trim();
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
     * @return cdate
     */
    public Date getCdate() {
        return cdate;
    }

    /**
     * @param cdate
     */
    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    /**
     * @return transtime
     */
    public Date getTranstime() {
        return transtime;
    }

    /**
     * @param transtime
     */
    public void setTranstime(Date transtime) {
        this.transtime = transtime;
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