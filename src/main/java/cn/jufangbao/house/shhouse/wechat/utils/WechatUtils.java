package cn.jufangbao.house.shhouse.wechat.utils;

import cn.jufangbao.house.shhouse.wechat.req.msg.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.util.*;

import static cn.jufangbao.house.shhouse.wechat.req.msg.BaseReqMsg.ReqMsgType.*;

/**
 * WechatUtils.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:46:27.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class WechatUtils {

    private static Logger log = LogManager.getLogger();

    public static Map<String, Class> MSG_TYPE_CLAZZ = Maps.newHashMap();

    static {
        MSG_TYPE_CLAZZ.put(text.name(), TxtReqMsg.class);
        MSG_TYPE_CLAZZ.put(image.name(), ImgReqMsg.class);
        MSG_TYPE_CLAZZ.put(voice.name(), VoiceReqMsg.class);
        MSG_TYPE_CLAZZ.put(video.name(), VideoReqMsg.class);
        MSG_TYPE_CLAZZ.put(shortvideo.name(), VideoReqMsg.class);
        MSG_TYPE_CLAZZ.put(location.name(), LocReqMsg.class);
        MSG_TYPE_CLAZZ.put(link.name(), LinkReqMsg.class);
    }

    public static boolean checkConnect(String token, String signature, String timestamp, String nonce) {
        String tmpStr = getSHA1(token, timestamp, nonce);
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equalsIgnoreCase(signature) : false;
    }

    public static String getSHA1(String token, String timestamp, String nonce) {
        String[] array = new String[]{token, timestamp, nonce};
        StringBuilder sb = new StringBuilder();
        // 字符串排序
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        String str = sb.toString();
        return DigestUtils.sha1Hex(str);
    }

    public static Map<String, String> xmlToMap(String xml) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 读取输入流
        Document document = DocumentHelper.parseText(xml);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList) {
            String name = e.getName();
            map.put(name, e.getText());
            char[] cs=name.toCharArray();
            cs[0] += 32;
            name = String.valueOf(cs);
            map.put(name, e.getText());
        }

        return map;
    }

    private static XStream xStream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    public static <T> T toBean(String xml, Class clazz) {
        xStream.alias("xml", clazz);
        xStream.processAnnotations(clazz);
        return (T) xStream.fromXML(xml);
    }

    public static String toXml(Object obj) {
        Class<?> clazz = obj.getClass();
        xStream.alias("xml", clazz);
        xStream.processAnnotations(clazz);
        return xStream.toXML(obj);
    }

    private static Properties PROP = null;

    public static Properties loadProp(String path){
        if(StringUtils.isBlank(path)){
            path = "/wechat/wechat.properties";
        }
        if(PROP != null){
            return PROP;
        }
        try (InputStream inputStream = WechatUtils.class.getResourceAsStream(path);) {
            PROP = new Properties();
            PROP.load(new InputStreamReader(inputStream, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PROP;
    }

    public static String getAppId(){
        Properties prop = loadProp("");
        return prop.getProperty("wechat.appid");
    }

    public static String getAppSecret(){
        Properties prop = loadProp("");
        return prop.getProperty("wechat.appsecret");
    }

    public static String getAppToken(){
        Properties prop = loadProp("");
        return prop.getProperty("wechat.apptoken");
    }

    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr     提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuilder buffer = new StringBuilder();
        try {

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            httpUrlConn.disconnect();
            log.info(buffer.toString());
            jsonObject = JSON.parseObject(buffer.toString());
        } catch (ConnectException ce) {
            log.error("Weixin server connection timed out.");
        } catch (Exception e) {
            log.error("https request error:{}", e);
        }
        return jsonObject;
    }

    // 获取access_token的接口地址（GET） 限200（次/天）
    public final static String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 获取access_token
     *
     * @param appid     凭证
     * @param appsecret 密钥
     * @return
     */
    public static WechatAccessToken getAccessToken(String appid, String appsecret) {
        WechatAccessToken accessToken = null;

        String requestUrl = accessTokenUrl.replace("APPID", appid).replace("APPSECRET", appsecret);
        JSONObject jsonObject = httpRequest(requestUrl, "POST", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new WechatAccessToken();
                accessToken.setToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败
                log.error(String.format("获取token失败 appid:[%s], appsecret:[%s], errcode:[%s], errmsg:[%s]",appid , appsecret, jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg")));
            }
        }
        return accessToken;
    }

}
