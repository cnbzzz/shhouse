package cn.jufangbao.house.shhouse.base;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.UUID;

/**
 * BaseReq.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:34:50.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class BaseReq implements Serializable {

    private int pageSize = 5;

    private int pageNum = 1;

    private String orderBy;

    private Integer desc;

    private String reqId = UUID.randomUUID().toString();

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public Integer getDesc() {
        return desc;
    }

    public void setDesc(Integer desc) {
        this.desc = desc;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
