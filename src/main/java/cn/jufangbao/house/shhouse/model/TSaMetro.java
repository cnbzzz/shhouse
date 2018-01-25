package cn.jufangbao.house.shhouse.model;

import cn.jufangbao.house.shhouse.base.BaseDto;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sa_metro")
public class TSaMetro extends BaseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;

    /**
     * 取字典 METRO_STATION
     */
    private String metro;

    /**
     * 取字典 METRO_LINE
     */
    private String line;

    /**
     * 用户表主键
     */
    private String cuoid;

    private Date cdate;

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
     * @return metro - 取字典 METRO_STATION
     */
    public String getMetro() {
        return metro;
    }

    /**
     * 设置取字典 METRO_STATION
     *
     * @param metro 取字典 METRO_STATION
     */
    public void setMetro(String metro) {
        this.metro = metro == null ? null : metro.trim();
    }

    /**
     * 获取取字典 METRO_LINE
     *
     * @return line - 取字典 METRO_LINE
     */
    public String getLine() {
        return line;
    }

    /**
     * 设置取字典 METRO_LINE
     *
     * @param line 取字典 METRO_LINE
     */
    public void setLine(String line) {
        this.line = line == null ? null : line.trim();
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