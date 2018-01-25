package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sa_dict_group")
public class TSaDictGroup extends BaseDto {
    @Id
    private String goupid;

    private String groupname;

    private Date cdate;

    /**
     * 1显示
            0不显示
     */
    private Integer status;

    /**
     * @return goupid
     */
    public String getGoupid() {
        return goupid;
    }

    /**
     * @param goupid
     */
    public void setGoupid(String goupid) {
        this.goupid = goupid == null ? null : goupid.trim();
    }

    /**
     * @return groupname
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * @param groupname
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    /**
     * @return cdate
     */
    public Date getCdate() {
        return cdate;
    }

    /**
     * @param cdate
     */
    public void setCdate(Date cdate) {
        this.cdate = cdate;
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