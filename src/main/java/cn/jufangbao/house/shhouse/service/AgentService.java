package cn.jufangbao.house.shhouse.service;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.dto.*;
import cn.jufangbao.house.shhouse.model.*;

import java.util.List;

/**
 * AgentService.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:41:27.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public interface AgentService {

    BaseResp<String> agentSignIn(Long phoneNum, String passwd);

    BaseResp<AgentDto> oneAgent(String oid);

    /**
     * @param oid
     * @param custType 1买房 2卖房 3租房 4承租
     * @return
     */
    BaseResp<List<AgentCustDto>> listAgentCust(String oid, String custType);

    /**
     *
     * @param aoid
     * @param rent 0买房 1租房
     * @return
     */
    BaseResp<AgentDealDto> listAgentDeal(String aoid, Long rent);

    /**
     *
     * @param aoid
     * @param rent 0买房 1租房
     * @return
     */
    BaseResp<List<HouseDto>> listAgentHouse(String aoid, Long rent);

    BaseResp<AgentBrowseDto> listAgentBrowse(String aoid);

    /**
     *
     * @param aoid
     * @param rent 0买房 1租房
     * @return
     */
    BaseResp<List<AgentBookingDto>> listAgentBooking(String aoid, Long rent);

    /**
     *
     * @param aoid
     * @param followtype 1买房 2租房
     * @return
     */
    BaseResp<List<HouseDto>> listAgentFollowHouse(String aoid, String followtype);

    BaseResp<List<AgentFollowCommDto>> listAgentFollowComm(String aoid);

    BaseResp editAgent(AgentRegisterDto param);

    BaseResp addAgentFollow(String aoid, TCmAgentFollow param);

    BaseResp delAgentFollow(String aoid, TCmAgentFollow param);

    BaseResp editHouseWaitingByAgent(String aoid, TResHouseWaiting houseWaiting);

    BaseResp agentForgetPasswd(Long phoneNum);

    BaseResp editAgentPasswd(Long phoneNum, String newPasswd);

    BaseResp<AgentWithBankcardDto> queryAgentByPhonenum(Long phonenum);

    BaseResp<AgentWithBankcardDto> queryAgentByOid(String oid);

    BaseResp<List<AgentBankcardDetailDto>> queryAgentBankcard(TCmAgentBankcard bankcard);

    BaseResp editAgentBankcard(TCmAgentBankcard bankcard);

    BaseResp delAgentBankcard(String oid);

    BaseResp chkAgentBankcard(AgentBankcardDto bankcard);

    BaseResp delAgentLocalHouse(String aoid,String houseid);

    BaseResp addAgentLocalHouse(String aoid,String houseid);


}
