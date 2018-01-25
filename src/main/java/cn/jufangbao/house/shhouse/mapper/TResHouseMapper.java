package cn.jufangbao.house.shhouse.mapper;

import cn.jufangbao.house.shhouse.dto.HouseCountDto;
import cn.jufangbao.house.shhouse.dto.HouseDetailDto;
import cn.jufangbao.house.shhouse.dto.HouseDto;
import cn.jufangbao.house.shhouse.dto.HouseQueryItemDto;
import cn.jufangbao.house.shhouse.model.TResHouse;
import cn.jufangbao.house.shhouse.param.HouseQueryCondParam;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TResHouseMapper extends Mapper<TResHouse> {

    List<HouseDto> listHouseByCond(HouseQueryCondParam param);

    List<HouseDto> listLocalHouseByAgent(List<String> houseidlist);

    HouseDto oneHouse(String oid);

    HouseDetailDto oneHouseDetail(String oid);

    List<HouseQueryItemDto> listHouseQueryItem();

    List<HouseDto> listRecomHouseByAgentId(String oid);

    List<HouseDto> listNativeHouseByAgentId(String oid);

    List<HouseDto> listAgentDealHouse(@Param("aoid") String aoid, @Param("rent") Long rent);

    List<HouseDto> listAgentHouse(@Param("aoid") String aoid, @Param("rent") Long rent);

    HouseCountDto countHouse();

    List<String> queryStrPrompt(@Param("str") String str, @Param("limit") Long limit);
}