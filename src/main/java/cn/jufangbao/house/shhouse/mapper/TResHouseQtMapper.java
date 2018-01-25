package cn.jufangbao.house.shhouse.mapper;

import cn.jufangbao.house.shhouse.dto.HouseQtDto;
import cn.jufangbao.house.shhouse.model.TResHouseQt;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TResHouseQtMapper extends Mapper<TResHouseQt> {

    List<HouseQtDto> listHouseQtByHouseId(String oid);
}