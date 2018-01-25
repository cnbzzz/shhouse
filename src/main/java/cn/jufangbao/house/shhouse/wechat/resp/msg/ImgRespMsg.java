package cn.jufangbao.house.shhouse.wechat.resp.msg;

/**
 * ImgRespMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:46:12.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class ImgRespMsg extends BaseRespMsg {

    private String msgType = RespMsgType.image.name();

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
