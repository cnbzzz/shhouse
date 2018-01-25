package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TCmAgent;

/**
 * AgentRegisterDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:36:08.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AgentRegisterDto extends TCmAgent {

    private String bankid;

    private String bankcardnum;

    private String accountperson;

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public String getBankcardnum() {
        return bankcardnum;
    }

    public void setBankcardnum(String bankcardnum) {
        this.bankcardnum = bankcardnum;
    }

    public String getAccountperson() {
        return accountperson;
    }

    public void setAccountperson(String accountperson) {
        this.accountperson = accountperson;
    }
}
