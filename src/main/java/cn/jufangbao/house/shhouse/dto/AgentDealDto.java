package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.base.BaseDto;

import java.util.List;

/**
 * AgentDealDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:35:57.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AgentDealDto extends BaseDto {

    private Long accuprice = 0l;

    private Long surprice = 0l;

    private List<HouseDto> houseList;

    public List<HouseDto> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<HouseDto> houseList) {
        this.houseList = houseList;
    }

    public Long getAccuprice() {
        return accuprice;
    }

    public void setAccuprice(Long accuprice) {
        this.accuprice = accuprice;
    }

    public Long getSurprice() {
        return surprice;
    }

    public void setSurprice(Long surprice) {
        this.surprice = surprice;
    }
}
