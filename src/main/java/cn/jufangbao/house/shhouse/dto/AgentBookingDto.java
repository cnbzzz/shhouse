package cn.jufangbao.house.shhouse.dto;

import java.util.Date;

/**
 * AgentBookingDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:35:44.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AgentBookingDto extends HouseDto {

    private String custid;

    private String custname;

    private Long phonenum;

    private Date bookingtime;

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public Long getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(Long phonenum) {
        this.phonenum = phonenum;
    }

    public Date getBookingtime() {
        return bookingtime;
    }

    public void setBookingtime(Date bookingtime) {
        this.bookingtime = bookingtime;
    }
}
