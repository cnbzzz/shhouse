package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_res_comm_sale")
public class TResCommSale extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private Integer salecount;

    private Integer rentcount;

    private Integer saledcount;

    private Integer rentedcount;

    /**
     * 单位分
     */
    private Integer saledprice;

    /**
     * 单位分
     */
    private Integer rentedprice;

    /**
     * 用户表主键
     */
    private Long cuoid;

    private Date cdate;

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
     * @return salecount
     */
    public Integer getSalecount() {
        return salecount;
    }

    /**
     * @param salecount
     */
    public void setSalecount(Integer salecount) {
        this.salecount = salecount;
    }

    /**
     * @return rentcount
     */
    public Integer getRentcount() {
        return rentcount;
    }

    /**
     * @param rentcount
     */
    public void setRentcount(Integer rentcount) {
        this.rentcount = rentcount;
    }

    /**
     * @return saledcount
     */
    public Integer getSaledcount() {
        return saledcount;
    }

    /**
     * @param saledcount
     */
    public void setSaledcount(Integer saledcount) {
        this.saledcount = saledcount;
    }

    /**
     * @return rentedcount
     */
    public Integer getRentedcount() {
        return rentedcount;
    }

    /**
     * @param rentedcount
     */
    public void setRentedcount(Integer rentedcount) {
        this.rentedcount = rentedcount;
    }

    /**
     * 获取单位分
     *
     * @return saledprice - 单位分
     */
    public Integer getSaledprice() {
        return saledprice;
    }

    /**
     * 设置单位分
     *
     * @param saledprice 单位分
     */
    public void setSaledprice(Integer saledprice) {
        this.saledprice = saledprice;
    }

    /**
     * 获取单位分
     *
     * @return rentedprice - 单位分
     */
    public Integer getRentedprice() {
        return rentedprice;
    }

    /**
     * 设置单位分
     *
     * @param rentedprice 单位分
     */
    public void setRentedprice(Integer rentedprice) {
        this.rentedprice = rentedprice;
    }

    /**
     * 获取用户表主键
     *
     * @return cuoid - 用户表主键
     */
    public Long getCuoid() {
        return cuoid;
    }

    /**
     * 设置用户表主键
     *
     * @param cuoid 用户表主键
     */
    public void setCuoid(Long cuoid) {
        this.cuoid = cuoid;
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