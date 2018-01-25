package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.dto.*;
import cn.jufangbao.house.shhouse.main.Launcher;
import cn.jufangbao.house.shhouse.model.*;
import cn.jufangbao.house.shhouse.service.CustomerService;
import cn.jufangbao.house.shhouse.utils.TokenUtils;
import com.google.common.collect.Lists;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/3/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Launcher.class)
@WebAppConfiguration
public class CustomerServiceImplTest {

    Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private CustomerService customerService;

    @Test
    public void test1() {
        BaseResp resp = customerService.custSignIn(13800138001l, "eee", "");
        log.debug(resp);
        Assert.assertSame(BaseResp.FAIL, resp.getRetCode());
    }

    @Test
    public void test2() {
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
        BaseResp resp = customerService.editHouseWaitingByCust("1", houseWaiting);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test3() {
        BaseResp<List<CustSellerDto>> resp = customerService.listSellerHouse("c62cf790-8f0e-43ea-b2e8-3cb1d2a6e7b1", "");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test4() {
        BaseResp<List<CustFollowHouseDto>> resp = customerService.listCustFollowHouse("1", "1");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
        resp = customerService.listCustFollowHouse("1", "2");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test5() {
        BaseResp<List<CustSeenDto>> resp = customerService.listCustSeenHouse("c62cf790-8f0e-43ea-b2e8-3cb1d2a6e7b1");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test6() {
        TCmCustFollow param = new TCmCustFollow();
        param.setFollow("1");
        param.setFollowtype("1");
        log.debug(param);
        BaseResp resp = customerService.addCustFollow("1", param);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());

        param.setFollow("2333");
        resp = customerService.addCustFollow("1", param);
        log.debug(resp);
        Assert.assertSame(BaseResp.FAIL, resp.getRetCode());
    }

    @Test
    public void test7() {
        CustDetailDto param = new CustDetailDto();
        param.setName("aaa");
        param.setPasswd("bbb");
        param.setIpath("http://120.76.53.1/img/face.jpg");
        param.setStatus(1);

        param.setLableIdList(Arrays.asList("1", "2", "3"));

        long phonenum = 13912345679l;
        param.setPhonenum(phonenum);
        log.debug(param);
        BaseResp resp = customerService.editCustomer(param);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());

//        String oid = param.getOid();
//        param = new CustDetailDto();
//        param.setOid(oid);
//        param.setPasswd("ccc");
//        param.setLableIdList(Arrays.asList("3"));
//        log.debug(param);
//        resp = customerService.editCustomer(param);
//        log.debug(resp);
//        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test8() {
        BaseResp<List<CustBookingDto>> resp = customerService.listCustBooking("1", null);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test9() {
        BaseResp<List<HouseDto>> resp = customerService.listBuyerDeal("1", null);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }


    @Test
    public void test10() {
        BaseResp<List<HouseDto>> resp = customerService.listSellerDeal("c62cf790-8f0e-43ea-b2e8-3cb1d2a6e7b1", null);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test11() {
        TCmCustFollow param = new TCmCustFollow();
        param.setFollow("1");
        param.setFollowtype("1");
        log.debug(param);
        BaseResp resp = customerService.addCustFollow("1", param);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());

        resp = customerService.listCustFollowHouse("1", "2");
        log.debug(resp);

        resp = customerService.delCustFollow("1", param);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test12() {
        BaseResp resp = customerService.custForgetPasswd(15915864285l);
        log.debug(resp);
        Assert.assertSame(BaseResp.FAIL, resp.getRetCode());
    }

    @Test
    public void test13() {
        long phoneNum = 13812345678l;
        String newPasswd = "123456";
        BaseResp resp = customerService.editCustPasswd(phoneNum, newPasswd);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());

        resp = customerService.custSignIn(phoneNum, newPasswd, "");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test14() {
        BaseResp resp = customerService.listCustFollowComm("1");
        System.err.println(TokenUtils.encodeToken("1"));
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test15() {
        String coid = "c62cf790-8f0e-43ea-b2e8-3cb1d2a6e7b1";
        BaseResp resp = customerService.listCustAgent(coid);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test16() {
        String coid = "163bc6c2-28bf-11e7-9a1f-00163e068506";
        BaseResp resp = customerService.oneCust(coid);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test17() {
        CustDetailDto param = new CustDetailDto();
        param.setOid("1");
        param.setName("爱爱123");
        BaseResp resp = customerService.editCustomer(param);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test18() {
        BaseResp resp = customerService.editCustPasswd(13798144369l, "123");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test19() {
        BaseResp resp = customerService.queryCustomerByPhoneNum(13798144369l);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }
}
