package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.base.BaseDto;

import java.util.List;

/**
 * AgentBrowseDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:35:49.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AgentBrowseDto extends BaseDto {

    private Long alltimes;

    private Long weektimes;

    private List<CustDto> houseCustList;

    public Long getAlltimes() {
        return alltimes;
    }

    public void setAlltimes(Long alltimes) {
        this.alltimes = alltimes;
    }

    public Long getWeektimes() {
        return weektimes;
    }

    public void setWeektimes(Long weektimes) {
        this.weektimes = weektimes;
    }

    public List<CustDto> getHouseCustList() {
        return houseCustList;
    }

    public void setHouseCustList(List<CustDto> houseCustList) {
        this.houseCustList = houseCustList;
    }
}
