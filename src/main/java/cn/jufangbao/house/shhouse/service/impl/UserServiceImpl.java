package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.base.BaseServiceImpl;
import cn.jufangbao.house.shhouse.mapper.TResHouseWaitingMapper;
import cn.jufangbao.house.shhouse.model.TResHouseWaiting;
import cn.jufangbao.house.shhouse.utils.Md5Utils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * UserServiceImpl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:40:13.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class UserServiceImpl extends BaseServiceImpl {

    @Resource
    private TResHouseWaitingMapper waitingMapper;

    public List<String> getCustTypeList(){
        //1买房 2卖房 3租房 4承租
        return Arrays.asList("1", "2", "3", "4");
    }

    public List<String> getFollowTypeList(){
        //1买房 2租房 3小区
        return Arrays.asList("1", "2", "3");
    }

    private Map<Integer, String> resultMsgMap = ImmutableMap.of(0, "用户已注销");

    protected BaseResp editHouseWaiting(String aoid, String coid, TResHouseWaiting houseWaiting){
        BaseResp resp = succ("新增成功");
        Preconditions.checkArgument(houseWaiting != null, "房源信息为空");
        if(StringUtils.isNotBlank(aoid)){
            houseWaiting.setAoid(aoid);
            resp = succUserResp(aoid, "新增成功");
        }
        if(StringUtils.isNotBlank(coid)){
            houseWaiting.setCoid(coid);
            resp = succUserResp(coid, "新增成功");
        }
        if(StringUtils.isBlank(houseWaiting.getOid())){
            // add by yibin defalue status is ASSIGNING
            houseWaiting.setStatus("ASSIGNING");
            waitingMapper.insertSelective(houseWaiting);
            resp.setRetMsg("新增成功");
        } else{
            waitingMapper.updateByPrimaryKeySelective(houseWaiting);
            resp.setRetMsg("修改成功");
        }
        return resp;
    }

    protected BaseResp login(String passwd, String onePasswd, Integer status){
        BaseResp resp = succ();
        if(!Md5Utils.getMd5Pwd(passwd).equals(onePasswd)){ //密码错误
            resp = fail("密码错误");
            return resp;
        }
        Preconditions.checkArgument(status != null, "用户状态异常");
        if(new Integer(1).equals(status)){ //登录成功
            resp = succ("登录成功");
            return resp;
        }else{ //其他情况
            // 修改状态2登录问题  -- yibin
            String resultMsg;
            if ( status== 0 ) resultMsg = "工作人员已经在审批你的申请，请耐心等待";
            else if ( status== 2 ) resultMsg = "用户未审批通过，请重新提交审批";
            else resultMsg="用户状态不正确";
            resp.setRetMsg(resultMsg);
            resp.setRetCode("0");
            return resp;

        }
    }
}
