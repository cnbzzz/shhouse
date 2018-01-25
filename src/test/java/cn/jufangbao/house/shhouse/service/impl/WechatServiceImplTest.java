package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.main.Launcher;
import cn.jufangbao.house.shhouse.mapper.TCmCustomerMapper;
import cn.jufangbao.house.shhouse.model.TCmCustomer;
import cn.jufangbao.house.shhouse.utils.IdUtils;
import cn.jufangbao.house.shhouse.wechat.service.WechatService;
import cn.jufangbao.house.shhouse.wechat.utils.WechatQrcode;
import cn.jufangbao.house.shhouse.wechat.utils.WechatUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/9 0009.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Launcher.class)
@WebAppConfiguration
public class WechatServiceImplTest {

    Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private WechatService wechatService;

    @Test
    public void test1(){
        wechatService.kfMsgHandler("opzP1vtfh2mfQMqauQDt4rl4jZMk", "嘎嘎嘎嘎");
    }

    @Test
    public void test2(){
        wechatService.createMenu(null);
    }

    @Test
    public void yikanfangyuan() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>1490171522</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[CLICK]]></Event>\n" +
                "<EventKey><![CDATA[yikanfangyuan]]></EventKey>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void guanzhufangyuan() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>1490171522</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[CLICK]]></Event>\n" +
                "<EventKey><![CDATA[guanzhufangyuan]]></EventKey>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void wodefangyuan() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>1490171522</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[CLICK]]></Event>\n" +
                "<EventKey><![CDATA[wodefangyuan]]></EventKey>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void dianhuazixun() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>1490171522</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[CLICK]]></Event>\n" +
                "<EventKey><![CDATA[dianhuazixun]]></EventKey>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void ershoufang() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>1490171522</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[CLICK]]></Event>\n" +
                "<EventKey><![CDATA[ershoufang]]></EventKey>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void zufang() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>1490171522</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[CLICK]]></Event>\n" +
                "<EventKey><![CDATA[zufang]]></EventKey>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void woyaochushou() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>1490171522</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[CLICK]]></Event>\n" +
                "<EventKey><![CDATA[woyaochushou]]></EventKey>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void lianxijingjiren() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>1490171522</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[CLICK]]></Event>\n" +
                "<EventKey><![CDATA[lianxijingjiren]]></EventKey>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void test12() throws Exception {
        String xml = "<xml>\n" +
                "<ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>123456789</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[subscribe]]></Event>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void test13() throws Exception {
        String xml = "<xml>\n" +
                "<ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>123456789</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[SCAN]]></Event>\n" +
                "<EventKey><![CDATA[SCENE_VALUE]]></EventKey>\n" +
                "<Ticket><![CDATA[gQGR8TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyMW5VRDhNRFBiUi0xMDAwMHcwMzcAAgQrGMlYAwQAAAAA]]></Ticket>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void test14() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>123456789</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[subscribe]]></Event>\n" +
                "<EventKey><![CDATA[qrscene_123123]]></EventKey>\n" +
                "<Ticket><![CDATA[gQGR8TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyMW5VRDhNRFBiUi0xMDAwMHcwMzcAAgQrGMlYAwQAAAAA]]></Ticket>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void test15() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_c0968e208904]]></ToUserName>\n" +
                "<FromUserName><![CDATA[opzP1vtfh2mfQMqauQDt4rl4jZMk]]></FromUserName>\n" +
                "<CreateTime>1490171522</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[CLICK]]></Event>\n" +
                "<EventKey><![CDATA[woyaochuzu]]></EventKey>\n" +
                "</xml>";
        Map<String, String> xmlMap = WechatUtils.xmlToMap(xml);
        String resp = wechatService.service(xmlMap);
        System.err.println(resp);
    }

    @Test
    public void test16(){
        WechatQrcode qrcode = wechatService.getParamQrcode("37883df9-2030-11e7-9a1f-00163e068506");
        System.err.println(JSONObject.toJSONString(qrcode));
    }
}
