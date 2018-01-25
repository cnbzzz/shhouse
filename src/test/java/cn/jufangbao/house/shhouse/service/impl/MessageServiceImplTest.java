package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.main.Launcher;
import cn.jufangbao.house.shhouse.model.TCmAgentMessage;
import cn.jufangbao.house.shhouse.websocket.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * cn.jufangbao.house.shhouse.service.impl
 * Created by bzzz on 2017-05-06 16:37.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Launcher.class)
@WebAppConfiguration
public class MessageServiceImplTest {

    Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private MessageService messageService;

    @Test
    public void test1(){
        BaseResp resp = messageService.markMessageReadByToUserId("234");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test2(){
        TCmAgentMessage message = new TCmAgentMessage();
        message.setFromuserid("123");
        message.setTouserid("234");
        message.setContent("你好啊...");
        log.debug(message);
        BaseResp resp = messageService.sendMessage(message);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test3(){
        BaseResp resp = messageService.queryUnreadMessageByToUserId("234");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test4(){
        BaseResp resp = messageService.countUnreadMessageByToUserId("234");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test5(){
        BaseResp resp = messageService.countUnreadMessageByToUserIdGroupByFromUserId("123");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test6(){
        BaseResp resp = messageService.queryHistoryMessage("1", "9e504b31-20c4-11e7-9a1f-00163e068506");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }
}
