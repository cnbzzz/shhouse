package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sa_dict_item")
public class TSaDictItem extends BaseDto {
    @Id
    private String dictid;

    @Id
    private String groupid;

    private String dictname;

    private Integer sort;

    private Date cdate;

    /**
     * 1显示
            0不显示
     */
    private Integer status;

    /**
     * @return dictid
     */
    public String getDictid() {
        return dictid;
    }

    /**
     * @param dictid
     */
    public void setDictid(String dictid) {
        this.dictid = dictid == null ? null : dictid.trim();
    }

    /**
     * @return groupid
     */
    public String getGroupid() {
        return groupid;
    }

    /**
     * @param groupid
     */
    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    /**
     * @return dictname
     */
    public String getDictname() {
        return dictname;
    }

    /**
     * @param dictname
     */
    public void setDictname(String dictname) {
        this.dictname = dictname == null ? null : dictname.trim();
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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