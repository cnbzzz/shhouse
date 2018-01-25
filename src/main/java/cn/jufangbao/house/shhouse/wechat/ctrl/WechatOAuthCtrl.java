package cn.jufangbao.house.shhouse.wechat.ctrl;

import cn.jufangbao.house.shhouse.model.TCmCustomer;
import cn.jufangbao.house.shhouse.utils.TokenUtils;
import cn.jufangbao.house.shhouse.wechat.req.event.SubsScanClickEvent;
import cn.jufangbao.house.shhouse.wechat.service.WechatService;
import cn.jufangbao.house.shhouse.wechat.utils.WechatUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * cn.jufangbao.house.shhouse.wechat.ctrl
 * Created by bzzz on 2017-05-20 13:37.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */

@Controller
public class WechatOAuthCtrl {

    protected Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private WechatService wechatService;

    private enum MenuItem {
        ershoufang,
        zufang,
        woyaochuzu,
        woyaochushou,
        wodefangyuan,
        lianxijingjiren,
        dengluzhuce;

        public static MenuItem getMenuItem(String key) {
            return valueOf(key);
        }
    }

    @RequestMapping(value = "/wechatViewButtonHandler")
    public String wechatViewButtonHandler(@RequestParam("code") String code, @RequestParam("state") String state) {
        String openId = getOpenId(code);
        TCmCustomer customer = null;
        String token = "";
        if(StringUtils.isBlank(openId)){
            log.error("获取openId失败");
        } else{
            customer = wechatService.queryCustByWechatId(openId);
            if(customer != null){
                token = TokenUtils.encodeToken(customer.getOid());
            }
        }

        String path = "http://www.darunjia.cn";
        String str = wechatService.getStringFromProp("url." + state);
        if(StringUtils.isNotBlank(str)){
            path = String.format(str, token, openId);
        }

        switch (MenuItem.getMenuItem(state)){
            case wodefangyuan:
                if(StringUtils.isBlank(token)){//没有用户,跳转到登录页
                    path = "http://www.darunjia.cn/PC/login-check.html";
                }
                break;

            case lianxijingjiren:
                if(StringUtils.isBlank(token)){//没有用户,跳转到登录页
                    path = "http://www.darunjia.cn/PC/login-check.html";
                }
                break;

            case dengluzhuce:
                if(StringUtils.isBlank(token)){//没有用户,跳转到登录页
                    path = "http://www.darunjia.cn/PC/login-check.html";
                }
                break;
        }

        return "redirect:"+path;
    }

    private String getOpenId(@RequestParam("code") String code) {
        String getOpenIdUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        String appId = WechatUtils.getAppId();
        String appSecret = WechatUtils.getAppSecret();
        getOpenIdUrl = getOpenIdUrl.replace("APPID", appId);
        getOpenIdUrl = getOpenIdUrl.replace("SECRET", appSecret);
        getOpenIdUrl = getOpenIdUrl.replace("CODE", code);
        JSONObject jsonObject = WechatUtils.httpRequest(getOpenIdUrl, "POST", null);
        return jsonObject.getString("openid");
    }

}
