package cn.jufangbao.house.shhouse.mapper;

import cn.jufangbao.house.shhouse.dto.*;
import cn.jufangbao.house.shhouse.model.TCmAgent;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TCmAgentMapper extends Mapper<TCmAgent> {

    AgentDto oneAgent(String oid);

    List<AgentCustDto> listAgentCust(@Param(value="aoid") String aoid, @Param(value="custType") String custType);

    List<CustDto> listAgentBrowse(String aoid);

    List<AgentBookingDto> listAgentBooking(@Param(value="aoid") String aoid, @Param(value="rent") Long rent);

    List<HouseDto> listAgentFollowHouse(@Param(value="aoid") String aoid, @Param(value="followtype") String followtype);

    List<AgentFollowCommDto> listAgentFollowComm(@Param(value="aoid") String aoid);

    AgentWithBankcardDto queryAgentByOid(@Param(value="oid") String oid);
}