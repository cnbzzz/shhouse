package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import javax.persistence.*;

@Table(name = "t_sa_area")
public class TSaArea extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 取字典 METRO_STATION
     */
    private String aname;

    /**
     * 取字典 COUNTY
     */
    private String county;

    /**
     * 取字典 STATUS
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
     * 获取取字典 METRO_STATION
     *
     * @return aname - 取字典 METRO_STATION
     */
    public String getAname() {
        return aname;
    }

    /**
     * 设置取字典 METRO_STATION
     *
     * @param aname 取字典 METRO_STATION
     */
    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    /**
     * 获取取字典 COUNTY
     *
     * @return county - 取字典 COUNTY
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置取字典 COUNTY
     *
     * @param county 取字典 COUNTY
     */
    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    /**
     * 获取取字典 STATUS
     *
     * @return status - 取字典 STATUS
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置取字典 STATUS
     *
     * @param status 取字典 STATUS
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}