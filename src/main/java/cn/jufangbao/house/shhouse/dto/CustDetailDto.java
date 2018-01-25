package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TCmCustomer;

import java.util.List;

/**
 * CustDetailDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:36:19.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class CustDetailDto extends TCmCustomer {

    private String custlabels;

    private List<String> lableIdList;

    public List<String> getLableIdList() {
        return lableIdList;
    }

    public void setLableIdList(List<String> lableIdList) {
        this.lableIdList = lableIdList;
    }

    public String getCustlabels() {
        return custlabels;
    }

    public void setCustlabels(String custlabels) {
        this.custlabels = custlabels;
    }
}
