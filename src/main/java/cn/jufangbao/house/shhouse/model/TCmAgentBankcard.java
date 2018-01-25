package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_cm_agent_bankcard")
public class TCmAgentBankcard extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String aoid;

    /**
     * 取字典 BANK
     */
    private String bankid;

    private String bankcardnum;

    private String accountperson;

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
     * 获取取字典 BANK
     *
     * @return bankid - 取字典 BANK
     */
    public String getBankid() {
        return bankid;
    }

    /**
     * 设置取字典 BANK
     *
     * @param bankid 取字典 BANK
     */
    public void setBankid(String bankid) {
        this.bankid = bankid == null ? null : bankid.trim();
    }

    /**
     * @return bankcardnum
     */
    public String getBankcardnum() {
        return bankcardnum;
    }

    /**
     * @param bankcardnum
     */
    public void setBankcardnum(String bankcardnum) {
        this.bankcardnum = bankcardnum == null ? null : bankcardnum.trim();
    }

    /**
     * @return accountperson
     */
    public String getAccountperson() {
        return accountperson;
    }

    /**
     * @param accountperson
     */
    public void setAccountperson(String accountperson) {
        this.accountperson = accountperson == null ? null : accountperson.trim();
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