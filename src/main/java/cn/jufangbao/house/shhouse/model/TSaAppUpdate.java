package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sa_app_update")
public class TSaAppUpdate extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String showversion;

    private Long systemversion;

    private String url;

    private String remark;

    private Date pubdate;

    /**
     * 1显示
            0不显示
     */
    private Integer status;

    /**
     * @return oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid
     */
    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    /**
     * @return showversion
     */
    public String getShowversion() {
        return showversion;
    }

    /**
     * @param showversion
     */
    public void setShowversion(String showversion) {
        this.showversion = showversion == null ? null : showversion.trim();
    }

    /**
     * @return systemversion
     */
    public Long getSystemversion() {
        return systemversion;
    }

    /**
     * @param systemversion
     */
    public void setSystemversion(Long systemversion) {
        this.systemversion = systemversion;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return pubdate
     */
    public Date getPubdate() {
        return pubdate;
    }

    /**
     * @param pubdate
     */
    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    /**
     * 获取1显示
            0不显示
     *
     * @return status - 1显示
            0不显示
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1显示
            0不显示
     *
     * @param status 1显示
            0不显示
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}