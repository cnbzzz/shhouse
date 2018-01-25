package cn.jufangbao.house.shhouse.mapper;

import cn.jufangbao.house.shhouse.model.TSaSms;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface TSaSmsMapper extends Mapper<TSaSms> {

    TSaSms querySmsWithin1minByRecNum(String recnum);

    TSaSms queryAllowSmsByRecNumAndRandomCode(@Param("recnum") String recnum, @Param("randomcode") String randomcode);
}