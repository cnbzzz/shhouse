package cn.jufangbao.house.shhouse.mapper;

import cn.jufangbao.house.shhouse.dto.AgentBankcardDetailDto;
import cn.jufangbao.house.shhouse.model.TCmAgentBankcard;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TCmAgentBankcardMapper extends Mapper<TCmAgentBankcard> {

    List<AgentBankcardDetailDto> queryAgentBankcard(TCmAgentBankcard param);

}