package cn.jufangbao.house.shhouse.wechat.resp.msg;

/**
 * MusicRespMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:46:16.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class MusicRespMsg extends BaseRespMsg {

    private String msgType = RespMsgType.music.name();

    private String title;

    private String desc;

    private String musicUrl;

    private String HQMusicUrl;

    private String thumbMediaId;

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

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
