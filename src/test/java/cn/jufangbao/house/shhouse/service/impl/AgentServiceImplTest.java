package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.dto.AgentBankcardDto;
import cn.jufangbao.house.shhouse.dto.AgentRegisterDto;
import cn.jufangbao.house.shhouse.main.Launcher;
import cn.jufangbao.house.shhouse.model.*;
import cn.jufangbao.house.shhouse.service.AgentService;
import cn.jufangbao.house.shhouse.utils.Md5Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Launcher.class)
@WebAppConfiguration
public class AgentServiceImplTest {

    Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private AgentService agentService;

    @Test
    public void test1() {
        BaseResp resp = agentService.agentSignIn(13800138001l, "eee");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test2() {
        BaseResp resp = agentService.oneAgent("1");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test3() {
        BaseResp resp = agentService.listAgentCust("1", "1");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test4() {
        BaseResp resp = agentService.listAgentDeal("1", null);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test5() {
        BaseResp resp = agentService.listAgentBrowse("1");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test6() {
        BaseResp resp = agentService.listAgentHouse("1", 1l);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test7() {
        BaseResp resp = agentService.listAgentBooking("1", 1l);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test8() {
        BaseResp resp = agentService.listAgentFollowHouse("1", "1");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
        resp = agentService.listAgentFollowHouse("1", "2");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
        resp = agentService.listAgentFollowComm("1");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test9() {
        TResHouseWaiting houseWaiting = new TResHouseWaiting();
//        houseWaiting.setOid("ae96286a-a274-4479-9058-d87162ae9012");
        houseWaiting.setCname("世纪云顶");
        houseWaiting.setAttr("广州大道南387号");
        houseWaiting.setHnum("996");
        houseWaiting.setRent("1");
        houseWaiting.setPrice(12345l);
        houseWaiting.setCallname("小王");
        houseWaiting.setPhonenum(1380013800l);
        log.debug(houseWaiting);
        BaseResp resp = agentService.editHouseWaitingByAgent("1", houseWaiting);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test10() {
        AgentRegisterDto param = new AgentRegisterDto();
//        param.setOid("cd73467a-0d3f-11e7-989f-00163e068506");
        param.setName("ddd");
        String passwd = "eee";
        param.setPasswd(passwd);
        long phonenum = 13012345684l;
        param.setPhonenum(phonenum);
        param.setIdcardnum("420626198808130037");
        param.setIpath("http://120.76.53.1/img/face.jpg");
        param.setWorkyear(10);
        param.setServicearea("1");
        param.setShopname("abc的小店");
        param.setBgipath("http://120.76.53.1/img/face.jpg");
        param.setCompany("Eric");
        param.setAddr("广州大道南368号");
        param.setIntroducer("bzzz");
        param.setIntroducerphonenum(13527897960l);
        log.debug(Md5Utils.getMd5Pwd(passwd));
        param.setBankid("ZGYH");
        param.setBankcardnum("1234567890123456789");
        param.setAccountperson("ddd");
        log.debug(param);//1d8922d005309356634c3114859436f2
        BaseResp resp = agentService.editAgent(param);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test11() {
        TCmAgentFollow param = new TCmAgentFollow();
        param.setFollow("1");
        param.setFollowtype("1");
        log.debug(param);
        BaseResp resp = agentService.addAgentFollow("1", param);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());

        resp = agentService.addAgentFollow("2333", param);
        log.debug(resp);
        Assert.assertSame(BaseResp.FAIL, resp.getRetCode());
    }

    @Test
    public void test12() {
        TCmAgentFollow param = new TCmAgentFollow();
        param.setFollow("1");
        param.setFollowtype("1");
        log.debug(param);
        BaseResp resp = agentService.addAgentFollow("1", param);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());

//        resp = agentService.delAgentFollow("1", param);
//        log.debug(resp);
//        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test13() {
        BaseResp resp = agentService.agentForgetPasswd(15915864285l);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test14() {
        String newPasswd = "123456";
        BaseResp resp = agentService.editAgentPasswd(15915864285l, newPasswd);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());

        resp = agentService.agentSignIn(15915864285l, newPasswd);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test15() {
        BaseResp resp = agentService.queryAgentByOid("1da0b5ec-3310-11e7-9a1f-00163e068506");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
        resp = agentService.queryAgentByPhonenum(13642631734l);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test16() {
        AgentBankcardDto bankcard = new AgentBankcardDto();
        String aoid = "37883df9-2030-11e7-9a1f-00163e068506";
//        bankcard.setAoid(aoid);
        bankcard.setRegisterName("bcd");
        String bankid = "ZGYH";
        bankcard.setBankid(bankid);
        String bankcardnum = "6226123456789012";
        bankcard.setBankcardnum(bankcardnum);
        String accountperson = "bcd";
        bankcard.setAccountperson(accountperson);
        log.debug(bankcard);

        BaseResp resp = agentService.chkAgentBankcard(bankcard);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
//
//        resp = agentService.editAgentBankcard(bankcard);
//        log.debug(resp);
//        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
//
//        resp = agentService.queryAgentBankcard(bankcard);
//        log.debug(resp);
//        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
//        bankcard.setAoid(aoid);
//        bankcard.setBankid("ZSYH");
//        bankcard.setBankcardnum("6226123456789012345");
//        bankcard.setAccountperson(accountperson);
//        resp = agentService.editAgentBankcard(bankcard);
//        log.debug(resp);
//        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
//
//        resp = agentService.delAgentBankcard(bankcard.getOid());
//        log.debug(resp);
//        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }
}
