package cn.jufangbao.house.shhouse.wechat.service.impl;

import cn.jufangbao.house.shhouse.dto.CustFollowCountDto;
import cn.jufangbao.house.shhouse.dto.CustSellerCountDto;
import cn.jufangbao.house.shhouse.dto.HouseCountDto;
import cn.jufangbao.house.shhouse.mapper.*;
import cn.jufangbao.house.shhouse.model.TCmAgent;
import cn.jufangbao.house.shhouse.model.TCmAgentCust;
import cn.jufangbao.house.shhouse.model.TCmCustomer;
import cn.jufangbao.house.shhouse.model.TSaWechat;
import cn.jufangbao.house.shhouse.utils.CommUtils;
import cn.jufangbao.house.shhouse.utils.FreeMarkerUtils;
import cn.jufangbao.house.shhouse.utils.IdUtils;
import cn.jufangbao.house.shhouse.utils.TokenUtils;
import cn.jufangbao.house.shhouse.wechat.req.event.BaseEvent;
import cn.jufangbao.house.shhouse.wechat.req.event.SubsScanClickEvent;
import cn.jufangbao.house.shhouse.wechat.req.msg.BaseReqMsg;
import cn.jufangbao.house.shhouse.wechat.resp.msg.NewsRespMsg;
import cn.jufangbao.house.shhouse.wechat.resp.msg.TxtRespMsg;
import cn.jufangbao.house.shhouse.wechat.resp.msg.news.NewsArticle;
import cn.jufangbao.house.shhouse.wechat.service.WechatService;
import cn.jufangbao.house.shhouse.wechat.utils.WechatAccessToken;
import cn.jufangbao.house.shhouse.wechat.utils.WechatMenu;
import cn.jufangbao.house.shhouse.wechat.utils.WechatQrcode;
import cn.jufangbao.house.shhouse.wechat.utils.WechatUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

/**
 * WechatServiceImpl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:52:51.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class WechatServiceImpl implements WechatService {

    private Logger log = LogManager.getLogger();

    @Resource
    private TCmCustomerMapper customerMapper;

    @Resource
    private TCmAgentMapper agentMapper;

    @Resource
    private TCmAgentCustMapper agentCustMapper;

    @Resource
    private TSaWechatMapper wechatMapper;

    @Resource
    private TResHouseMapper houseMapper;

    private static TSaWechat WECHAT = null;

    private static Properties PROP = null;

    private String platformNum = getStringFromProp("msg.platformNum");

    private String noAgentMsg = String.format(getStringFromProp("msg.noAgentMsg"), platformNum);

    public WechatServiceImpl() {
        String isScanAccessToken = getStringFromProp("wechat.isscanaccesstoken");
        if("1".equals(isScanAccessToken)){
            accessTokenTask();
        }
    }

    private void accessTokenTask() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
            log.info("start accessTokenTask");
            WECHAT = foundWechat();
            log.info("end accessTokenTask");
            }
        };

        Timer timer = new Timer();

        long delay = 1000 * 3600;//3600秒执行一次,微信tokenid失效时间是7200秒
        long period = 1000 * 60;//第一次延迟60秒执行
        timer.schedule(timerTask, delay, period);
    }

    public TSaWechat foundWechat() {
        TSaWechat tSaWechat = null;
        try {
            tSaWechat = wechatMapper.foundWechat();
            if (tSaWechat == null) {
                tSaWechat = new TSaWechat();
                String appId = WechatUtils.getAppId();
                tSaWechat.setAppid(appId);
                String appSecret = WechatUtils.getAppSecret();
                tSaWechat.setSecret(appSecret);
                tSaWechat.setAuthtoken(WechatUtils.getAppToken());
                WechatAccessToken accessToken = WechatUtils.getAccessToken(appId, appSecret);
                Preconditions.checkArgument(accessToken != null, "get accesstoken fail");
                tSaWechat.setAccesstoken(accessToken.getToken());
                Date stime = new Date();
                tSaWechat.setStime(stime);
                tSaWechat.setEtime(DateUtils.addSeconds(stime, 7200));//accessToken 7200秒失败
                tSaWechat.setStatus(1);
                wechatMapper.insertSelective(tSaWechat);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return tSaWechat;
    }

    private TSaWechat getWechat() {
        if (WECHAT == null) {
            WECHAT = foundWechat();
        }
        return WECHAT;
    }

    private WechatMenu readWechatMenu() {
        WechatMenu wechatMenu = null;
        try {
            URL url = WechatUtils.class.getResource("/wechat/wechatmenu.json");
            File file = new File(url.toURI());
            String json = FileUtils.readFileToString(file, "UTF-8");
            wechatMenu = JSON.parseObject(json, WechatMenu.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return wechatMenu;
    }

    public boolean createMenu(WechatMenu menu) {
        String menuCreateUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
        TSaWechat wechat = getWechat();
        String url = menuCreateUrl.replace("ACCESS_TOKEN", wechat.getAccesstoken());
        if (menu == null) {
            menu = readWechatMenu();
        }
        String jsonMenu = JSONObject.toJSONString(menu);
        log.info("jsonMenu is {}", jsonMenu);
        // 调用接口创建菜单
        JSONObject jsonObject = WechatUtils.httpRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            if (0 != jsonObject.getIntValue("errcode")) {
                log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            } else {
                return true;
            }
        }
        return false;
    }


    public WechatQrcode getParamQrcode(String sceneId) {
        String paramQrcode = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
        String accessToken = getWechat().getAccesstoken();
        String param = String.format("{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %s}}}", sceneId);
        String url = paramQrcode.replace("ACCESS_TOKEN", accessToken);

        // 调用参数二维码
        JSONObject jsonObject = WechatUtils.httpRequest(url, "POST", param);
        if ((null != jsonObject) && (0 != jsonObject.getIntValue("errcode"))) { //失败
            log.error("创建带参数二维码失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            return null;
        }
        WechatQrcode qrcode = new WechatQrcode();
        String ticket = jsonObject.getString("ticket");
        qrcode.setQrcodeTicket(ticket);
        String qrcodePath = String.format("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s", ticket);
        qrcode.setQrcodePath(qrcodePath);
        return qrcode;
    }

    public JSONObject getUserInfoUrl(String openId) {
        if (StringUtils.isBlank(openId)) {
            log.error("openId为空");
            return null;
        }
        String userInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        String accessToken = getWechat().getAccesstoken();
        String url = userInfoUrl.replace("ACCESS_TOKEN", accessToken);
        url = url.replace("OPENID", openId);

        // 调用参数二维码
        JSONObject jsonObject = WechatUtils.httpRequest(url, "GET", null);
        if ((null != jsonObject) && (0 != jsonObject.getIntValue("errcode"))) { //失败
            log.error("获取用户信息失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            return null;
        }
        return jsonObject;
    }


    public JSONObject getOnlineKf() {
        String onlineKflist = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=ACCESS_TOKEN";
        String accessToken = getWechat().getAccesstoken();
        // 拼装创建菜单的url
        String url = onlineKflist.replace("ACCESS_TOKEN", accessToken);

        // 调用接口创建菜单
        JSONObject jsonObject = WechatUtils.httpRequest(url, "POST", null);

        if ((null != jsonObject) && (0 != jsonObject.getIntValue("errcode"))) { //失败
            log.error("获取在线客服失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            return null;
        }
        return jsonObject;
    }


    public boolean kfMsgHandler(String toUser, String text) {
        Preconditions.checkArgument(StringUtils.isNotBlank(toUser), "用户帐号为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(text), "发送内容为空");
        String param = String.format("{\"touser\":\"%s\",\"msgtype\":\"text\",\"text\":{ \"content\":\"%s\"}}", toUser, text);
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
        String accessToken = getWechat().getAccesstoken();
        // 拼装创建菜单的url
        url = url.replace("ACCESS_TOKEN", accessToken);
        // 调用接口创建菜单
        JSONObject jsonObject = WechatUtils.httpRequest(url, "POST", param);

        if ((null != jsonObject)) { //失败
            if ((0 == jsonObject.getIntValue("errcode"))) {
                return true;
            } else {
                log.error("调用客服接口失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return false;
    }

    public String service(Map<String, String> xmlMap) {
        log.info("param is {}", JSON.toJSONString(xmlMap));
        String resp = "";
        try {
            String msgType = xmlMap.get("MsgType");
            Preconditions.checkArgument(StringUtils.isNotBlank(msgType), "msgType is null");
            switch (BaseReqMsg.ReqMsgType.getReqMsgType(msgType)) {
                case event://事件
                    resp = eventHandler(xmlMap);
                    break;
                default:
                    resp = msgHandler(xmlMap);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            TxtRespMsg msg = new TxtRespMsg();
            try {
                BeanUtils.populate(msg, xmlMap);
            } catch (Exception ex) {
                log.error(e.getMessage(), ex);
            }
            String errMsg = getStringFromProp("msg.error");
            msg.setContent(String.format(errMsg, platformNum));
            resp = FreeMarkerUtils.writeTxt(msg);
        } finally {
            log.info("resp is {}", resp);
        }
        return resp;
    }

    public String msgHandler(Map<String, String> xmlMap) throws Exception {
        TxtRespMsg msg = new TxtRespMsg();
        BeanUtils.populate(msg, xmlMap);
        String resp = getStringFromProp("msg.default.resp");
        msg.setContent(String.format(resp, platformNum));
        return FreeMarkerUtils.writeTxt(msg);
    }

    public String eventHandler(final Map<String, String> xmlMap) throws Exception {
        TxtRespMsg msg = new TxtRespMsg();
        BeanUtils.populate(msg, xmlMap);
        String event = xmlMap.get("Event");
        switch (BaseEvent.EventType.getEventType(event)) {
            case subscribe://订阅和扫描带参数的二维码（未关注）
                String ticket = xmlMap.get("Ticket");
                if (StringUtils.isNotBlank(ticket)) {//扫描代参数的二维码关注
                    SubsScanClickEvent scan = new SubsScanClickEvent();
                    BeanUtils.populate(scan, xmlMap);
                    return scanEvent(scan);
                }
                msg.setContent(getStringFromProp("msg.thxsubs"));
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        kfMsgHandler(xmlMap.get("fromUserName"), noAgentMsg);
                    }
                };
                runnable.run();
                break;
            case unsubscribe://订阅
                return "";
            case SCAN://扫描带参数的二维码（已关注）
                SubsScanClickEvent scan = new SubsScanClickEvent();
                BeanUtils.populate(scan, xmlMap);
                return scanEvent(scan);
            case CLICK:
                SubsScanClickEvent click = new SubsScanClickEvent();
                BeanUtils.populate(click, xmlMap);
                return clickEvent(click);
            default:
                String desc = getStringFromProp("msg.default");
                msg.setContent(desc);
        }
        return FreeMarkerUtils.writeTxt(msg);
    }

    public String clickEvent(SubsScanClickEvent click) throws Exception {
        String resp = "";
        switch (SubsScanClickEvent.EventKey.getEventKey(click.getEventKey())) {
            case ershoufang:
                resp = houseHandler(click, "0");
                break;
            case zufang:
                resp = houseHandler(click, "1");
                break;
            case woyaochushou:
                resp = saleOrRentHandler(click);
                break;
            case woyaochuzu:
                resp = saleOrRentHandler(click);
                break;
            case wodefangyuan:
                resp = myHouseHandler(click);
                break;
            case yikanfangyuan:
                resp= myBrowseHandler(click);
                break;
            case guanzhufangyuan:
                resp = myFollowHandler(click);
                break;
            case dianhuazixun:
                String eventKey = click.getEventKey();
                String content = getMsgByEventKey(eventKey);
                String desc = String.format(content, platformNum);
                TxtRespMsg respMsg = getDefaultTxtRespMsg(click, desc);
                resp = FreeMarkerUtils.writeTxt(respMsg);
                break;
            case lianxijingjiren:
                resp = myAgentHandler(click);
                break;
            default:
                break;
        }
        return resp;
    }

    private String saleOrRentHandler(SubsScanClickEvent clickEvent) throws Exception {
        TxtRespMsg respMsg = getDefaultTxtRespMsg(clickEvent, "");
        String openId = clickEvent.getFromUserName();
        TCmCustomer tCmCustomer = queryCustByWechatId(openId);
        if (tCmCustomer != null) {
            return getNewsMsg(clickEvent, openId, tCmCustomer, 1l);
        }
        return FreeMarkerUtils.writeTxt(respMsg);
    }

    private String houseHandler(SubsScanClickEvent clickEvent, String rent) throws Exception {
        TxtRespMsg respMsg = getDefaultTxtRespMsg(clickEvent, "");
        String openId = clickEvent.getFromUserName();
        TCmCustomer tCmCustomer = queryCustByWechatId(openId);
        if (tCmCustomer != null) {
            HouseCountDto count = houseMapper.countHouse();
            Long salecount = count.getSalecount();
            Long sellcount = count.getSellcount();
            Long total = count.getSaletotal();
            if("1".equals(rent)){
                salecount = count.getRentcount();
                sellcount = count.getRentedcount();
                total = count.getRenttotal();
            }

            return getNewsMsg(clickEvent, openId, tCmCustomer, 1l, salecount, sellcount, total);
        }
        return FreeMarkerUtils.writeTxt(respMsg);
    }

    private String getTitleByEventKey(String eventKey) {
        return getStringByPrefixAndEventKey("title", eventKey);
    }

    private String getMsgByEventKey(String eventKey) {
        return getStringByPrefixAndEventKey("msg", eventKey);
    }

    private String getUrlByEventKey(String eventKey) {
        return getStringByPrefixAndEventKey("url", eventKey);
    }

    public String getStringFromProp(String key){
        if(PROP == null){
            PROP = CommUtils.loadProp("/wechat/wechat.properties");
        }
        return PROP.getProperty(key, "");
    }

    private String getStringByPrefixAndEventKey(String prefix, String eventKey) {
        return getStringFromProp(prefix+"."+eventKey);
    }

    private TxtRespMsg getDefaultTxtRespMsg(SubsScanClickEvent clickEvent, String msg) throws IllegalAccessException, InvocationTargetException {
        TxtRespMsg respMsg = new TxtRespMsg();
        BeanUtils.copyProperties(respMsg, clickEvent);
        if(StringUtils.isBlank(msg)){
            msg = noAgentMsg;
        }
        respMsg.setContent(msg);
        return respMsg;
    }

    public TCmCustomer queryCustByWechatId(String openId) {
        TCmCustomer custParam = new TCmCustomer();
        custParam.setWechatid(openId);
        return customerMapper.selectOne(custParam);
    }

    private String myHouseHandler(SubsScanClickEvent clickEvent) throws Exception {
        TxtRespMsg respMsg = getDefaultTxtRespMsg(clickEvent, "");
        String openId = clickEvent.getFromUserName();
        TCmCustomer tCmCustomer = queryCustByWechatId(openId);
        if (tCmCustomer != null) {
            String oid = tCmCustomer.getOid();
            CustSellerCountDto countDto = customerMapper.countSeller(oid);
            Long total = countDto.getTotal();
            Long salecount = countDto.getSalecount();
            Long rentcount = countDto.getRentcount();
            Long sellcount = countDto.getSellcount();
            Long rentedcount = countDto.getRentedcount();
            return getNewsMsg(clickEvent, openId, tCmCustomer, total, salecount, rentcount, sellcount, rentedcount, total);
        }
        return FreeMarkerUtils.writeTxt(respMsg);
    }

    private String getSingleNewsMsg(SubsScanClickEvent clickEvent, String title, String desc, String url, String picUrl) throws IllegalAccessException, InvocationTargetException {
        NewsArticle news = new NewsArticle();
        news.setTitle(title);
        news.setDesc(desc);
        if(StringUtils.isNotBlank(url)){
            news.setUrl(url);
        }
        if(StringUtils.isNotBlank(picUrl)){
            news.setUrl(picUrl);
        }
        NewsRespMsg newsRespMsg = new NewsRespMsg();
        BeanUtils.copyProperties(newsRespMsg, clickEvent);
        List<NewsArticle> list = new ArrayList<>();
        list.add(news);
        newsRespMsg.setArticles(list);
        return FreeMarkerUtils.writeNews(newsRespMsg);
    }

    private String myFollowHandler(SubsScanClickEvent clickEvent) throws Exception {
        TxtRespMsg respMsg = getDefaultTxtRespMsg(clickEvent, "");
        String openId = clickEvent.getFromUserName();
        TCmCustomer tCmCustomer = queryCustByWechatId(openId);
        if (tCmCustomer != null) {
            String oid = tCmCustomer.getOid();
            CustFollowCountDto dto = customerMapper.countCustFollow(oid);
            Long salecount = dto.getSalecount();
            Long rentcount = dto.getRentcount();
            Long commcount = dto.getCommcount();
            Long total = dto.getTotalcount();
            return getNewsMsg(clickEvent, openId, tCmCustomer, total, salecount, rentcount, commcount);
        }
        return FreeMarkerUtils.writeTxt(respMsg);
    }

    private String getNewsMsg(SubsScanClickEvent clickEvent, String openId, TCmCustomer tCmCustomer, Long total, Object... param) throws UnsupportedEncodingException, IllegalAccessException, InvocationTargetException {
        String eventKey = clickEvent.getEventKey();
        String title = String.format(getTitleByEventKey(eventKey), tCmCustomer.getName());
        String content = getMsgByEventKey(eventKey);
        String desc = String.format(content, param);
        String token = TokenUtils.encodeToken(tCmCustomer.getOid());
        String wechatId = openId;
        String url = String.format(getUrlByEventKey(eventKey), token, wechatId);
        if(total == 0){
            url = "";
        }
        return getSingleNewsMsg(clickEvent, title, desc, url, null);
    }

    private String myBrowseHandler(SubsScanClickEvent clickEvent) throws Exception {
        TxtRespMsg respMsg = getDefaultTxtRespMsg(clickEvent, "");
        String openId = clickEvent.getFromUserName();
        TCmCustomer tCmCustomer = queryCustByWechatId(openId);
        if (tCmCustomer != null) {
            String oid = tCmCustomer.getOid();
            Long total = customerMapper.countCustBrowse(oid);
            return getNewsMsg(clickEvent, openId, tCmCustomer, total, total);
        }
        return FreeMarkerUtils.writeTxt(respMsg);
    }


    private String myAgentHandler(SubsScanClickEvent clickEvent) throws Exception {
        TxtRespMsg respMsg = getDefaultTxtRespMsg(clickEvent, "");
        String openId = clickEvent.getFromUserName();
        TCmCustomer tCmCustomer = queryCustByWechatId(openId);
        if (tCmCustomer != null) {
            String founder = tCmCustomer.getFounder();
            if (StringUtils.isNotBlank(founder)) {
                TCmAgent agentParam = new TCmAgent();
                agentParam.setOid(founder);
                TCmAgent agent = agentMapper.selectOne(agentParam);
                if (agent != null) {
                    Date date = tCmCustomer.getCreatedate();
                    String str = CommUtils.timestamp2str(date);
                    String eventKey = clickEvent.getEventKey();
                    String content = getMsgByEventKey(eventKey);
                    String desc = String.format(content, tCmCustomer.getName(), str, agent.getName(), agent.getPhonenum());
                    respMsg.setContent(desc);
//                    String title = String.format("尊敬的 %s", tCmCustomer.getName());
//                    String desc = String.format("您已在 %s 绑定经纪人\n\n经纪人工号：%s\n经纪人姓名：%s\n经纪人电话：%s\n\n您也可以直接发送微信消息，经纪人会尽快回复您", str, agent.getWorknum(), agent.getName(), agent.getPhonenum());
//                    return getSingleNewsMsg(clickEvent, title, desc);
                }
            }
        }
        return FreeMarkerUtils.writeTxt(respMsg);
    }

    public String scanEvent(SubsScanClickEvent scan) throws Exception {
        Preconditions.checkArgument(scan != null, "参数为空");
        String ticket = scan.getTicket();
        Preconditions.checkArgument(StringUtils.isNotBlank(ticket), "ticket为空");
        TCmAgent agentParam = new TCmAgent();
        agentParam.setQrcodeticket(ticket);
        TCmAgent tCmAgent = agentMapper.selectOne(agentParam);
        Preconditions.checkArgument(tCmAgent != null, "ticket查询经纪人失败,tickid[%s]", ticket);

        String openId = scan.getFromUserName();
        Preconditions.checkArgument(StringUtils.isNotBlank(openId), "openId为空");
        TCmCustomer tCmCustomer = queryCustByWechatId(openId);
        TxtRespMsg respMsg = new TxtRespMsg();
        BeanUtils.copyProperties(respMsg, scan);
        String aoid = tCmAgent.getOid();
        String coid = null;
        if (tCmCustomer != null) {
            String founder = tCmCustomer.getFounder();
            coid = tCmCustomer.getOid();
            if (StringUtils.isBlank(founder)) { // 没有经纪人，就设置这个经纪人
                tCmCustomer.setFounder(aoid);
                customerMapper.updateByPrimaryKeySelective(tCmCustomer);
            }
        } else {
            JSONObject userJSON = getUserInfoUrl(openId);
            Preconditions.checkArgument(userJSON != null, "获取用户信息失败%s", openId);
            tCmCustomer = new TCmCustomer();
            tCmCustomer.setWechatid(userJSON.getString("openid"));//加密的微信号
            tCmCustomer.setName(userJSON.getString("nickname"));//昵称
            tCmCustomer.setSex(userJSON.getString("sex"));//性别, 0未知1男2女
            tCmCustomer.setIpath(userJSON.getString("headimgurl"));//微信头像
//          userJSON.getString("subscribe_time");//关注时间
            tCmCustomer.setFounder(aoid);
            System.currentTimeMillis();
            tCmCustomer.setCreatedate(new Date());
            tCmCustomer.setStatus(1);
            coid = IdUtils.UUID();
            tCmCustomer.setOid(coid);
            customerMapper.insertSelective(tCmCustomer);
        }

        TCmAgentCust agentCust = new TCmAgentCust();
        agentCust.setCoid(coid);
        agentCust.setAoid(aoid);

        List<TCmAgentCust> select = agentCustMapper.select(agentCust);
        if(select.size() == 0){ //还没绑定该经纪人
            agentCust.setOid(IdUtils.UUID());
            agentCust.setStatus(1);
            agentCust.setCreatedate(new Date());
            agentCust.setCusttype("0"); //未知
            agentCustMapper.insertSelective(agentCust);
        } else{ //已绑定该经纪人
            agentCust = select.get(0);
        }

        Date date = agentCust.getCreatedate();
        String str = CommUtils.timestamp2str(date);
        String eventKey = scan.getEvent();
        String content = getMsgByEventKey(eventKey);
        String desc = String.format(content, tCmCustomer.getName(), str, tCmAgent.getName(), tCmAgent.getPhonenum());
        respMsg.setContent(desc);
        return FreeMarkerUtils.writeTxt(respMsg);
    }

}
