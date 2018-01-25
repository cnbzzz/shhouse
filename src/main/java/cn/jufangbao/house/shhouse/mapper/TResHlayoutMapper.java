package cn.jufangbao.house.shhouse.mapper;

import cn.jufangbao.house.shhouse.model.TResHlayout;
import tk.mybatis.mapper.common.Mapper;

public interface TResHlayoutMapper extends Mapper<TResHlayout> {

    String getHlipathByHoid(String hoid);
}