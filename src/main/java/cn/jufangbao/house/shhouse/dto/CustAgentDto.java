package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TCmAgent;

import java.util.Date;

/**
 * CustAgentDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:36:12.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class CustAgentDto extends TCmAgent {

    private Date scandate;

    public Date getScandate() {
        return scandate;
    }

    public void setScandate(Date scandate) {
        this.scandate = scandate;
    }
}
