package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_res_comm")
public class TResComm extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    private String cname;

    /**
     * 取字典 PROVINCE
     */
    private String province;

    /**
     * 取字典 CITY
     */
    private String city;

    /**
     * 取字典 COUNTY
     */
    private String county;

    private String attr;

    /**
     * 取字典 HOUSE_BUILDER
     */
    private String builder;

    /**
     * yyyy格式
     */
    private Integer byear;

    /**
     * 单位 分
     */
    private Long avgprice;

    private String ipath;

    /**
     * 图片表igroupoid字段
     */
    private String igroupoid;

    private Long icount;

    /**
     * 用户表主键
     */
    private String cuoid;

    private Date cdate;

    private Double northlatitude;

    private Double eastlongitude;

    /**
     * 销售状态
     */
    private String status;

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
     * @return cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * 获取取字典 PROVINCE
     *
     * @return province - 取字典 PROVINCE
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置取字典 PROVINCE
     *
     * @param province 取字典 PROVINCE
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取取字典 CITY
     *
     * @return city - 取字典 CITY
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置取字典 CITY
     *
     * @param city 取字典 CITY
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
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
     * @return attr
     */
    public String getAttr() {
        return attr;
    }

    /**
     * @param attr
     */
    public void setAttr(String attr) {
        this.attr = attr == null ? null : attr.trim();
    }

    /**
     * 获取取字典 HOUSE_BUILDER
     *
     * @return builder - 取字典 HOUSE_BUILDER
     */
    public String getBuilder() {
        return builder;
    }

    /**
     * 设置取字典 HOUSE_BUILDER
     *
     * @param builder 取字典 HOUSE_BUILDER
     */
    public void setBuilder(String builder) {
        this.builder = builder == null ? null : builder.trim();
    }

    /**
     * 获取yyyy格式
     *
     * @return byear - yyyy格式
     */
    public Integer getByear() {
        return byear;
    }

    /**
     * 设置yyyy格式
     *
     * @param byear yyyy格式
     */
    public void setByear(Integer byear) {
        this.byear = byear;
    }

    /**
     * 获取单位 分
     *
     * @return avgprice - 单位 分
     */
    public Long getAvgprice() {
        return avgprice;
    }

    /**
     * 设置单位 分
     *
     * @param avgprice 单位 分
     */
    public void setAvgprice(Long avgprice) {
        this.avgprice = avgprice;
    }

    /**
     * @return ipath
     */
    public String getIpath() {
        return ipath;
    }

    /**
     * @param ipath
     */
    public void setIpath(String ipath) {
        this.ipath = ipath == null ? null : ipath.trim();
    }

    /**
     * 获取图片表igroupoid字段
     *
     * @return igroupoid - 图片表igroupoid字段
     */
    public String getIgroupoid() {
        return igroupoid;
    }

    /**
     * 设置图片表igroupoid字段
     *
     * @param igroupoid 图片表igroupoid字段
     */
    public void setIgroupoid(String igroupoid) {
        this.igroupoid = igroupoid == null ? null : igroupoid.trim();
    }

    /**
     * @return icount
     */
    public Long getIcount() {
        return icount;
    }

    /**
     * @param icount
     */
    public void setIcount(Long icount) {
        this.icount = icount;
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
     * @return northlatitude
     */
    public Double getNorthlatitude() {
        return northlatitude;
    }

    /**
     * @param northlatitude
     */
    public void setNorthlatitude(Double northlatitude) {
        this.northlatitude = northlatitude;
    }

    /**
     * @return eastlongitude
     */
    public Double getEastlongitude() {
        return eastlongitude;
    }

    /**
     * @param eastlongitude
     */
    public void setEastlongitude(Double eastlongitude) {
        this.eastlongitude = eastlongitude;
    }

    /**
     * 获取销售状态
     *
     * @return status - 销售状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置销售状态
     *
     * @param status 销售状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}