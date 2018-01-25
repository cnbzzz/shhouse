package cn.jufangbao.house.shhouse.wechat.req.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * VoiceReqMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:46:00.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class VoiceReqMsg extends BaseReqMsg {

    @XStreamAlias("MediaId")
    private String mediaId;

    @XStreamAlias("Format")
    private String format;

    @XStreamAlias("Recognition")
    private String recognition;

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
