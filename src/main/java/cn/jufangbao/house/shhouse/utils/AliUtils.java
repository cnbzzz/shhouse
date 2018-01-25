package cn.jufangbao.house.shhouse.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.google.common.base.Preconditions;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * AliUtils.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:42:26.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class AliUtils {

    private static Logger log = LogManager.getLogger();

    private static Properties PROP = null;

    public static Properties getPROP(String path) {
        if(PROP == null){
            if(StringUtils.isBlank(path)){
                path = "/ali.properties";
            }
            PROP = CommUtils.loadProp(path);
        }
        return PROP;
    }

    /**
     * 发送验证码
     * @param servNumber 手机号码
     * @param code 验证码
     * @author bzzz
     */
    private static String SEND_SMS ="http://61.147.98.212:9001/sms.aspx?action=send&userid=%s&account=%s&password=%s&mobile=%s&content=%s&sendTime=&taskName=&checkcontent=0&mobilenumber=1&countnumber=1&telephonenumber=0";
    private static String SMS_P = "【大润家】你本次的验证码是%s，10分钟内输入有效，感谢使用";
    public static boolean sendRandomcodeSms(String servNumber, String code) {
        Preconditions.checkArgument(StringUtils.isNotBlank(servNumber), "手机号码为空");

        String USER_ID = getPROP("").getProperty("sms.userid", "http://gw.api.taobao.com/router/rest");
        String ACCOUNT = getPROP("").getProperty("sms.account", "23709217");
        String PASSWD = getPROP("").getProperty("sms.passwd", "8686a3df488fc074a674142f1b4ce6c0");
        String messageContent = String.format(SMS_P,code);
        String url = String.format(SEND_SMS,
                USER_ID,
                ACCOUNT,
                PASSWD,
                servNumber,
                messageContent
        );
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                response.close();
                return true;
            }
        }catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return false;
    }

    /**
     * 发送经纪人注册成功通知
     * @param servNumber 手机号码
     * @param agentName 经纪人姓名
     * @author bzzz
     */
    public static boolean sendAgentRegisterSuccSms(String servNumber, String agentName) {
        String jsonParam = String.format("{agentName:'%s'}", agentName);
        String tmplatecode = getPROP("").getProperty("sms.agentregsucc.tmplatecode", "SMS_62990170");
        return sendSms(servNumber, jsonParam, tmplatecode);
    }

    /**
     * 房源审核通过通知
     * @param servNumber 手机号码
     * @param houseName 房源名
     * @author bzzz
     */
    public static boolean sendHouseAuditSucc(String servNumber, String houseName) {
        String jsonParam = String.format("{houseName:'%s'}", houseName);
        String tmplatecode = getPROP("").getProperty("sms.houseauditsucc.tmplatecode", "SMS_63960797");
        return sendSms(servNumber, jsonParam, tmplatecode);
    }

    /**
     * 房源上架通知
     * @param servNumber 手机号码
     * @param houseName 房源名
     * @param houseNum 房源编号
     * @author bzzz
     */
    public static boolean sendHouseGroundingSucc(String servNumber, String houseName, String houseNum) {
        String jsonParam = String.format("{houseName:'%s', houseNum:'%s'}", houseName, houseNum);
        String tmplatecode = getPROP("").getProperty("sms.housegroundingsucc.tmplatecode", "SMS_63920920");
        return sendSms(servNumber, jsonParam, tmplatecode);
    }

    /**
     * 看房通知
     * @param servNumber 手机号码
     * @param houseName 房源名
     * @param seenTime 看房时间，建议是yyyy-MM-dd HH:mm:ss格式
     * @author bzzz
     */
    public static boolean sendSeeTheHouse(String servNumber, String houseName, String seenTime) {
        String jsonParam = String.format("{houseName:'%s', seenTime:'%s'}", houseName, seenTime);
        String tmplatecode = getPROP("").getProperty("sms.seethehouse.tmplatecode", "SMS_63841026");
        return sendSms(servNumber, jsonParam, tmplatecode);
    }

    public static boolean sendSms(String servNumber, String paramJson, String tmplatecode) {
        boolean result = false;
        Preconditions.checkArgument(StringUtils.isNotBlank(servNumber), "手机号码为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(paramJson), "短信参数为空");
        String url = getPROP("").getProperty("sms.url", "http://gw.api.taobao.com/router/rest");
        String appkey = getPROP("").getProperty("sms.appkey", "23709217");
        String secret = getPROP("").getProperty("sms.secret", "8686a3df488fc074a674142f1b4ce6c0");
        String signname = getPROP("").getProperty("sms.signname", "二手房测试");
        String smstype = getPROP("").getProperty("sms.smstype", "normal");
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType(smstype);
        req.setSmsFreeSignName(signname);
        req.setSmsParamString(paramJson);
        req.setRecNum(servNumber);
        req.setSmsTemplateCode(tmplatecode);
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        String rspBody = null;
        try {
            rsp = client.execute(req);
            rspBody = rsp.getBody();
            JSONObject jsonObject = JSON.parseObject(rspBody);
            String smsResult = jsonObject.getJSONObject("alibaba_aliqin_fc_sms_num_send_response").getJSONObject("result").getString("err_code");
            if ("0".equals(smsResult)) {
                result = true;
            }
        } catch (Exception e) {
            log.error("resp is {}", rspBody);
            log.error(e.getMessage(), e);
            result = false;
        }

        return result;
    }

    public static Img uploadImg(String filename, InputStream inputStream) {
        Img img = null;
        String endpoint = getPROP("").getProperty("oss.url", "oss-cn-shenzhen.aliyuncs.com");
        // accessKey请登录https://ak-console.aliyun.com/#/查看
        String accessKeyId = getPROP("").getProperty("oss.appkey", "LTAIGL1vAwe1e7z0");
        String accessKeySecret = getPROP("").getProperty("oss.secret", "rtCBzyecTwTychTb0r58zqSXlWtbiQ");;

        String bucketname = getPROP("").getProperty("oss.bucketname", "nexth");
        String imgstyle = getPROP("").getProperty("oss.stylename", "shhouse");
        String iconstyle = getPROP("").getProperty("oss.stylename", "shhouse_icon");

        // 创建OSSClient实例
        OSSClient client = new OSSClient(endpoint, accessKeyId,accessKeySecret);

        try {
            // 上传
            if(StringUtils.isBlank(filename)){
                filename = IdUtils.UUID().concat(".jpg");
            }
            Calendar calendar = Calendar.getInstance();
            String year = String.format("%04d", calendar.get(Calendar.YEAR));
            String month = String.format("%02d", calendar.get(Calendar.MONTH) + 1);
            String path = String.format("%s%s", year, month);
            client.putObject(bucketname, path + "/" + filename, inputStream);
            System.err.println("");
            String imgPath = String.format("http://%s.%s/%s/%s?x-oss-process=style/%s", bucketname, endpoint, path, filename, imgstyle);
            String iconPath = String.format("http://%s.%s/%s/%s?x-oss-process=style/%s", bucketname, endpoint, path, filename, iconstyle);
            img = new Img(filename, imgPath, iconPath);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }  finally {
            client.shutdown();
        }

        return img;
    }

    public static class Img {
        private String imgName;
        private String imgPath;
        private String iconPath;

        public Img(){}

        public Img(String path, String iconPath) {
            this.imgPath = path;
            this.iconPath = iconPath;
        }

        public Img(String imgName, String imgPath, String iconPath) {
            this.imgName = imgName;
            this.imgPath = imgPath;
            this.iconPath = iconPath;
        }

        public String getImgName() {
            return imgName;
        }

        public void setImgName(String imgName) {
            this.imgName = imgName;
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }

        public String getIconPath() {
            return iconPath;
        }

        public void setIconPath(String iconPath) {
            this.iconPath = iconPath;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }

    public static void main(String[] args) throws Exception {
//        String path = "E:\\jufangbao\\代码\\shhouse\\src\\main\\resources\\static\\img\\img3.png";
//        Img result = AliUtils.uploadImg(null, new FileInputStream(path));
//        System.err.println(result);

        AliUtils.sendAgentRegisterSuccSms("13600088367", "森哥");
    }
}
