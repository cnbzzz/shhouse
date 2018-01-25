package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.base.BaseServiceImpl;
import cn.jufangbao.house.shhouse.mapper.TSaAppUpdateMapper;
import cn.jufangbao.house.shhouse.mapper.TSaDictItemMapper;
import cn.jufangbao.house.shhouse.mapper.TSaImagesMapper;
import cn.jufangbao.house.shhouse.mapper.TSaSmsMapper;
import cn.jufangbao.house.shhouse.model.*;
import cn.jufangbao.house.shhouse.service.PublicService;
import cn.jufangbao.house.shhouse.utils.AliUtils;
import cn.jufangbao.house.shhouse.utils.CommUtils;
import cn.jufangbao.house.shhouse.utils.IdUtils;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static cn.jufangbao.house.shhouse.utils.AliUtils.getPROP;

/**
 * PublicServiceImpl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:40:13.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class PublicServiceImpl extends BaseServiceImpl implements PublicService {

    @Resource
    TSaImagesMapper imagesMapper;

    @Resource
    TSaSmsMapper smsMapper;

    @Resource
    TSaDictItemMapper dictItemMapper;

    @Resource
    TSaAppUpdateMapper saAppUpdateMapper;

    public BaseResp<TSaDictItem> queryDictItemByGroupId(String groupId){
        BaseResp resp = succ("查询成功");
        try{
            Preconditions.checkArgument(StringUtils.isNotBlank(groupId), "groupId为空");
            TSaDictItem param = new TSaDictItem();
            param.setGroupid(groupId);
            param.setStatus(1);
            List<TSaDictItem> select = dictItemMapper.select(param);
            resp.setData(select);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            resp = fail("查询失败");
        }
        return resp;
    }

    public BaseResp<TSaImages> uploadImgAndUpdateImg(String filename, InputStream inputStream, TSaImages param){
        BaseResp resp = succ("上传成功");
        try {
            Preconditions.checkArgument(inputStream != null, "inputStream为空");
            TSaImages image = null;
            String groupId = null;
            String imgOid = null;
            String itype = null;
            String isource = null;
            if(param != null){
                imgOid = param.getOid();
                itype = param.getItype();
                isource = param.getIsource();
                groupId = param.getIgroupoid();
                if(StringUtils.isNotBlank(imgOid)){//是修改
                    image = imagesMapper.selectByPrimaryKey(imgOid);
                    Preconditions.checkState(image != null, "未找到对应图片,图片编码%s", imgOid);
                } else {
                    image = new TSaImages();
                }
            }
            AliUtils.Img img = AliUtils.uploadImg(filename, inputStream);
            Preconditions.checkState(img != null, "上传失败");
            String iconPath = img.getIconPath();
            String imgPath = img.getImgPath();
            String imgName = img.getImgName();

            image.setIpath(imgPath);
            image.setSmipath(iconPath);
            image.setIname(imgName);
            image.setCdate(new Date());
            image.setStatus(1);

            if(StringUtils.isBlank(groupId)){
                groupId = IdUtils.UUID();
            }
            image.setIgroupoid(groupId);

            if(StringUtils.isBlank(itype)){
                itype = "1";
            }
            image.setItype(itype);
            if(StringUtils.isNotBlank(isource)){
                image.setIsource(isource);
            }

            if(StringUtils.isNotBlank(imgOid)) {//是修改
                imagesMapper.updateByPrimaryKeySelective(image);
            } else{
                imagesMapper.insertSelective(image);
            }
            resp.setData(image);
        } catch (IllegalStateException e){
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e){
            log.error(e.getMessage(), e);
            resp = fail();
        }

        return resp;
    }

    public BaseResp<AliUtils.Img> uploadImg(String filename, InputStream inputStream){
        BaseResp resp = succ("上传成功");
        try {
            Preconditions.checkArgument(inputStream != null, "inputStream为空");
            AliUtils.Img img = AliUtils.uploadImg(filename, inputStream);
            Preconditions.checkState(img != null, "上传失败");
            resp.setData(img);
        } catch (IllegalStateException e){
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e){
            log.error(e.getMessage(), e);
            resp = fail();
        }

        return resp;
    }

    public BaseResp<String> sendRandomcodeSms(String recNum) {
        BaseResp resp = succ("查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(recNum), "号码为空");
            TSaSms tSaSms = smsMapper.querySmsWithin1minByRecNum(recNum);//查询1分钟内有没有发送过短信验证码
            if (tSaSms == null) {
                String randomCode = CommUtils.genRandomCode();
                boolean succ = AliUtils.sendRandomcodeSms(recNum, randomCode);
                TSaSms sms = new TSaSms();
                sms.setSendplatform("阿里大于");
                sms.setRecnum(recNum);
                Date sendtime = new Date();
                sms.setSendtime(sendtime);
                sms.setAuthcode(randomCode);
                sms.setContent("SMS_56735388");
                Date invalidtime = DateUtils.addMinutes(sendtime, 10);
                sms.setInvalidtime(invalidtime);
                int sendcount = 1;
                int status = 0;
                if (succ) {
                    status = 1;
                    resp.setData(randomCode);
                } else {
                    resp = fail("发送失败");
                    int i = 3;
                    while (i-- > 0) {
                        sendcount++;
                        succ = AliUtils.sendRandomcodeSms(recNum, randomCode);
                        if (succ) {
                            status = 1;
                            resp.setData(randomCode);
                            break;
                        }
                    }
                }
                sms.setSendcount(sendcount);
                sms.setStatus(status);
                smsMapper.insertSelective(sms);
            } else {
                resp.setData(tSaSms.getAuthcode());
            }
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp chkRandomCode(String recnum, String randomcode) {
        BaseResp resp = succ("查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(recnum), "号码为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(randomcode), "验证码为空");
            TSaSms tSaSms = smsMapper.queryAllowSmsByRecNumAndRandomCode(recnum, randomcode);
            if(tSaSms != null){
                tSaSms.setStatus(2);
                tSaSms.setChktime(new Date());
                smsMapper.updateByPrimaryKeySelective(tSaSms);
            } else{
                resp = fail("验证码失效");
            }
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<List<TSaImages>> queryImagesByGroupId(String groupId) {
        BaseResp<List<TSaImages>> resp = succ("查询成功");
        try {
            List<TSaImages> list = listImages(groupId, "1");
            resp.setData(list);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<List<TSaImages>> queryVideosByGroupId(String groupId) {
        BaseResp<List<TSaImages>> resp = succ("查询成功");
        try {
            List<TSaImages> list = listImages(groupId, "2");
            resp.setData(list);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    private List<TSaImages> listImages(String groupId, String itype) {
        Preconditions.checkArgument(StringUtils.isNotBlank(groupId), "参数为空");
        TSaImages imageParam = new TSaImages();
        imageParam.setIgroupoid(groupId);
        if(StringUtils.isBlank(itype)){
            itype = "1";
        }
        imageParam.setItype(itype);
        imageParam.setStatus(1);
        return imagesMapper.select(imageParam);
    }

    public BaseResp<TSaImages> queryImagesById(String oid) {
        BaseResp<TSaImages> resp = succ("查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(oid), "参数为空");
            TSaImages images = imagesMapper.selectByPrimaryKey(oid);
            resp.setData(images);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp editImage(TSaImages image){
        BaseResp<TSaImages> resp = succ("查询成功");
        try{
            Preconditions.checkArgument(image != null, "图片为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(image.getIname()), "图片名为空");
            String ipath = image.getIpath();
            Preconditions.checkArgument(StringUtils.isNotBlank(ipath), "图片路径为空");

            if(!StringUtils.startsWithIgnoreCase(ipath, "http")){
                String endpoint = getPROP("").getProperty("oss.url", "oss-cn-shenzhen.aliyuncs.com");
                String bucket = getPROP("").getProperty("oss.bucketname", "nexth");
                String host = "http://" + bucket + "." + endpoint;
                ipath = String.format("%s/%s", host, ipath);
                image.setIpath(ipath);
            }

            String oid = image.getOid();
            if(StringUtils.isBlank(oid)){
                String itype = image.getItype();
                if(StringUtils.isBlank(itype)){
                    itype = "1";
                }
                image.setItype(itype);

                Integer sort = image.getSort();
                if(sort == null){
                    sort = 1;
                }
                image.setSort(sort);

                Integer status = image.getStatus();
                if(status == null){
                    status = 1;
                }
                image.setCdate(new Date());
                image.setStatus(status);

                imagesMapper.insertSelective(image);
            } else{
                TSaImages tSaImages = imagesMapper.selectByPrimaryKey(oid);
                Preconditions.checkArgument(tSaImages != null, "未找到图片, oid[%s]", oid);
                imagesMapper.updateByPrimaryKeySelective(image);
            }
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<TSaAppUpdate> queryNewestVersion(Long currVersionNum){
        BaseResp resp = succ("查询成功");
        try{
            Preconditions.checkArgument(currVersionNum != null, "currVersionNum is null");
            Example example = new Example(TSaAppUpdate.class);
            example.setOrderByClause("pubdate desc limit 1");
            List<TSaAppUpdate> list = saAppUpdateMapper.selectByExample(example);
            if(list.size() > 0){
                TSaAppUpdate tSaAppUpdate = list.get(0);
                Long systemversion = tSaAppUpdate.getSystemversion();
                if(currVersionNum < systemversion){
                    resp.setData(tSaAppUpdate);
                    resp.setRetCode("2");//有更新
                }
            }
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public static void main(String[] args) {
        String str = "http:";
        System.err.println(StringUtils.startsWithIgnoreCase(str, "http"));
    }
}
