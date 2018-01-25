package cn.jufangbao.house.shhouse.ctrl;

import cn.jufangbao.house.shhouse.base.BaseCtrl;
import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.base.BaseUserResp;
import cn.jufangbao.house.shhouse.dto.*;
import cn.jufangbao.house.shhouse.model.TCmAgent;
import cn.jufangbao.house.shhouse.model.TCmAgentBankcard;
import cn.jufangbao.house.shhouse.model.TCmAgentFollow;
import cn.jufangbao.house.shhouse.model.TResHouseWaiting;
import cn.jufangbao.house.shhouse.service.AgentService;
import cn.jufangbao.house.shhouse.service.CustomerService;
import cn.jufangbao.house.shhouse.utils.TokenUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserCtrl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:35:31.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
@RestController
@RequestMapping("/user")
public class UserCtrl extends BaseCtrl {

    @Resource
    private AgentService agentService;

    @Resource
    private CustomerService customerService;

    @RequestMapping("/agentForgetPasswd")
    public String agentForgetPasswd(Long phoneNum){
        log.debug("param is {}", phoneNum);
        BaseResp resp = agentService.agentForgetPasswd(phoneNum);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/editAgentPasswd")
    public String editAgentPasswd(Long phoneNum, String newPasswd){
        log.debug("param is {}, {}", phoneNum, newPasswd);
        BaseResp resp = agentService.editAgentPasswd(phoneNum, newPasswd);
        log.debug("resp is {}", resp);
        return resp.toString();
    }


    @RequestMapping("/addAgentFollow")
    public String addAgentFollow(@RequestParam("aoid") String aoid, @RequestParam(value = "data") String data){
        log.debug("param is aoid : {}, data is {}", aoid, data);
        TCmAgentFollow param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TCmAgentFollow.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = agentService.addAgentFollow(TokenUtils.decodeToken(aoid), param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/delAgentFollow")
    public String delAgentFollow(@RequestParam("aoid") String aoid, @RequestParam(value = "data") String data){
        log.debug("param is aoid : {}, data is {}", aoid, data);
        TCmAgentFollow param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TCmAgentFollow.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = agentService.delAgentFollow(TokenUtils.decodeToken(aoid), param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/userSignIn")
    public String userSignIn(Long phoneNum, String passwd, @RequestParam(value = "wechatid", required = false) String wechatid){
        log.debug("param is phoneNum : {}, passwd is {}, wechatid is {}", phoneNum, passwd, wechatid);
        BaseResp<String> resp = customerService.custSignIn(phoneNum, passwd, wechatid);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/agentSignIn")
    public String agentSignIn(Long phoneNum, String passwd){
        log.debug("param is phoneNum : {}, passwd is {}", phoneNum, passwd);
        BaseResp<String> resp = agentService.agentSignIn(phoneNum, passwd);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/oneAgent")
    public String oneAgent(String aoid){
        log.debug("param is aoid : {}", aoid);
        BaseResp<AgentDto> resp = agentService.oneAgent(TokenUtils.decodeToken(aoid));
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/listAgentCust")
    public String listAgentCust(String aoid, String custType){
        log.debug("param is aoid : {}, custType : {}", aoid, custType);
        BaseResp<List<AgentCustDto>> resp = agentService.listAgentCust(TokenUtils.decodeToken(aoid), custType);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/listAgentDeal")
    public String listAgentCust(@RequestParam("aoid") String aoid, @RequestParam(value = "rent", required = false) Long rent){
        log.debug("param is aoid : {}, rent : {}", aoid, rent);
        BaseResp<AgentDealDto> resp = agentService.listAgentDeal(TokenUtils.decodeToken(aoid), rent);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/listAgentBrowse")
    public String listAgentBrowse(String aoid){
        log.debug("param is aoid : {}", aoid);
        BaseResp<AgentBrowseDto> resp = agentService.listAgentBrowse(TokenUtils.decodeToken(aoid));
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/listAgentHouse")
    public String listAgentHouse(@RequestParam("aoid") String aoid, @RequestParam(value = "rent", required = false) Long rent){
        log.debug("param is aoid : {}, rent : {}", aoid, rent);
        BaseResp<List<HouseDto>> resp = agentService.listAgentHouse(TokenUtils.decodeToken(aoid), rent);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/listAgentBooking")
    public String listAgentBooking(@RequestParam("aoid") String aoid, @RequestParam(value = "rent", required = false) Long rent){
        log.debug("param is aoid : {}, rent : {}", aoid, rent);
        BaseResp<List<AgentBookingDto>> resp = agentService.listAgentBooking(TokenUtils.decodeToken(aoid), rent);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/listAgentFollow")
    public String listAgentFollow(@RequestParam("aoid") String aoid, @RequestParam(value = "followtype", required = false) String followtype){
        log.debug("param is aoid : {}, followtype : {}", aoid, followtype);
        String token = TokenUtils.decodeToken(aoid);
        BaseResp resp = BaseUserResp.failResp(token);
        if("1".equals(followtype) || "2".equals(followtype)){
            resp = agentService.listAgentFollowHouse(token, followtype);
        } else{
            resp = agentService.listAgentFollowComm(token);
        }
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/editHouseWaitingByAgent")
    public String editHouseWaitingByAgent(@RequestParam(value = "aoid") String aoid, @RequestParam(value = "data") String data){
        log.debug("param is {}", data);
        TResHouseWaiting param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TResHouseWaiting.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = agentService.editHouseWaitingByAgent(TokenUtils.decodeToken(aoid), param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/editAgent")
    public String editAgent(@RequestParam(value = "data") String data){
        log.debug("param is {}", data);
        AgentRegisterDto param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, AgentRegisterDto.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = agentService.editAgent(param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryAgentBankcard")
    public String queryAgentBankcard(@RequestParam(value = "data") String data){
        log.debug("param is {}", data);
        TCmAgentBankcard param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TCmAgentBankcard.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = agentService.queryAgentBankcard(param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/editAgentBankcard")
    public String editAgentBankcard(@RequestParam(value = "data") String data){
        log.debug("param is {}", data);
        TCmAgentBankcard param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TCmAgentBankcard.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = agentService.editAgentBankcard(param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/chkAgentBankcard")
    public String chkAgentBankcard(@RequestParam(value = "data") String data){
        log.debug("param is {}", data);
        AgentBankcardDto param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, AgentBankcardDto.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = agentService.chkAgentBankcard(param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/delAgentBankcard")
    public String delAgentBankcard(@RequestParam(value = "oid") String oid){
        log.debug("param is {}", oid);
        BaseResp resp = agentService.delAgentBankcard(oid);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryAgentByOid")
    public String queryAgentByOid(@RequestParam(value = "oid") String oid){
        log.debug("param is {}", oid);
        BaseResp resp = agentService.queryAgentByOid(TokenUtils.decodeToken(oid));
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryAgentByOidNoToken")
    public String queryAgentByOidNoToken(@RequestParam(value = "oid") String oid){
        log.debug("param is {}", oid);
        BaseResp resp = agentService.queryAgentByOid(oid);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryAgentByPhonenum")
    public String queryAgentByPhonenum(@RequestParam(value = "phonenum") Long phonenum){
        log.debug("param is {}", phonenum);
        BaseResp resp = agentService.queryAgentByPhonenum(phonenum);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/delAgentLocalHouse")
    public String delAgentLocalHouse(@RequestParam(value = "aoid") String aoid,
                                       @RequestParam(value = "houseid") String houseid){
        log.debug("param is {},{}", aoid,houseid);
        BaseResp resp = agentService.delAgentLocalHouse(aoid,houseid);
        log.debug("resp is {}", resp);
        return resp.toString();
    }
    @RequestMapping("/addAgentLocalHouse")
    public String editAgentLocalHouse(@RequestParam(value = "aoid") String aoid,
                                     @RequestParam(value = "houseid") String houseid){
        log.debug("param is {},{}", aoid,houseid);
        BaseResp resp = agentService.addAgentLocalHouse(aoid,houseid);
        log.debug("resp is {}", resp);
        return resp.toString();
    }
}
