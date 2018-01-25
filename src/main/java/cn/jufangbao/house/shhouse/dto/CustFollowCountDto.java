package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.base.BaseDto;

/**
 * CustFollowCountDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:36:31.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class CustFollowCountDto extends BaseDto {

    private Long salecount;

    private Long rentcount;

    private Long commcount;

    private Long totalcount;

    public Long getSalecount() {
        return salecount;
    }

    public void setSalecount(Long salecount) {
        this.salecount = salecount;
    }

    public Long getRentcount() {
        return rentcount;
    }

    public void setRentcount(Long rentcount) {
        this.rentcount = rentcount;
    }

    public Long getCommcount() {
        return commcount;
    }

    public void setCommcount(Long commcount) {
        this.commcount = commcount;
    }

    public Long getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Long totalcount) {
        this.totalcount = totalcount;
    }
}
