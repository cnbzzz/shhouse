package cn.jufangbao.house.shhouse.wechat.resp.msg;

/**
 * VideoRespMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:52:49.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class VideoRespMsg extends BaseRespMsg {

    private String msgType = RespMsgType.video.name();

    private String mediaId;

    private String title;

    private String desc;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
