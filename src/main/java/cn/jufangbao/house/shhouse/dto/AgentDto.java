package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TCmAgent;

import java.util.List;

/**
 * AgentDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:36:01.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AgentDto extends TCmAgent {

    private Long browsecount;

    private Long dealcount;

    private List<HouseDto> recomHouseList;

    private List<HouseDto> localHouseList;

    public Long getBrowsecount() {
        return browsecount;
    }

    public void setBrowsecount(Long browsecount) {
        this.browsecount = browsecount;
    }

    public Long getDealcount() {
        return dealcount;
    }

    public void setDealcount(Long dealcount) {
        this.dealcount = dealcount;
    }

    public List<HouseDto> getRecomHouseList() {
        return recomHouseList;
    }

    public void setRecomHouseList(List<HouseDto> recomHouseList) {
        this.recomHouseList = recomHouseList;
    }

    public List<HouseDto> getLocalHouseList() {
        return localHouseList;
    }

    public void setLocalHouseList(List<HouseDto> localHouseList) {
        this.localHouseList = localHouseList;
    }
}
