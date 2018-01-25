package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.dto.HouseDetailDto;
import cn.jufangbao.house.shhouse.dto.HouseDto;
import cn.jufangbao.house.shhouse.dto.HouseQueryItemDto;
import cn.jufangbao.house.shhouse.main.Launcher;
import cn.jufangbao.house.shhouse.model.TSaImages;
import cn.jufangbao.house.shhouse.param.HouseQueryCondParam;
import cn.jufangbao.house.shhouse.service.HouseService;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21 0021.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Launcher.class)
@WebAppConfiguration
public class HouseServiceImplTest {

    Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private HouseService houseService;

    @Resource
    private PublicService publicService;

    @Test
    public void test1(){
        HouseQueryCondParam param = new HouseQueryCondParam();
        param.setDesc(1);
//        param.setOrderBy("recomindex");
        param.setAreaid("1");
//        param.setCounty("1");
//        param.setMetroline("1");
//        param.setMetroid("1");
//        param.setEndprice(100000000l);
//        param.setHlayoutlist(Arrays.asList("1"));
//        param.setOrilist(Arrays.asList("1"));
//        param.setEndarea(100000000l);
//        param.setHlabellist(Arrays.asList("1"));
//        param.setSeachstr("房");
        param.setPageNum(1);
        param.setPageSize(5);
        log.debug("param is {}", param);
        BaseResp<List<HouseDto>> resp = houseService.listHouseByCond(param);
        log.debug("resp is {}", resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test2() {
        BaseResp<Map<String, List<HouseQueryItemDto>>> resp = houseService.listHouseQueryItem();
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test3() {
        BaseResp<HouseDetailDto> resp = houseService.oneHouseDetail("cd254c85-274f-11e7-9a1f-00163e068506", "", "1");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test4(){
        BaseResp<TSaImages> resp = publicService.queryImagesById("1");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test5(){
        BaseResp<List<TSaImages>> resp = publicService.queryImagesByGroupId("1");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test6(){
        BaseResp<Map<String, HouseDto>> resp = houseService.houseCompare("1", "2");
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

    @Test
    public void test7(){
        BaseResp resp = houseService.queryStrPrompt("珠", 1l);
        log.debug(resp);
        Assert.assertSame(BaseResp.SUCC, resp.getRetCode());
    }

}
