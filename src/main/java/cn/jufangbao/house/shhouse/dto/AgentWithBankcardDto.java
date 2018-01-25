package cn.jufangbao.house.shhouse.dto;

import cn.jufangbao.house.shhouse.model.TCmAgent;

import java.util.List;

/**
 * cn.jufangbao.house.shhouse.dto
 * Created by bzzz on 2017-05-11 18:04.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AgentWithBankcardDto extends TCmAgent {

    private String serviceareaName;

    List<AgentBankcardDetailDto> bankcardList;

    public String getServiceareaName() {
        return serviceareaName;
    }

    public void setServiceareaName(String serviceareaName) {
        this.serviceareaName = serviceareaName;
    }

    public List<AgentBankcardDetailDto> getBankcardList() {
        return bankcardList;
    }

    public void setBankcardList(List<AgentBankcardDetailDto> bankcardList) {
        this.bankcardList = bankcardList;
    }
}
