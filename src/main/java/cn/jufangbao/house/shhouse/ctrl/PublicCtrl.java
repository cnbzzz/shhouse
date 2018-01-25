package cn.jufangbao.house.shhouse.ctrl;

import cn.jufangbao.house.shhouse.base.BaseCtrl;
import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.model.TSaImages;
import cn.jufangbao.house.shhouse.service.PublicService;
import cn.jufangbao.house.shhouse.utils.AliUtils;
import cn.jufangbao.house.shhouse.utils.CommUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.net.URLDecoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Date;
import java.util.*;

import static cn.jufangbao.house.shhouse.utils.AliUtils.getPROP;

/**
 * PublicCtrl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:35:26.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
@RestController
@RequestMapping("/public")
public class PublicCtrl extends BaseCtrl {

    @Resource
    private PublicService publicService;

    @RequestMapping("/queryDictItemByGroupId")
    public String queryDictItemByGroupId(String groupId) {
        log.debug("param is groupId : {}", groupId);
        BaseResp resp = publicService.queryDictItemByGroupId(groupId);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryNewestVersion")
    public String queryNewestVersion(Long currVersionNum) {
        log.debug("param is currVersionNum : {}", currVersionNum);
        BaseResp resp = publicService.queryNewestVersion(currVersionNum);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryImageById")
    public String queryImageById(String oid) {
        log.debug("param is oid : {}", oid);
        BaseResp<TSaImages> resp = publicService.queryImagesById(oid);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/uploadImg")
    public String uploadImg(@RequestParam(value = "filename", required = false) String filename, String base64) {
        log.debug("param is filename : {}", filename);
        log.debug("param is base64 : {}", base64);

        if (base64.indexOf(",") != -1) {
            String[] tmp = StringUtils.split(base64, ",");
            base64 = tmp[1];
            log.debug("replace base64 : {}", base64);
        }
        byte[] bytes = Base64.decodeBase64(base64);
        BaseResp<AliUtils.Img> resp = publicService.uploadImg(filename, new ByteArrayInputStream(bytes));
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/uploadImgAndUpdateImg")
    public String uploadImgAndUpdateImg(@RequestParam(value = "filename", required = false) String filename, String base64, @RequestParam(value = "data", required = false) String data) {
        log.debug("param is filename : {}", filename);
        log.debug("param is base64 : {}", base64);
        log.debug("param is data : {}", data);

        TSaImages param = null;
        if (StringUtils.isNotBlank(data)) {
            try {
                param = JSON.parseObject(data, TSaImages.class);
            } catch (JSONException e) {
                log.error("json is bad {}", data);
            }
        }
        if (param == null) {
            return BaseResp.failResp("操作失败").toString();
        }

        if (base64.indexOf(",") != -1) {
            String[] tmp = StringUtils.split(base64, ",");
            base64 = tmp[1];
            log.debug("replace base64 : {}", base64);
        }
        byte[] bytes = Base64.decodeBase64(base64);
        BaseResp<TSaImages> resp = publicService.uploadImgAndUpdateImg(filename, new ByteArrayInputStream(bytes), param);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryImageByGroupId")
    public String queryImageByGroupId(String groupId) {
        log.debug("param is groupId : {}", groupId);
        BaseResp<List<TSaImages>> resp = publicService.queryImagesByGroupId(groupId);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/queryVideosByGroupId")
    public String queryVideosByGroupId(String groupId) {
        log.debug("param is groupId : {}", groupId);
        BaseResp<List<TSaImages>> resp = publicService.queryVideosByGroupId(groupId);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @Deprecated
    @RequestMapping(value = "/uploadBigFile", produces = "text/plain;charset=UTF-8")
    public String uploadBigFile(@RequestParam("name") String name, @RequestParam("type") String type, @RequestParam("size") Long size, HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        ServletInputStream stream = req.getInputStream();
        log.debug("param is name:{}, type:{}, size:{} stream:{}", name, type, size, stream);

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 得到所有的表单域，它们目前都被当作FileItem
        List<FileItem> fileItems = upload.parseRequest(req);
        log.debug("fileItems size is {}", fileItems.size());
        if (req.getParameter("chunk") == null) {

            String realPath = req.getSession().getServletContext()
                    .getRealPath("/Upload/");
            String fileName = name;
            File targetDir = new File(realPath);
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            }

            String pathname = realPath + fileName;
            log.debug("pathname is {}", pathname);
            File targetFile = new File(pathname);
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
//            file.transferTo(targetFile); // 小文件，直接拷贝
            OutputStream outputStream = new FileOutputStream(targetFile);
            InputStream inputStream = stream;

            byte buffer[] = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            inputStream.close();
            outputStream.close();
            log.debug("targetFile path is {}", targetFile.getCanonicalPath());
            return "";
        } else {
            int chunk = Integer.parseInt(req.getParameter("chunk")); // 当前分片
            int chunks = Integer.parseInt(req.getParameter("chunks")); // 分片总计

            String realPath = req.getSession().getServletContext()
                    .getRealPath("/Upload/");

            String Ogfilename = name;

            File tempFile = new File(realPath, Ogfilename);
            OutputStream outputStream = new FileOutputStream(tempFile, true);
            InputStream inputStream = stream;

            byte buffer[] = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            inputStream.close();
            outputStream.close();

            return "";
        }

    }

    @RequestMapping("/sendRandomcodeSms")
    public String sendRandomcodeSms(String recnum) {
        log.debug("param is recnum : {}", recnum);
        BaseResp resp = publicService.sendRandomcodeSms(recnum);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/chkRandomCode")
    public String chkRandomCode(String recnum, String randomcode) {
        log.debug("param is recnum : {}", recnum);
        log.debug("param is randomcode : {}", randomcode);
        BaseResp resp = publicService.chkRandomCode(recnum, randomcode);
        log.debug("resp is {}", resp);
        return resp.toString();
    }

    @RequestMapping("/ossSign")
    public void ossSign(HttpServletRequest request, HttpServletResponse response) {
        // accessKey请登录https://ak-console.aliyun.com/#/查看
        String accessId = getPROP("").getProperty("oss.appkey", "LTAIGL1vAwe1e7z0");
        String accessKey = getPROP("").getProperty("oss.secret", "rtCBzyecTwTychTb0r58zqSXlWtbiQ");
        ;
        String endpoint = getPROP("").getProperty("oss.url", "oss-cn-shenzhen.aliyuncs.com");
        String bucket = getPROP("").getProperty("oss.bucketname", "nexth");
        String host = "http://" + bucket + "." + endpoint;

        Calendar calendar = Calendar.getInstance();
        String year = String.format("%04d", calendar.get(Calendar.YEAR));
        String month = String.format("%02d", calendar.get(Calendar.MONTH) + 1);
        String dir = String.format("%s%s/", year, month);
        OSSClient client = new OSSClient(endpoint, accessId, accessKey);
        long expireTime = 30;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
        try {
            String postPolicy = client.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = client.calculatePostSignature(postPolicy);

            //callback start
            String callbackUrl = getPROP("").getProperty("oss.callbackurl", "http://120.76.53.1:9102/public/ossCallback");
            String callbackBody = getPROP("").getProperty("oss.callbackbody", "bucket=${bucket}&filename=${object}&size=${size}&mimeType=${mimeType}");
            String callbackBodyType = getPROP("").getProperty("oss.callbackbodytype", "application/x-www-form-urlencoded");
            Map<String, String> jsonMap = new HashMap<>();
            jsonMap.put("callbackUrl", callbackUrl);
            jsonMap.put("callbackBody", callbackBody);
            jsonMap.put("callbackBodyType", callbackBodyType);
            String json = JSON.toJSONString(jsonMap);
            String encodedCallback = BinaryUtil.toBase64String(json.getBytes("utf-8"));
            //callback end

            Map<String, String> respMap = new LinkedHashMap<String, String>();
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            //respMap.put("expire", formatISO8601Date(expiration));
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
            respMap.put("callback", encodedCallback);
            JSONObject ja1 = JSONObject.fromObject(respMap);
            System.out.println(ja1.toString());
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST");
            response(request, response, ja1.toString(), HttpServletResponse.SC_OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


    private void response(HttpServletRequest request, HttpServletResponse response, String results, int status) throws IOException {
        String callbackFunName = request.getParameter("callback");
        response.addHeader("Content-Length", String.valueOf(results.length()));
        if (callbackFunName == null || callbackFunName.equalsIgnoreCase(""))
            response.getWriter().println(results);
        else
            response.getWriter().println(callbackFunName + "( " + results + " )");
        response.setStatus(status);
        response.flushBuffer();
    }


    @RequestMapping(value = "/ossCallback", method = RequestMethod.GET)
    public void ossCallbackGet(HttpServletRequest request, HttpServletResponse response) {
        log.info("用户输入url:" + request.getRequestURI());
        try {
            response(request, response, "input get ", 200);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @RequestMapping(value = "/ossCallback", method = RequestMethod.POST)
    public void ossCallbackPost(HttpServletRequest request, HttpServletResponse response, @RequestBody String ossCallbackBody) {
        try {
//            String ossCallbackBody = getPostBody(request.getInputStream(), Integer.parseInt(request.getHeader("content-length")));
            boolean ret = verifyOSSCallbackRequest(request, ossCallbackBody);
            log.info("verify result:" + ret);
            log.info("OSS Callback Body:" + ossCallbackBody);

            Map<String, String> resultMap = new HashMap<>();
            if (ret) {
                String filename = null;
                String decode = CommUtils.urlParamDecode(ossCallbackBody);
                String[] split = StringUtils.split(decode, "&");
                for (String str: split) {
                    boolean bool = StringUtils.startsWithIgnoreCase(str, "filename");
                    if(bool){
                        String[] tmp = StringUtils.split(str, "=");
                        filename = tmp[1];
                    }
                }
                String endpoint = getPROP("").getProperty("oss.url", "oss-cn-shenzhen.aliyuncs.com");
                String bucket = getPROP("").getProperty("oss.bucketname", "nexth");
                String host = "http://" + bucket + "." + endpoint;
                String filepath = String.format("%s/%s", host, filename);
                TSaImages image = new TSaImages();
                image.setIname(filename);
                image.setIpath(filepath);
                image.setItype("2");
                image.setStatus(1);
                publicService.editImage(image);
                resultMap.put("retCode", "1");
                resultMap.put("oid", image.getOid());
                resultMap.put("ipath", image.getIpath());
                resultMap.put("retMsg", "SUCC");
                response(request, response, JSON.toJSONString(resultMap), HttpServletResponse.SC_OK);
            } else {
                resultMap.put("retCode", "0");
                resultMap.put("retMsg", "FAIL");
                response(request, response, JSON.toJSONString(resultMap), HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


    public String getPostBody(InputStream is, int contentLen) {
        if (contentLen > 0) {
            int readLen = 0;
            int readLengthThisTime = 0;
            byte[] message = new byte[contentLen];
            try {
                while (readLen != contentLen) {
                    readLengthThisTime = is.read(message, readLen, contentLen - readLen);
                    if (readLengthThisTime == -1) {// Should not happen.
                        break;
                    }
                    readLen += readLengthThisTime;
                }
                return new String(message);
            } catch (IOException e) {
            }
        }
        return "";
    }


    protected boolean verifyOSSCallbackRequest(HttpServletRequest request, String ossCallbackBody) throws NumberFormatException, IOException {
        boolean ret = false;
        String autorizationInput = new String(request.getHeader("Authorization"));
        String pubKeyInput = request.getHeader("x-oss-pub-key-url");
        byte[] authorization = BinaryUtil.fromBase64String(autorizationInput);
        byte[] pubKey = BinaryUtil.fromBase64String(pubKeyInput);
        String pubKeyAddr = new String(pubKey);
        if (!pubKeyAddr.startsWith("http://gosspublic.alicdn.com/") && !pubKeyAddr.startsWith("https://gosspublic.alicdn.com/")) {
            log.error("pub key addr must be oss addrss.. addr is {}", pubKeyAddr);
            return false;
        }
        log.info("pubKeyAddr is {}", pubKeyAddr);
        String retString = executeGet(pubKeyAddr);
        retString = retString.replace("-----BEGIN PUBLIC KEY-----", "");
        retString = retString.replace("-----END PUBLIC KEY-----", "");
        String queryString = request.getQueryString();
        String uri = request.getRequestURI();
        String decodeUri = java.net.URLDecoder.decode(uri, "UTF-8");
        String authStr = decodeUri;
        if (queryString != null && !queryString.equals("")) {
            authStr += "?" + queryString;
        }
        authStr += "\n" + ossCallbackBody;
        log.info("authStr is " + authStr);
        log.info("authorization is " + new String(authorization));
        log.info("retString is " + retString);
        ret = doCheck(authStr, authorization, retString);
        return ret;
    }

    public String executeGet(String url) {
        BufferedReader in = null;

        String content = null;
        try {
            // 定义HttpClient
            @SuppressWarnings("resource")
            DefaultHttpClient client = new DefaultHttpClient();
            // 实例化HTTP方法
            HttpGet request = new HttpGet();
            request.setURI(new URI(url));
            HttpResponse response = client.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            content = sb.toString();
        } catch (Exception e) {
        } finally {
            if (in != null) {
                try {
                    in.close();// 最后要关闭BufferedReader
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return content;
        }
    }


    public static boolean doCheck(String content, byte[] sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = BinaryUtil.fromBase64String(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature = java.security.Signature.getInstance("MD5withRSA");
            signature.initVerify(pubKey);
            signature.update(content.getBytes());
            boolean bverify = signature.verify(sign);
            return bverify;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
