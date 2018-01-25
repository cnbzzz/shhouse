package cn.jufangbao.house.shhouse.base;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.UUID;

/**
 * BaseDto.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:34:09.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class BaseDto implements Serializable {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
