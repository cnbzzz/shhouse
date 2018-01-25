package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.main.Launcher;
import cn.jufangbao.house.shhouse.service.PublicService;
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
public class PublicServiceImplTest {

    Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private PublicService publicService;

    String recNum = "13527897960";

    @Test
    public void test1(){

        BaseResp resp = publicService.sendRandomcodeSms(recNum);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test2(){
        BaseResp resp = publicService.sendRandomcodeSms(recNum);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test3(){
        BaseResp resp = publicService.sendRandomcodeSms(recNum);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test4(){
        BaseResp resp = publicService.chkRandomCode(recNum, "685121");
        log.debug(resp);
        Assert.assertSame(BaseResp.FAIL, resp.getRetCode());
    }

    @Test
    public void test5(){
        BaseResp resp = publicService.chkRandomCode(recNum, "414954");
        log.debug(resp);
        Assert.assertSame(BaseResp.FAIL, resp.getRetCode());
    }

    @Test
    public void test6(){
        BaseResp resp = publicService.queryNewestVersion(1l);
        log.debug(resp);
//        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }
}
