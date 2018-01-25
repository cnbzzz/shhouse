package cn.jufangbao.house.shhouse.wechat.resp.msg;

import cn.jufangbao.house.shhouse.wechat.resp.msg.news.NewsArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * NewsRespMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:46:25.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class NewsRespMsg extends BaseRespMsg {

    private String msgType = RespMsgType.news.name();

    private List<NewsArticle> articles;

    public List<NewsArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsArticle> articles) {
        this.articles = articles;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
