package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.base.BaseDto;

/**
 * CustSellerCountDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:36:51.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class CustSellerCountDto extends BaseDto {

    private Long salecount;

    private Long rentcount;

    private Long sellcount;

    private Long rentedcount;

    private Long total;

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

    public Long getSellcount() {
        return sellcount;
    }

    public void setSellcount(Long sellcount) {
        this.sellcount = sellcount;
    }

    public Long getRentedcount() {
        return rentedcount;
    }

    public void setRentedcount(Long rentedcount) {
        this.rentedcount = rentedcount;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
