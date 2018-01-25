package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TCmCustomer;

/**
 * AgentCustDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:35:53.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AgentCustDto extends TCmCustomer {

    private String custid;

    private String ctypename;

    private String clabels;

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCtypename() {
        return ctypename;
    }

    public void setCtypename(String ctypename) {
        this.ctypename = ctypename;
    }

    public String getClabels() {
        return clabels;
    }

    public void setClabels(String clabels) {
        this.clabels = clabels;
    }
}
