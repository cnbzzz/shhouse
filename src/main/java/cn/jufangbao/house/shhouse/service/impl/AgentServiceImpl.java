package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.base.BaseUserResp;
import cn.jufangbao.house.shhouse.dto.*;
import cn.jufangbao.house.shhouse.mapper.*;
import cn.jufangbao.house.shhouse.model.*;
import cn.jufangbao.house.shhouse.service.AgentService;
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
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * AgentServiceImpl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:40:13.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AgentServiceImpl extends UserServiceImpl implements AgentService {

    @Resource
    private TCmAgentMapper agentMapper;

    @Resource
    private TResHouseMapper houseMapper;

    @Resource
    private TCmAgentDealcountMapper dealcountMapper;

    @Resource
    private TCmAgentBrowsecountMapper browsecountMapper;

    @Resource
    private TCmAgentFollowMapper agentFollowMapper;

    @Resource
    private TResCommMapper commMapper;

    @Resource
    private TCmAgentBankcardMapper agentBankcardMapper;

    @Resource
    private PublicService publicService;

    @Resource
    private HouseService houseService;

    public BaseResp agentForgetPasswd(Long phoneNum) {
        BaseResp resp = BaseResp.succResp("操作成功");
        try {
            Preconditions.checkArgument(phoneNum != null, "手机号码为空");
            TCmAgent param = new TCmAgent();
            param.setPhonenum(phoneNum);
            List<TCmAgent> list = agentMapper.select(param);
            int size = list.size();
            Preconditions.checkState(size != 0, "经纪人不存在");
            Preconditions.checkState(size == 1, "手机号码[%s]存在多个经纪人，请联系客服处理", phoneNum);
            TCmAgent agent = list.get(0);

            Preconditions.checkState(agent.getStatus() == 1, "经纪人[%s]已注销", phoneNum);
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

    public BaseResp editAgentPasswd(Long phoneNum, String newPasswd) {
        BaseResp resp = BaseResp.succResp("操作成功");
        try {
            Preconditions.checkArgument(phoneNum != null, "手机号码为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(newPasswd), "新密码为空");
            TCmAgent param = new TCmAgent();
            param.setPhonenum(phoneNum);
            List<TCmAgent> list = agentMapper.select(param);
            int size = list.size();
            Preconditions.checkState(size != 0, "经纪人不存在");
            Preconditions.checkState(size == 1, "手机号码[%s]存在多个经纪人，请联系客服处理", phoneNum);
            TCmAgent agent = list.get(0);

            Preconditions.checkState(agent.getStatus() == 1, "经纪人[%s]已注销", phoneNum);
            agent.setPasswd(Md5Utils.getMd5Pwd(newPasswd));
            agentMapper.updateByPrimaryKeySelective(agent);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    @Override
    public List<String> getCustTypeList() {
        return super.getCustTypeList();
    }

    public BaseResp addAgentFollow(String aoid, TCmAgentFollow param) {
        BaseResp resp = succUserResp(aoid, "新增成功");
        try {
            Preconditions.checkArgument(param != null, "经纪人关注为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人为空");
            String followtype = param.getFollowtype();
            Preconditions.checkArgument(StringUtils.isNotBlank(followtype), "关注类型为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(param.getFollow()), "被关注编码为空");
            Preconditions.checkArgument(getFollowTypeList().indexOf(followtype) != -1, "关注类型不合法");
            TCmAgent agent = agentMapper.selectByPrimaryKey(aoid);
            Preconditions.checkState(agent != null, "经纪人未找到,经纪人编码[%s]", aoid);

            String oid = param.getFollow();
            if ("1".equals(followtype) || "2".equals(followtype)) {
                TResHouse tResHouse = houseMapper.selectByPrimaryKey(oid);
                Preconditions.checkState(tResHouse != null, "关注房源未找到,房源编码[%s]", oid);
                houseService.plusHouseHot(tResHouse.getOid(), 0, 0, 1);
            } else {
                TResComm tResComm = commMapper.selectByPrimaryKey(oid);
                Preconditions.checkState(tResComm != null, "关注小区未找到,小区编码[%s]", oid);
            }
            param.setAoid(aoid);
            param.setCreatedate(new Date());
            param.setStatus(1);
            agentFollowMapper.insertSelective(param);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }


    public BaseResp delAgentFollow(String aoid, TCmAgentFollow param) {
        BaseResp resp = succUserResp(aoid, "删除成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人编码为空");
            Preconditions.checkArgument(param != null, "经纪人关注为空");
            String followtype = param.getFollowtype();
            Preconditions.checkArgument(StringUtils.isNotBlank(followtype), "关注类型为空");
            String follow = param.getFollow();
            Preconditions.checkArgument(StringUtils.isNotBlank(follow), "被关注编码为空");
            Preconditions.checkArgument(getFollowTypeList().indexOf(followtype) != -1, "关注类型不合法");

            TCmAgentFollow tmpParam = new TCmAgentFollow();
            tmpParam.setAoid(aoid);
            tmpParam.setFollowtype(followtype);
            tmpParam.setFollow(follow);
            agentFollowMapper.delete(tmpParam);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }


    public BaseResp editAgent(AgentRegisterDto param) {
        BaseResp resp = succ("新增成功");
        try {
            Preconditions.checkArgument(param != null, "经纪人为空");
            String oid = param.getOid();
            String newPasswd = param.getPasswd();
            if (StringUtils.isBlank(oid)) {
                if (StringUtils.isNotBlank(newPasswd)) {
                    param.setPasswd(Md5Utils.getMd5Pwd(newPasswd));
                }
                Long phonenum = param.getPhonenum();
                Preconditions.checkState(phonenum != null, "手机号码不能为空");
                TCmAgent tmp = new TCmAgent();
                tmp.setPhonenum(phonenum);
                List<TCmAgent> select = agentMapper.select(tmp);
                Preconditions.checkState(select.size() == 0, "手机号码已注册，请填写新的手机号码注册");

                // 增加 证件号码重复验证，yibin 20170601
                tmp = new TCmAgent();
                tmp.setIdcardnum(param.getIdcardnum());
                select = agentMapper.select(tmp);
                Preconditions.checkState(select.size() == 0, "证件号码已经注册，请重新填写证件号码");
                Integer status = param.getStatus();
                if (status == null) {
                    status = 0;
                }
                param.setStatus(status);
                param.setCreatedate(new Date());
                agentMapper.insertSelective(param);

                String bankid = param.getBankid();
                String bankcardnum = param.getBankcardnum();
                String accountperson = param.getAccountperson();

                if (StringUtils.isNotBlank(bankid) && StringUtils.isNotBlank(bankcardnum) && StringUtils.isNotBlank(accountperson)) {
                    TCmAgentBankcard tmpBankcard = new TCmAgentBankcard();
                    tmpBankcard.setAoid(param.getOid());
                    tmpBankcard.setBankid(bankid);
                    tmpBankcard.setBankcardnum(bankcardnum);
                    tmpBankcard.setAccountperson(accountperson);
                    tmpBankcard.setCreatedate(new Date());
                    tmpBankcard.setStatus(1);
                    agentBankcardMapper.insertSelective(tmpBankcard);
                }

                resp = succUserResp(param.getOid(), "新增成功");
            } else {
                TCmAgent agent = agentMapper.selectByPrimaryKey(oid);
                Preconditions.checkArgument(agent != null, "未查到经纪人信息,phonenum[%s]", oid);
                String oldPasswd = agent.getPasswd();
                if ((!StringUtils.equals(oldPasswd, newPasswd)) && newPasswd != null) {//修改密码
                    param.setPasswd(Md5Utils.getMd5Pwd(newPasswd));
                }
                agentMapper.updateByPrimaryKeySelective(param);
                resp = succUserResp(param.getOid(), "新增成功");
            }
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<List<AgentBankcardDetailDto>> queryAgentBankcard(TCmAgentBankcard bankcard) {
        BaseResp resp = succ("查询成功");
        try {
            Preconditions.checkArgument(bankcard != null, "银行卡信息为空");
            String oid = bankcard.getOid();
            String aoid = bankcard.getAoid();
            Preconditions.checkArgument(StringUtils.isNotBlank(oid) || StringUtils.isNotBlank(aoid), "oid或者aoid任意一个不能为空");
            Integer status = bankcard.getStatus();
            if (status == null) {
                status = 1;
            }
            bankcard.setStatus(status);
            List<AgentBankcardDetailDto> bankcardList = agentBankcardMapper.queryAgentBankcard(bankcard);
            resp = succUserResp(aoid, "查询成功");
            resp.setData(bankcardList);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp chkAgentBankcard(AgentBankcardDto bankcard) {
        BaseResp resp = succ("检查通过");
        try {
            Preconditions.checkArgument(bankcard != null, "银行卡信息为空");

            String bankcardnum = bankcard.getBankcardnum();
            Preconditions.checkArgument(StringUtils.isNotBlank(bankcardnum), "银行卡号不能为空");

            String accountperson = bankcard.getAccountperson();
            Preconditions.checkArgument(StringUtils.isNotBlank(accountperson), "开户名不能为空");

            String aoid = bankcard.getAoid();
            String registerName = bankcard.getRegisterName();
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid) || StringUtils.isNotBlank(registerName), "经纪人编码和注册名任意一个必须有值");

            String regEx = "^(\\d{16}|\\d{19})$"; //银行卡号必须是16位或者19位的数字
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(bankcardnum);
            boolean rs = matcher.matches();
            Preconditions.checkState(rs, "银行卡号[%s]不合法，应该是16或19位数字", bankcardnum);

            if(StringUtils.isNotBlank(aoid)){
                TCmAgent agent = agentMapper.selectByPrimaryKey(aoid);
                Preconditions.checkState(agent != null, "未找到经纪人信息，经纪人编码[%s]", aoid);
                registerName = agent.getName();
            }

            Preconditions.checkState(accountperson.equals(registerName), "银行卡开户名要和注册名一致");
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }
    @Resource
    TCmAgentLhouseMapper CmAgentLhouseMapper;
    @Override
    public BaseResp delAgentLocalHouse(String aoid, String houseid) {
        BaseResp resp = succ("删除成功");
        try {
            Preconditions.checkArgument(aoid != null, "经纪人ID为空");
            Preconditions.checkArgument(houseid != null, "房源ID为空");
            CmAgentLhouseMapper.deleteByAgentHouseID(aoid,houseid);

        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    @Override
    public BaseResp addAgentLocalHouse(String aoid, String houseid) {
        BaseResp resp = succ("添加成功");
        try {
            TCmAgentLhouse calh = new TCmAgentLhouse();
            Preconditions.checkArgument(aoid != null, "经纪人ID为空");
            Preconditions.checkArgument(houseid != null, "房源ID为空");
            calh.setOid(UUID.randomUUID().toString());
            calh.setAoid(aoid);
            calh.setHoid(houseid);
            calh.setAddtime(new Date());
            CmAgentLhouseMapper.insert(calh);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp editAgentBankcard(TCmAgentBankcard bankcard) {
        BaseResp resp = succ("新增成功");
        try {
            Preconditions.checkArgument(bankcard != null, "银行卡信息为空");
            String oid = bankcard.getOid();
            String bankid = bankcard.getBankid();
            String bankcardnum = bankcard.getBankcardnum();

            if (StringUtils.isNotBlank(bankcardnum)) {//银行卡号不为空
                String regEx = "^(\\d{16}|\\d{19})$"; //银行卡号必须是16位或者19位的数字
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(bankcardnum);
                boolean rs = matcher.matches();
                Preconditions.checkState(rs, "银行卡号[%s]不合法，应该是16或19位数字", bankcardnum);
            }

            String aoid = bankcard.getAoid();
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人id为空");
            TCmAgent agent = agentMapper.selectByPrimaryKey(aoid);
            Preconditions.checkState(agent != null, "未找到经纪人信息，经纪人编码[%s]", aoid);

            String accountperson = bankcard.getAccountperson();

            if (StringUtils.isNotBlank(accountperson)) {
                Preconditions.checkState(accountperson.equals(agent.getName()), "银行卡开户名要和注册名一致");
            }

            if (StringUtils.isBlank(oid)) {//新增
                Preconditions.checkArgument(StringUtils.isNotBlank(bankid), "开户行为空");
                Preconditions.checkArgument(StringUtils.isNotBlank(bankcardnum), "银行卡号为空");
                Preconditions.checkArgument(StringUtils.isNotBlank(accountperson), "开户人为空");
                Integer status = bankcard.getStatus();

                if (status == null) {
                    status = 1;
                    bankcard.setStatus(status);
                }
                bankcard.setCreatedate(new Date());
                agentBankcardMapper.insertSelective(bankcard);
                resp = succUserResp(aoid, "新增成功");
            } else {
                TCmAgentBankcard tCmAgentBankcard = agentBankcardMapper.selectByPrimaryKey(oid);
                Preconditions.checkState(tCmAgentBankcard != null, "未找到经纪人银行卡信息，经纪人银行卡编码[%s]", oid);
                if (StringUtils.isNotBlank(bankid)) {
                    tCmAgentBankcard.setBankid(bankid);
                }

                if (StringUtils.isNotBlank(bankcardnum)) {
                    tCmAgentBankcard.setBankcardnum(bankcardnum);
                }

                if (StringUtils.isNotBlank(accountperson)) {
                    tCmAgentBankcard.setAccountperson(accountperson);
                }

                agentBankcardMapper.updateByPrimaryKeySelective(tCmAgentBankcard);
                resp = succUserResp(aoid, "修改成功");
            }
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp delAgentBankcard(String oid) {
        BaseResp resp = succ("删除成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(oid), "经纪人银行编码为空");

            TCmAgentBankcard tCmAgentBankcard = agentBankcardMapper.selectByPrimaryKey(oid);
            Preconditions.checkState(tCmAgentBankcard != null, "未找到经纪人银行卡信息，经纪人银行卡编码[%s]", oid);
            agentBankcardMapper.deleteByPrimaryKey(oid);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<AgentWithBankcardDto> queryAgentByOid(String oid) {
        BaseResp resp = succUserResp(oid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(oid), "经纪人编码为空");
            AgentWithBankcardDto agent = agentMapper.queryAgentByOid(oid);
            Preconditions.checkState(agent != null, "未找到经纪人，编号[%s]", oid);

            TCmAgentBankcard bankcard = new TCmAgentBankcard();
            bankcard.setAoid(oid);
            bankcard.setStatus(1);
            List<AgentBankcardDetailDto> bankcardList = agentBankcardMapper.queryAgentBankcard(bankcard);
            agent.setBankcardList(bankcardList);

            resp = succUserResp(oid);
            resp.setData(agent);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<AgentWithBankcardDto> queryAgentByPhonenum(Long phonenum) {
        BaseResp resp = succ("查询成功");
        try {
            Preconditions.checkArgument(phonenum != null, "经纪人编码为空");
            TCmAgent tmp = new TCmAgent();
            tmp.setPhonenum(phonenum);
            List<TCmAgent> select = agentMapper.select(tmp);
            Preconditions.checkState(select.size() != 0, "未找到经纪人，手机号码[%s]", phonenum);
            TCmAgent tmpAgent = select.get(0);

            String oid = tmpAgent.getOid();
            AgentWithBankcardDto agent = agentMapper.queryAgentByOid(oid);
            Preconditions.checkState(agent != null, "未找到经纪人，编号[%s]", oid);

            TCmAgentBankcard bankcard = new TCmAgentBankcard();
            bankcard.setAoid(oid);
            bankcard.setStatus(1);
            List<AgentBankcardDetailDto> bankcardList = agentBankcardMapper.queryAgentBankcard(bankcard);
            agent.setBankcardList(bankcardList);

            resp = succUserResp(oid);
            resp.setData(agent);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp editHouseWaitingByAgent(String aoid, TResHouseWaiting houseWaiting) {
        BaseResp resp = succ("新增成功");
        try {
            Preconditions.checkArgument(houseWaiting != null, "房源信息为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人编码为空");
            TCmAgent agent = agentMapper.selectByPrimaryKey(aoid);
            Preconditions.checkState(agent != null, "未查到经纪人，经纪人编码[%s]", aoid);
            resp = editHouseWaiting(aoid, null, houseWaiting);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<List<HouseDto>> listAgentFollowHouse(String aoid, String followtype) {
        BaseResp resp = succUserResp(aoid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人编码为空");
            if (StringUtils.isBlank(followtype)) {
                followtype = "1";//默认售房
            }
            List<HouseDto> list = agentMapper.listAgentFollowHouse(aoid, followtype);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(aoid);
        }
        return resp;
    }

    public BaseResp<List<AgentFollowCommDto>> listAgentFollowComm(String aoid) {
        BaseResp resp = succUserResp(aoid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人编码为空");
            List<AgentFollowCommDto> list = agentMapper.listAgentFollowComm(aoid);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(aoid);
        }
        return resp;
    }

    public BaseResp<List<AgentBookingDto>> listAgentBooking(String aoid, Long rent) {
        BaseResp resp = succUserResp(aoid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人编码为空");
            if (rent == null) {
                rent = 0l;//默认售房
            }
            List<AgentBookingDto> list = agentMapper.listAgentBooking(aoid, rent);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(aoid);
        }
        return resp;
    }

    public BaseResp<List<HouseDto>> listAgentHouse(String aoid, Long rent) {
        BaseResp resp = succUserResp(aoid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人编码为空");
            if (rent == null) {
                rent = 0l;//默认售房
            }
            List<HouseDto> list = houseMapper.listAgentHouse(aoid, rent);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(aoid);
        }
        return resp;
    }

    public BaseResp<AgentBrowseDto> listAgentBrowse(String aoid) {
        BaseResp resp = succUserResp(aoid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人编码为空");
            List<CustDto> list = agentMapper.listAgentBrowse(aoid);
            TCmAgentBrowsecount param = new TCmAgentBrowsecount();
            param.setAoid(aoid);
            param.setStatus(1);
            TCmAgentBrowsecount result = browsecountMapper.selectOne(param);
            AgentBrowseDto dto = new AgentBrowseDto();
            if (result != null) {
                BeanUtils.copyProperties(dto, result);
            }
            dto.setHouseCustList(list);
            resp.setData(dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(aoid);
        }
        return resp;
    }

    public BaseResp<AgentDealDto> listAgentDeal(String aoid, Long rent) {
        BaseResp resp = succUserResp(aoid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人编码为空");
            if (rent == null) {
                rent = 0l;//默认售房
            }
            List<HouseDto> list = houseMapper.listAgentDealHouse(aoid, rent);
            TCmAgentDealcount param = new TCmAgentDealcount();
            param.setAoid(aoid);
            param.setRent(rent);
            param.setStatus(1);
            TCmAgentDealcount result = dealcountMapper.selectOne(param);
            AgentDealDto dto = new AgentDealDto();
            if (result != null) {
                BeanUtils.copyProperties(dto, result);
            }
            dto.setHouseList(list);
            resp.setData(dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(aoid);
        }
        return resp;
    }

    public BaseUserResp<List<AgentCustDto>> listAgentCust(String aoid, String custType) {
        BaseUserResp<List<AgentCustDto>> resp = succUserResp(aoid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(aoid), "经纪人编码为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(custType), "经纪人客户类型为空");
            Preconditions.checkArgument(getCustTypeList().indexOf(custType) != -1, "经纪人客户类型不正确");
            List<AgentCustDto> list = agentMapper.listAgentCust(aoid, custType);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(aoid);
        }
        return resp;
    }

    public BaseResp<AgentDto> oneAgent(String oid) {
        BaseResp<AgentDto> resp = succUserResp(oid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(oid), "经纪人编码为空");
            AgentDto dto = agentMapper.oneAgent(oid);
            Preconditions.checkArgument(dto != null, "经纪人信息未找到，经纪人id[%s]", oid);
            dto.setLocalHouseList(houseMapper.listNativeHouseByAgentId(oid));
            dto.setRecomHouseList(houseMapper.listRecomHouseByAgentId(oid));
            resp.setData(dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(oid);
        }
        return resp;
    }

    public BaseResp<List<HouseDto>> listRecomHouseByAgentId(String oid) {
        BaseResp<List<HouseDto>> resp = succUserResp(oid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(oid), "经纪人编码为空");
            List<HouseDto> list = houseMapper.listRecomHouseByAgentId(oid);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(oid);
        }
        return resp;
    }

    public BaseResp<List<HouseDto>> listNativeHouseByAgentId(String oid) {
        BaseResp<List<HouseDto>> resp = succUserResp(oid, "查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(oid), "经纪人编码为空");
            List<HouseDto> list = houseMapper.listNativeHouseByAgentId(oid);
            resp.setData(list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = failUserResp(oid);
        }
        return resp;
    }

    public BaseResp<String> agentSignIn(Long phoneNum, String passwd) {
        BaseResp resp = succ("查询成功");
        try {
            Preconditions.checkArgument(phoneNum != null, "入参手机号码为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(passwd), "入参密码为空");
            TCmAgent param = new TCmAgent();
            param.setPhonenum(phoneNum);
            TCmAgent one = agentMapper.selectOne(param);
            if (one != null) {
                log.debug("agent data={}",one.toString());
                BaseResp login = login(passwd, one.getPasswd(), one.getStatus());
                if (BaseResp.SUCC.equals(login.getRetCode())) {
                    one.setLastlogindate(new Date());
                    agentMapper.updateByPrimaryKeySelective(one);
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
