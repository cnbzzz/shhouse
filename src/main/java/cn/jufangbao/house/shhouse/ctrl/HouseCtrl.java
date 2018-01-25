package cn.jufangbao.house.shhouse.ctrl;

import cn.jufangbao.house.shhouse.base.BaseCtrl;
import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.base.BaseUserResp;
import cn.jufangbao.house.shhouse.dto.HouseDetailDto;
import cn.jufangbao.house.shhouse.dto.HouseDto;
import cn.jufangbao.house.shhouse.dto.HouseQueryItemDto;
import cn.jufangbao.house.shhouse.model.TCmAgent;
import cn.jufangbao.house.shhouse.model.TResBuilding;
import cn.jufangbao.house.shhouse.model.TResComm;
import cn.jufangbao.house.shhouse.model.TResHouse;
import cn.jufangbao.house.shhouse.param.HouseQueryCondParam;
import cn.jufangbao.house.shhouse.service.HouseService;
import cn.jufangbao.house.shhouse.utils.TokenUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HouseCtrl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:35:16.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
@RestController
@RequestMapping("/house")
public class HouseCtrl extends BaseCtrl {

    @Resource
    private HouseService houseService;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "data", required = false)  String json) {
        log.debug("param is {}", json);
        HouseQueryCondParam param = null;
        if(StringUtils.isNotBlank(json)){
            try{
                param = JSON.parseObject(json, HouseQueryCondParam.class);
            } catch(JSONException e){
                log.error("json is bad {}", json);
            }
        }
        if(param == null)
            param = new HouseQueryCondParam();
        BaseResp<List<HouseDto>> resp = houseService.listHouseByCond(param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/list/queryItem")
    public String queryItem(){
        log.debug("no param");
        BaseResp<Map<String, List<HouseQueryItemDto>>> resp = houseService.listHouseQueryItem();
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryStrPrompt")
    public String queryStrPrompt(@RequestParam("str") String str, @RequestParam(value = "limit", required = false) Long limit){
        log.debug("param is str {}, limit {}", str, limit);
        BaseResp<List<String>> resp = houseService.queryStrPrompt(str, limit);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryHouseDetail")
    public String queryHouseDetail(@RequestParam("oid") String oid, @RequestParam(value = "aoid",required = false) String aoid, @RequestParam(value = "coid",required = false) String coid){
        log.debug("no param");
        if(StringUtils.isNotBlank(aoid)){
            aoid = TokenUtils.decodeToken(aoid);
        }
        if(StringUtils.isNotBlank(coid)){
            coid = TokenUtils.decodeToken(coid);
        }

        BaseResp<HouseDetailDto> resp = houseService.oneHouseDetail(oid, aoid, coid);
        if(StringUtils.isNotBlank(aoid)){
            resp = resp2UserResp(aoid, resp);
        }
        if(StringUtils.isNotBlank(coid)){
            resp = resp2UserResp(coid, resp);
        }
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    private BaseResp resp2UserResp(@RequestParam(value = "aoid", required = false) String aoid, BaseResp<HouseDetailDto> resp) {
        BaseUserResp userResp = new BaseUserResp();
        try {
            BeanUtils.copyProperties(userResp, resp);
            userResp.setToken(aoid);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return resp;
        }
        return userResp;
    }

    @RequestMapping("/houseCompare")
    public String houseCompare(String oid, String otherOid){
        log.debug("param is oid : {}, otherOid : {}", oid, otherOid);
        BaseResp<Map<String, HouseDto>> resp = houseService.houseCompare(oid, otherOid);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/editComm")
    public String editComm(@RequestParam(value = "data") String data){
        log.debug("param is {}", data);
        TResComm param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TResComm.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = houseService.editComm(param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/editBuilding")
    public String editBuilding(@RequestParam(value = "data") String data){
        log.debug("param is {}", data);
        TResBuilding param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TResBuilding.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = houseService.editBuilding(param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/editHouse")
    public String editHouse(@RequestParam(value = "data") String data){
        log.debug("param is {}", data);
        TResHouse param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TResHouse.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("操作失败").toString();
        }
        BaseResp resp = houseService.editHouse(param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/listByAgentLocal")
    public String listByAgentLocal(@RequestParam(value = "data", required = false)  String json) {
        log.debug("param is {}", json);
        List<String> param = null;

        if(StringUtils.isNotBlank(json)){
            try{
                param = JSON.parseArray(json, String.class);
            } catch(JSONException e){
                log.error("json is bad {}", json);
            }
        }
        if(param == null) param = new ArrayList<String>();
        /*
        param.add("3100e7d9-3852-11e7-9a1f-00163e068506");
        param.add("1");
        param.add("cd254c85-274f-11e7-9a1f-00163e068506");*/
          //  param = new HouseQueryCondParam();
        BaseResp<List<HouseDto>> resp = houseService.listHouseByAgentLocal(param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }
}
