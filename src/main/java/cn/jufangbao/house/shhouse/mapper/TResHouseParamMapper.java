package cn.jufangbao.house.shhouse.mapper;

import cn.jufangbao.house.shhouse.model.TResHouseParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TResHouseParamMapper extends Mapper<TResHouseParam> {

    List<TResHouseParam> listByHoid(String hoid);
}