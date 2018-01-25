package cn.jufangbao.house.shhouse.wechat.ctrl;

import cn.jufangbao.house.shhouse.model.TCmCustomer;
import cn.jufangbao.house.shhouse.model.TSaWechat;
import cn.jufangbao.house.shhouse.utils.TokenUtils;
import cn.jufangbao.house.shhouse.wechat.req.event.SubsScanClickEvent;
import cn.jufangbao.house.shhouse.wechat.req.msg.BaseReqMsg;
import cn.jufangbao.house.shhouse.wechat.service.WechatService;
import cn.jufangbao.house.shhouse.wechat.utils.WechatUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

import static cn.jufangbao.house.shhouse.wechat.req.event.SubsScanClickEvent.EventKey.ershoufang;

/**
 * WechatCtrl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:45:05.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
@RestController
public class WechatCtrl {

    protected Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private WechatService wechatService;

    @RequestMapping(value = "/wechat", method = RequestMethod.GET)
    public String connect(String signature// 微信加密签名
            , String timestamp // 时间戳
            , String nonce // 随机数
            , String echostr // 随机字符串
    ) {
        TSaWechat saWechat = wechatService.foundWechat();
        String authtoken = saWechat.getAuthtoken();
        if (WechatUtils.checkConnect(authtoken, signature, timestamp, nonce)) {
            return echostr;
        }
        return "";
    }

    @RequestMapping(value = "/wechat", method = RequestMethod.POST)
    public String msg(
            @RequestParam(value = "msg_signature", required = false) String msg_signature //加密签名，如果加密则有值
            , String timestamp //时间戳
            , String nonce //随机数
            , String echostr //随机字符串
            , @RequestBody String msg //消息xml
    ) throws Exception {
        log.debug("param is {}", msg);
        if (StringUtils.isNotBlank(msg_signature)) {//加密后字符串，暂时不考虑

        }
        Map<String, String> xmlMap = WechatUtils.xmlToMap(msg);
        String resp = wechatService.service(xmlMap);
        log.debug("resp is {}", resp);
        return resp;
    }

    @ExceptionHandler
    public String exception(Exception e) {
        log.error("error:{}", e);
        // 根据不同错误转向不同页面
        return "";
    }

}
