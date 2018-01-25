package cn.jufangbao.house.shhouse.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * TokenUtils.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:42:24.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class TokenUtils {

    public static String encodeToken(String str){
        return new String(Base64.encodeBase64(Base64.encodeBase64(str.getBytes())));
    }

    public static String decodeToken(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        return new String(Base64.decodeBase64(Base64.decodeBase64(str.getBytes())));
    }

    public static void main(String[] args) {
        String json = "['aaa','bbbb','cccc']";
        try {

            List<String> list = JSON.parseArray(json, String.class);
            System.out.println("size="+list.size());
        } catch (Exception e)
        {

        }
    }
}
