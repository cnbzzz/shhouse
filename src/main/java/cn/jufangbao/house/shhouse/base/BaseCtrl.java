package cn.jufangbao.house.shhouse.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * BaseCtrl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:35:09.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class BaseCtrl {

    protected Logger log = LogManager.getLogger(this.getClass().getName());

    @ExceptionHandler
    public String exception(Exception e) {
        log.error("error:{}", e);
        // 根据不同错误转向不同页面
        return BaseResp.failResp("服务器忙，请稍后再试").toString();
    }
}
