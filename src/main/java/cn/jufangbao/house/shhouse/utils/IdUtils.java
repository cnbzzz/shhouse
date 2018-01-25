package cn.jufangbao.house.shhouse.utils;

import java.util.UUID;

/**
 * IdUtils.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:44:39.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class IdUtils {

    public static String UUID(){
        return UUID.randomUUID().toString();
    }

    public static Long snowflakeId(int workerId, int datacenterId){
        return new SnowflakeIdWorker(workerId, datacenterId).nextId();
    }
}
