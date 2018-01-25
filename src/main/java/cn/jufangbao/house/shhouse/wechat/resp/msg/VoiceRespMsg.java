package cn.jufangbao.house.shhouse.wechat.resp.msg;

/**
 * VoiceRespMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:52:50.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class VoiceRespMsg extends BaseRespMsg {

    private String msgType = RespMsgType.voice.name();

    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
