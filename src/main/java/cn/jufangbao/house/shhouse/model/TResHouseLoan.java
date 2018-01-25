package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import javax.persistence.*;

@Table(name = "t_res_house_loan")
public class TResHouseLoan extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 单位：分
     */
    private Long downpayment;

    /**
     * 单位：分
     */
    private Long monthpayment;

    /**
     * 单位：分
     */
    private Long loan;

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
     * 获取单位：分
     *
     * @return downpayment - 单位：分
     */
    public Long getDownpayment() {
        return downpayment;
    }

    /**
     * 设置单位：分
     *
     * @param downpayment 单位：分
     */
    public void setDownpayment(Long downpayment) {
        this.downpayment = downpayment;
    }

    /**
     * 获取单位：分
     *
     * @return monthpayment - 单位：分
     */
    public Long getMonthpayment() {
        return monthpayment;
    }

    /**
     * 设置单位：分
     *
     * @param monthpayment 单位：分
     */
    public void setMonthpayment(Long monthpayment) {
        this.monthpayment = monthpayment;
    }

    /**
     * 获取单位：分
     *
     * @return loan - 单位：分
     */
    public Long getLoan() {
        return loan;
    }

    /**
     * 设置单位：分
     *
     * @param loan 单位：分
     */
    public void setLoan(Long loan) {
        this.loan = loan;
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