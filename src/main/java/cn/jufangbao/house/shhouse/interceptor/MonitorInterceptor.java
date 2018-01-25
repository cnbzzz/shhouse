package cn.jufangbao.house.shhouse.interceptor;

import cn.jufangbao.house.shhouse.utils.IPUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MonitorInterceptor.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:40:06.
 * Human knowledge belongs to all mankind.
 */
public class MonitorInterceptor implements HandlerInterceptor {

    Logger log = LogManager.getLogger(this.getClass().getName());

    private Integer maxCount = 10000;

    private Integer currCount = 0;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        currCount++;
        if (currCount > maxCount) {
            currCount--;
            return false;
        }
        long stime = System.currentTimeMillis();
        String ip = IPUtils.getRealIP(req);
        String uri = req.getRequestURI();
        req.setAttribute("_stime", stime);
        req.setAttribute("_ip", ip);
        req.setAttribute("_uri", uri);
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Methods", "POST,GET");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object o, Exception e) throws Exception {
        long stime = (Long) req.getAttribute("_stime");
        String ip = (String) req.getAttribute("_ip");
        String uri = (String) req.getAttribute("_uri");
        long etime = System.currentTimeMillis();
        long ctime = etime - stime;
        String log4j2str = "IP[{}] request uri[{}] cost [{}]ms";
        log.debug(log4j2str, ip, uri, ctime);
        if (ctime > 500l) {//大于500毫秒请求
            log.warn(log4j2str, ip, uri, ctime);
        }
        currCount--;
    }
}
