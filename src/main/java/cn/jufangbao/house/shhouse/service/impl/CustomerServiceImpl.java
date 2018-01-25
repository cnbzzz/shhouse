package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.base.BaseUserResp;
import cn.jufangbao.house.shhouse.dto.*;
import cn.jufangbao.house.shhouse.mapper.*;
import cn.jufangbao.house.shhouse.model.*;
import cn.jufangbao.house.shhouse.service.CustomerService;
import cn.jufangbao.house.shhouse.service.HouseService;
import cn.jufangbao.house.shhouse.service.PublicService;
import cn.jufangbao.house.shhouse.utils.Md5Utils;
import cn.jufangbao.house.shhouse.utils.TokenUtils;
import com.google.common.base.Preconditions;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * CustomerServiceImpl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:40:13.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class CustomerServiceImpl extends UserServiceImpl implements CustomerService {

    @Resource
    TCmCustomerMapper customerMapper;

    @Resource
    private TCmCustFollowMapper custFollowMapper;

    @Resource
    private TResHouseMapper houseMapper;

    @Resource
    private TResCommMapper commMapper;

    @Resource
    private PublicService publicService;

    @Resource
    private HouseService houseService;

    @Resource
    private TCmCustLabelMapper custLabelMapper;


    public BaseResp listCustAgent(String coid) {
        BaseResp resp = BaseResp.succResp("操作成功");
        try {
            List<CustAgentDto> tCmAgents = customerMapper.listCustAgent(coid);
            resp = succUserResp(coid);
            resp.setData(tCmAgents);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp custForgetPasswd(Long phoneNum) {
        BaseResp resp = BaseResp.succResp("操作成功");
        try {
            Preconditions.checkArgument(phoneNum != null, "手机号码为空");
            TCmCustomer param = new TCmCustomer();
            param.setPhonenum(phoneNum);
            List<TCmCustomer> list = customerMapper.select(param);
            int size = list.size();
            Preconditions.checkState(size != 0, "客户不存在");
            Preconditions.checkState(size == 1, "手机号码[%s]存在多个客户，请联系客服处理", phoneNum);
            TCmCustomer customer = list.get(0);

            Preconditions.checkState(customer.getStatus() == 1, "客户[%s]已注销", phoneNum);
            resp = publicService.sendRandomcodeSms(String.valueOf(phoneNum));
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp editCustPasswd(Long phoneNum, String newPasswd) {
        BaseResp resp = BaseResp.succResp("操作成功");
        try {
            Preconditions.checkArgument(phoneNum != null, "手机号码为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(newPasswd), "新密码为空");
            TCmCustomer param = new TCmCustomer();
            param.setPhonenum(phoneNum);
            List<TCmCustomer> list = customerMapper.select(param);
            int size = list.size();
            Preconditions.checkState(size != 0, "客户不存在");
            Preconditions.checkState(size == 1, "手机号码[%s]存在多个客户，请联系客服处理", phoneNum);
            TCmCustomer customer = list.get(0);

            Preconditions.checkState(customer.getStatus() == 1, "客户[%s]已注销", phoneNum);
            customer.setPasswd(Md5Utils.getMd5Pwd(newPasswd));
            customerMapper.updateByPrimaryKeySelective(customer);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp addCustFollow(String coid, TCmCustFollow param) {
        BaseResp resp = succUserResp(coid, "新增成功");
        try {
            Preconditions.checkArgument(param != null, "客户关注为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(coid), "客户编码为空");
            String followtype = param.getFollowtype();
            Preconditions.checkArgument(StringUtils.isNotBlank(followtype), "关注类型为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(param.getFollow()), "被关注编码为空");
            Preconditions.checkArgument(getFollowTypeList().indexOf(followtype) != -1, "关注类型不合法");
            TCmCustomer customer = customerMapper.selectByPrimaryKey(coid);
            Preconditions.checkState(customer != null, "客户未找到,客户编码[%s]", coid);

            param.setCoid(customer.getOid());
            String oid = param.getFollow();
            if ("1".equals(followtype) || "2".equals(followtype)) {
                TResHouse tResHouse = houseMapper.selectByPrimaryKey(oid);
                Preconditions.checkState(tResHouse != null, "关注房源未找到,房源编码[%s]", oid);
                houseService.plusHouseHot(oid, 0, 0, 1);
            } else {
                TResComm tResComm = commMapper.selectByPrimaryKey(oid);
                Preconditions.checkState(tResComm != null, "关注小区未找到,小区编码[%s]", oid);
            }
            param.setCreatedate(new Date());
            param.setStatus(1);
            custFollowMapper.insertSelective(param);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp delCustFollow(String coid, TCmCustFollow param) {
        BaseResp resp = succUserResp(coid, "删除成功");
        try {
            Preconditions.checkArgument(param != null, "客户关注为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(coid), "客户编码为空");
            String followtype = param.getFollowtype();
            Preconditions.checkArgument(StringUtils.isNotBlank(followtype), "关注类型为空");
            String follow = param.getFollow();
            Preconditions.checkArgument(StringUtils.isNotBlank(follow), "被关注编码为空");
            Preconditions.checkArgument(getFollowTypeList().indexOf(followtype) != -1, "关注类型不合法");

            TCmCustFollow tmpParam = new TCmCustFollow();
            tmpParam.setCoid(coid);
            tmpParam.setFollowtype(followtype);
            tmpParam.setFollow(follow);
            custFollowMapper.delete(tmpParam);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp queryCustomerByPhoneNum(Long phoneNum) {
        BaseResp resp = succ("查询成功");
        try {
            Preconditions.checkArgument(phoneNum != null, "电话号码为空");
            TCmCustomer tmp = new TCmCustomer();
            tmp.setPhonenum(phoneNum);
            List<TCmCustomer> select = customerMapper.select(tmp);
            resp.setData(select);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }

        return resp;
    }

    public BaseResp editCustomer(CustDetailDto param) {
        BaseResp resp = succ("新增成功");
        try {
            Preconditions.checkArgument(param != null, "客户为空");
            String oid = param.getOid();
            String newPasswd = param.getPasswd();
            if (StringUtils.isBlank(oid)) {
                if (StringUtils.isNotBlank(newPasswd)) {
                    param.setPasswd(Md5Utils.getMd5Pwd(newPasswd));
                }
                Long phonenum = param.getPhonenum();
                if (phonenum != null) {
                    TCmCustomer tmp = new TCmCustomer();
                    tmp.setPhonenum(phonenum);
                    List<TCmCustomer> select = customerMapper.select(tmp);
                    Preconditions.checkState(select.size() == 0, "手机号码已注册");
                }
                Integer status = param.getStatus();
                if (status == null) {
                    status = 1;
                    param.setStatus(status);
                }
                param.setCreatedate(new Date());

                String wechatid = param.getWechatid();
                boolean isUpdate = false;
                if (StringUtils.isNotBlank(wechatid)) {
                    TCmCustomer tmp = new TCmCustomer();
                    tmp.setWechatid(wechatid);
                    tmp.setStatus(1);
                    List<TCmCustomer> select = customerMapper.select(tmp);
                    if (select.size() > 0) {
                        TCmCustomer customer = select.get(0);
                        param.setOid(customer.getOid());
                        customerMapper.updateByPrimaryKeySelective(param);
                        isUpdate = true;
                    }
                }

                if (!isUpdate) {
                    customerMapper.insertSelective(param);
                }

                List<String> lableIdList = param.getLableIdList();
                if (CollectionUtils.isNotEmpty(lableIdList)) {
                    for (String label : lableIdList) {
                        TCmCustLabel custLabel = new TCmCustLabel();
                        custLabel.setCoid(param.getOid());
                        custLabel.setClabel(label);
                        custLabel.setStatus(1);
                        custLabelMapper.insertSelective(custLabel);
                    }
                }

                resp.setRetMsg("新增成功");
            } else {
                TCmCustomer customer = customerMapper.selectByPrimaryKey(oid);
                Preconditions.checkArgument(customer != null, "未查到客户信息,oid[%s]", oid);
                String oldPasswd = customer.getPasswd();
                if ((!StringUtils.equals(oldPasswd, newPasswd)) && newPasswd != null) {//修改密码
                    param.setPasswd(Md5Utils.getMd5Pwd(newPasswd));
                }
                customerMapper.updateByPrimaryKeySelective(param);

                List<String> lableIdList = param.getLableIdList();
                if (CollectionUtils.isNotEmpty(lableIdList)) {
                    TCmCustLabel tmpParam = new TCmCustLabel();
                    tmpParam.setCoid(oid);
                    custLabelMapper.delete(tmpParam);
                    for (String label : lableIdList) {
                        TCmCustLabel custLabel = new TCmCustLabel();
                        custLabel.setCoid(param.getOid());
                        custLabel.setClabel(label);
                        custLabel.setStatus(1);
                        custLabelMapper.insertSelective(custLabel);
                    }
                }

                resp.setRetMsg("修改成功");
            }
            BaseUserResp userResp = BaseUserResp.succResp(param.getOid());
            BeanUtils.copyProperties(userResp, resp);
            return userResp;
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp editHouseWaitingByCust(String coid, TResHouseWaiting houseWaiting) {
        BaseResp resp = succ("新增成功");
        try {
            Preconditions.checkArgument(houseWaiting != null, "房源信息为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(coid), "客户编码为空");
//            TCmCustomer customer = customerMapper.selectByPrimaryKey(coid);
//            Preconditions.checkState(customer != null, "未查到客户，客户编码[%s]", coid);
            resp = editHouseWaiting(null, coid, houseWaiting);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<CustDetailDto> oneCust(String oid) {
        BaseResp<CustDetailDto> resp = succUserResp(oid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(oid), "客户编码为空");
            CustDetailDto custDetailDto = customerMapper.queryCustDetailByOid(oid);
            Preconditions.checkArgument(custDetailDto != null, "客户信息未找到，客户id[%s]", oid);
            resp.setData(custDetailDto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(oid);
        }
        return resp;
    }


    public BaseResp<List<CustSellerDto>> listSellerHouse(String seller, String trantype) {
        BaseResp<List<CustSellerDto>> resp = succUserResp(seller, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(seller), "客户编码为空");
            if (StringUtils.isNotBlank(trantype)) {
                Preconditions.checkArgument(getCustTypeList().indexOf(trantype) != -1, "客户类型不合法[%s]", trantype);
            }
            List<CustSellerDto> list = customerMapper.listSellerHouse(seller, trantype);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(seller);
        }
        return resp;
    }

    public BaseResp<List<CustFollowHouseDto>> listCustFollowHouse(String coid, String followtype) {
        BaseResp<List<CustFollowHouseDto>> resp = succUserResp(coid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(coid), "客户编码为空");
            if (StringUtils.isBlank(followtype)) {
                followtype = "1";
            }
            List<CustFollowHouseDto> list = customerMapper.listCustFollowHouse(coid, followtype);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(coid);
        }
        return resp;
    }


    public BaseResp<List<CustFollowCommDto>> listCustFollowComm(String coid) {
        BaseResp<List<CustFollowCommDto>> resp = succUserResp(coid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(coid), "客户编码为空");
            List<CustFollowCommDto> list = customerMapper.listCustFollowComm(coid);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(coid);
        }
        return resp;
    }

    public BaseResp<List<HouseDto>> listBuyerDeal(String coid, Long rent) {
        BaseResp resp = succUserResp(coid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(coid), "客户编码为空");
            List<HouseDto> list = customerMapper.listBuyerDeal(coid, rent);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(coid);
        }
        return resp;
    }

    public BaseResp<List<HouseDto>> listSellerDeal(String coid, Long rent) {
        BaseResp resp = succUserResp(coid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(coid), "客户编码为空");
            List<HouseDto> list = customerMapper.listSellerDeal(coid, rent);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(coid);
        }
        return resp;
    }

    public BaseResp<List<CustBookingDto>> listCustBooking(String coid, Long rent) {
        BaseResp resp = succUserResp(coid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(coid), "客户编码为空");
            List<CustBookingDto> list = customerMapper.listCustBooking(coid, rent);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(coid);
        }
        return resp;
    }

    public BaseResp<List<CustSeenDto>> listCustSeenHouse(String coid) {
        BaseResp<List<CustSeenDto>> resp = succUserResp(coid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(coid), "客户编码为空");
            List<CustSeenDto> list = customerMapper.listCustSeenHouse(coid);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(coid);
        }
        return resp;
    }

    public BaseResp<String> custSignIn(Long phoneNum, String passwd, String wechatId) {
        BaseResp resp = succ("查询成功");
        try {
            Preconditions.checkArgument(phoneNum != null, "入参手机号码为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(passwd), "入参密码为空");
            TCmCustomer param = new TCmCustomer();
            param.setPhonenum(phoneNum);
            TCmCustomer one = customerMapper.selectOne(param);
            if (one != null) {
                BaseResp login = login(passwd, one.getPasswd(), one.getStatus());
                if (BaseResp.SUCC.equals(login.getRetCode())) {
                    if (StringUtils.isNotBlank(wechatId)) {
                        TCmCustomer tmp = new TCmCustomer();
                        tmp.setWechatid(wechatId);
                        List<TCmCustomer> select = customerMapper.select(tmp);
                        for (TCmCustomer cust : select) {
                            if (phoneNum.equals(cust.getPhonenum())) {
                                continue;
                            }
                            cust.setStatus(-1); //通过微信id合并遗留数据
                            customerMapper.updateByPrimaryKeySelective(cust);
                        }
                        one.setWechatid(wechatId);
                    }
                    one.setLastlogindate(new Date());
                    customerMapper.updateByPrimaryKeySelective(one);
                    login.setData(TokenUtils.encodeToken(one.getOid()));
                }
                return login;
            } else {
                resp = fail("无此用户");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

}
