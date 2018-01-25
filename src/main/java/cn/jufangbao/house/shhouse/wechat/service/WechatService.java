package cn.jufangbao.house.shhouse.wechat.service;

import cn.jufangbao.house.shhouse.model.TCmCustomer;
import cn.jufangbao.house.shhouse.model.TSaWechat;
import cn.jufangbao.house.shhouse.wechat.req.event.SubsScanClickEvent;
import cn.jufangbao.house.shhouse.wechat.utils.WechatMenu;
import cn.jufangbao.house.shhouse.wechat.utils.WechatQrcode;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * WechatService.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:52:53.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public interface WechatService {

    String service(Map<String, String> xml);

    String scanEvent(SubsScanClickEvent scan) throws Exception;

    TSaWechat foundWechat();

    boolean createMenu(WechatMenu menu);

    boolean kfMsgHandler(String toUser, String text);

    WechatQrcode getParamQrcode(String sceneId);

    TCmCustomer queryCustByWechatId(String openId);

    String getStringFromProp(String key);
}
