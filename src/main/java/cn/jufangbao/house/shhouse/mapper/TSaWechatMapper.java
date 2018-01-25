package cn.jufangbao.house.shhouse.mapper;

import cn.jufangbao.house.shhouse.model.TSaWechat;
import tk.mybatis.mapper.common.Mapper;

public interface TSaWechatMapper extends Mapper<TSaWechat> {

    TSaWechat foundWechat();
}