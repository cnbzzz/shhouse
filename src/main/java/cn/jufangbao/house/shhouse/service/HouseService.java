package cn.jufangbao.house.shhouse.service;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.dto.HouseDetailDto;
import cn.jufangbao.house.shhouse.dto.HouseDto;
import cn.jufangbao.house.shhouse.dto.HouseQueryItemDto;
import cn.jufangbao.house.shhouse.model.TResBuilding;
import cn.jufangbao.house.shhouse.model.TResComm;
import cn.jufangbao.house.shhouse.model.TResHouse;
import cn.jufangbao.house.shhouse.model.TResHouseHot;
import cn.jufangbao.house.shhouse.param.HouseQueryCondParam;

import java.util.List;
import java.util.Map;

/**
 * HouseService.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:41:39.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public interface HouseService {

    BaseResp<List<HouseDto>> listHouseByCond(HouseQueryCondParam param);

    BaseResp<Map<String, List<HouseQueryItemDto>>> listHouseQueryItem();

    BaseResp<HouseDetailDto> oneHouseDetail(String oid, String aoid, String custId);

    BaseResp<Map<String, HouseDto>> houseCompare(String oid, String otherOid);

    BaseResp editComm(TResComm comm);

    BaseResp editBuilding(TResBuilding building);

    BaseResp editHouse(TResHouse house);

    BaseResp<List<String>> queryStrPrompt(String str, Long limit);

    TResHouseHot plusHouseHot(String oid, Integer browse, Integer seen, Integer follow);

    BaseResp<List<HouseDto>> listHouseByAgentLocal(List<String> houseidlist);
}
