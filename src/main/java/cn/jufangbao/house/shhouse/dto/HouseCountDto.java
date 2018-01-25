package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.base.BaseDto;

/**
 * HouseCountDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:37:13.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class HouseCountDto extends BaseDto {

    private Long salecount;

    private Long sellcount;

    private Long saletotal;

    private Long rentcount;

    private Long rentedcount;

    private Long renttotal;

    public Long getSalecount() {
        return salecount;
    }

    public void setSalecount(Long salecount) {
        this.salecount = salecount;
    }

    public Long getSellcount() {
        return sellcount;
    }

    public void setSellcount(Long sellcount) {
        this.sellcount = sellcount;
    }

    public Long getSaletotal() {
        return saletotal;
    }

    public void setSaletotal(Long saletotal) {
        this.saletotal = saletotal;
    }

    public Long getRentcount() {
        return rentcount;
    }

    public void setRentcount(Long rentcount) {
        this.rentcount = rentcount;
    }

    public Long getRentedcount() {
        return rentedcount;
    }

    public void setRentedcount(Long rentedcount) {
        this.rentedcount = rentedcount;
    }

    public Long getRenttotal() {
        return renttotal;
    }

    public void setRenttotal(Long renttotal) {
        this.renttotal = renttotal;
    }
}
