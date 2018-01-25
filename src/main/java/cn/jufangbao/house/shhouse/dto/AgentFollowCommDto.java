package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TResComm;

import java.util.Date;

/**
 * AgentFollowCommDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:36:05.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AgentFollowCommDto extends TResComm {

    private Date followdate;

    private String clabels;

    public Date getFollowdate() {
        return followdate;
    }

    public void setFollowdate(Date followdate) {
        this.followdate = followdate;
    }

    public String getClabels() {
        return clabels;
    }

    public void setClabels(String clabels) {
        this.clabels = clabels;
    }
}
