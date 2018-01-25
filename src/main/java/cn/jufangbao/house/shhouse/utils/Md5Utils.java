package cn.jufangbao.house.shhouse.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Md5Utils.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:44:47.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class Md5Utils {

    public static String getMd5Pwd(String pwd){
        return guavaMd5(guavaMd5(pwd));
    }

    public static String guavaMd5(String text){
        return Hashing.md5().newHasher().putString(text, Charsets.UTF_8).hash().toString();
    }

    public static String codecMd5(String text){
        return DigestUtils.md5Hex(text);
    }

    public static void main(String[] args) {
        String str = "123";
        System.err.println(getMd5Pwd(str));
    }
}
