package cn.jufangbao.house.shhouse.wechat.req.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * ImgReqMsg.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:45:33.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class ImgReqMsg extends BaseReqMsg {

    @XStreamAlias("PicUrl")
    private String picUrl;

    @XStreamAlias("MediaId")
    private String mediaId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
