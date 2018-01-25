package cn.jufangbao.house.shhouse.wechat.resp.msg;

/**
 * TxtRespMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:45:39.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class TxtRespMsg extends BaseRespMsg {

    private String msgType = RespMsgType.text.name();

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
