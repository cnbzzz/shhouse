package cn.jufangbao.house.shhouse.service;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.model.TSaAppUpdate;
import cn.jufangbao.house.shhouse.model.TSaDictItem;
import cn.jufangbao.house.shhouse.model.TSaImages;
import cn.jufangbao.house.shhouse.utils.AliUtils;

import java.io.InputStream;
import java.util.List;

/**
 * PublicService.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:41:42.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public interface PublicService {

    BaseResp<List<TSaImages>> queryImagesByGroupId(String groupId);

    BaseResp<List<TSaImages>> queryVideosByGroupId(String groupId);

    BaseResp<TSaImages> queryImagesById(String oid);

    BaseResp<String> sendRandomcodeSms(String recNum);

    BaseResp chkRandomCode(String recnum, String randomcode);

    BaseResp<TSaImages> uploadImgAndUpdateImg(String filename, InputStream inputStream, TSaImages param);

    BaseResp<AliUtils.Img> uploadImg(String filename, InputStream inputStream);

    BaseResp editImage(TSaImages image);

    BaseResp<TSaDictItem> queryDictItemByGroupId(String groupId);

    BaseResp<TSaAppUpdate> queryNewestVersion(Long currVersionNum);
}
