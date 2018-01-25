package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_res_house_hot")
public class TResHouseHot extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private Integer follow;

    private Integer browse;

    private Integer seen;

    /**
     * 用户表主键
     */
    private String cuoid;

    private Date cdate;

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
     * @return follow
     */
    public Integer getFollow() {
        return follow;
    }

    /**
     * @param follow
     */
    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    /**
     * @return browse
     */
    public Integer getBrowse() {
        return browse;
    }

    /**
     * @param browse
     */
    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    /**
     * @return seen
     */
    public Integer getSeen() {
        return seen;
    }

    /**
     * @param seen
     */
    public void setSeen(Integer seen) {
        this.seen = seen;
    }

    /**
     * 获取用户表主键
     *
     * @return cuoid - 用户表主键
     */
    public String getCuoid() {
        return cuoid;
    }

    /**
     * 设置用户表主键
     *
     * @param cuoid 用户表主键
     */
    public void setCuoid(String cuoid) {
        this.cuoid = cuoid == null ? null : cuoid.trim();
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