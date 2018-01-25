package cn.jufangbao.house.shhouse.ctrl;

import cn.jufangbao.house.shhouse.base.BaseCtrl;
import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.base.BaseUserResp;
import cn.jufangbao.house.shhouse.dto.*;
import cn.jufangbao.house.shhouse.model.TCmCustFollow;
import cn.jufangbao.house.shhouse.model.TResHouseWaiting;
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
 * CustCtrl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:35:13.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
@RestController
@RequestMapping("/cust")
public class CustCtrl extends BaseCtrl {
    @Resource
    private CustomerService customerService;

    @RequestMapping("/oneCust")
    public String oneCust(String coid){
        log.debug("param is {}", coid);
        BaseResp resp = customerService.oneCust(TokenUtils.decodeToken(coid));
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/oneCustNoToken")
    public String oneCustNoToken(String coid){
        log.debug("param is {}", coid);
        BaseResp resp = customerService.oneCust(coid);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/custForgetPasswd")
    public String custForgetPasswd(Long phoneNum){
        log.debug("param is {}", phoneNum);
        BaseResp resp = customerService.custForgetPasswd(phoneNum);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryCustomerByPhoneNum")
    public String queryCustomerByPhoneNum(Long phoneNum){
        log.debug("param is {}", phoneNum);
        BaseResp resp = customerService.queryCustomerByPhoneNum(phoneNum);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/editCustPasswd")
    public String editCustPasswd(Long phoneNum, String newPasswd){
        log.debug("param is {}, {}", phoneNum, newPasswd);
        BaseResp resp = customerService.editCustPasswd(phoneNum, newPasswd);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/listCustAgent")
    public String listCustAgent(@RequestParam("coid") String coid){
        log.debug("param is {}", coid);
        BaseResp resp = customerService.listCustAgent(TokenUtils.decodeToken(coid));
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/editCustomer")
    public String editCustomer(@RequestParam(value = "data") String data){
        log.debug("param is {}", data);
        CustDetailDto param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, CustDetailDto.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = customerService.editCustomer(param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/editHouseWaitingByCust")
    public String editHouseWaitingByCust(@RequestParam(value = "coid", required = false) String coid, @RequestParam(value = "data") String data){
        log.debug("param is {}", data);
        TResHouseWaiting param = null;
        if(StringUtils.isBlank(coid)){
            coid = TokenUtils.encodeToken("guest");
        }
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
        BaseResp resp = customerService.editHouseWaitingByCust(TokenUtils.decodeToken(coid), param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/addCustFollow")
    public String addCustFollow(@RequestParam("coid") String coid, @RequestParam(value = "data") String data){
        log.debug("param is coid : {}, data is {}", coid, data);
        TCmCustFollow param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TCmCustFollow.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = customerService.addCustFollow(TokenUtils.decodeToken(coid), param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/delCustFollow")
    public String delCustFollow(@RequestParam("coid") String coid, @RequestParam(value = "data") String data){
        log.debug("param is coid : {}, data is {}", coid, data);
        TCmCustFollow param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TCmCustFollow.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = customerService.delCustFollow(TokenUtils.decodeToken(coid), param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/custhouse")
    public String custHouse(@RequestParam("coid") String coid, @RequestParam(value = "trantype", required = false) String trantype){
        log.debug("param is coid : {}, trantype is : {}", coid, trantype);
        BaseResp<List<CustSellerDto>> resp = customerService.listSellerHouse(TokenUtils.decodeToken(coid), trantype);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/custfollow")
    public String custFollow(@RequestParam("coid") String coid, @RequestParam("followtype") String followtype){
        log.debug("param is coid : {}", coid);
        String token = TokenUtils.decodeToken(coid);
        BaseResp resp = BaseUserResp.failResp(token);
        if("1".equals(followtype) || "2".equals(followtype)){
            resp = customerService.listCustFollowHouse(token, followtype);
        } else{
            resp = customerService.listCustFollowComm(token);
        }

        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/custbooking")
    public String custBooking(@RequestParam("coid") String coid, @RequestParam(value = "rent", required = false) Long rent){
        log.debug("param is coid : {}", coid);
        BaseResp<List<CustBookingDto>> resp = customerService.listCustBooking(TokenUtils.decodeToken(coid), rent);
        log.debug("resp is {}", resp);
        return resp.toString();
    }


    @RequestMapping("/buyerdeal")
    public String buyerDeal(@RequestParam("coid") String coid, @RequestParam(value = "rent", required = false) Long rent){
        log.debug("param is coid : {}", coid);
        BaseResp<List<HouseDto>> resp = customerService.listBuyerDeal(TokenUtils.decodeToken(coid), rent);
        log.debug("resp is {}", resp);
        return resp.toString();
    }


    @RequestMapping("/sellerdeal")
    public String sellerDeal(@RequestParam("coid") String coid, @RequestParam(value = "rent", required = false) Long rent){
        log.debug("param is coid : {}", coid);
        BaseResp<List<HouseDto>> resp = customerService.listSellerDeal(TokenUtils.decodeToken(coid), rent);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/custseen")
    public String custSeen(@RequestParam("coid") String coid){
        log.debug("param is coid : {}", coid);
        BaseResp<List<CustSeenDto>> resp = customerService.listCustSeenHouse(TokenUtils.decodeToken(coid));
        log.debug("resp is {}", resp);
        return resp.toString();
    }
}
