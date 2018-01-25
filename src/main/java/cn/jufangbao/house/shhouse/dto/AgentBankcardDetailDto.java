package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TCmAgentBankcard;

/**
 * AgentBankcardDetailDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:35:34.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AgentBankcardDetailDto extends TCmAgentBankcard {

    private String bankname;

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
}
