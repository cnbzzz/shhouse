package cn.jufangbao.house.shhouse.utils;

import cn.jufangbao.house.shhouse.wechat.resp.msg.BaseRespMsg;
import cn.jufangbao.house.shhouse.wechat.resp.msg.NewsRespMsg;
import cn.jufangbao.house.shhouse.wechat.resp.msg.TxtRespMsg;
import cn.jufangbao.house.shhouse.wechat.resp.msg.news.NewsArticle;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * FreeMarkerUtils.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:44:36.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class FreeMarkerUtils {

    private static Logger log = LogManager.getLogger();

    private static Configuration CFG = new Configuration(Configuration.VERSION_2_3_25);

    static {
        CFG.setDefaultEncoding("UTF-8");
        ClassTemplateLoader classTemplateLoader = new ClassTemplateLoader(FreeMarkerUtils.class, "/wechat/resp");
        CFG.setTemplateLoader(classTemplateLoader);
    }

    public static String writeTxt(TxtRespMsg msg) {
        return write(msg, "text.ftl");
    }

    public static String writeNews(NewsRespMsg msg) {
        return write(msg, "news.ftl");
    }

    public static String write(BaseRespMsg msg, String ftlName) {
        try{
            Template template = CFG.getTemplate(ftlName);

            Writer out = new StringWriter();
            template.process(msg, out);
            return out.toString();
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return "";
        }
    }

    public static void main(String[] args) {
        NewsRespMsg msg = new NewsRespMsg();
        msg.setFromUserName("vcvv");
        msg.setToUserName("ddd");
        List<NewsArticle> list = new ArrayList<>();
        NewsArticle a = new NewsArticle();
        a.setTitle("123");
        NewsArticle b = new NewsArticle();
        b.setTitle("ewew");
        list.add(a);
        list.add(b);
        msg.setArticles(list);
        System.err.println(writeNews(msg));
    }
}
