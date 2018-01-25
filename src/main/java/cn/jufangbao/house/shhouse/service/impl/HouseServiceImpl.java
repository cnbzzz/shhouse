package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.base.BaseServiceImpl;
import cn.jufangbao.house.shhouse.dto.*;
import cn.jufangbao.house.shhouse.mapper.*;
import cn.jufangbao.house.shhouse.model.*;
import cn.jufangbao.house.shhouse.param.HouseQueryCondParam;
import cn.jufangbao.house.shhouse.service.HouseService;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * HouseServiceImpl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:40:13.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class HouseServiceImpl extends BaseServiceImpl implements HouseService {

    @Resource
    private TResHouseMapper houseMapper;

    @Resource
    private TResBuildingMapper buildingMapper;

    @Resource
    private TSaImagesMapper imagesMapper;

    @Resource
    private TResHouseParamMapper paramMapper;

    @Resource
    private TResHouseQtMapper qtMapper;

    @Resource
    private TResCommMapper commMapper;

    @Resource
    private TResCommPropMapper commPropMapper;

    @Resource
    private TResCommSaleMapper commSaleMapper;

    @Resource
    private TResHouseHotMapper houseHotMapper;

    @Resource
    private TResHouseLoanMapper houseLoanMapper;

    @Resource
    private TCmAgentFollowMapper agentFollowMapper;

    @Resource
    private TCmCustFollowMapper custFollowMapper;

    @Resource
    private TResHlayoutMapper hlayoutMapper;

    @Resource
    private TResCommPtrendMapper commPtrendMapper;

    public BaseResp editComm(TResComm comm){
        BaseResp resp = succ("新增成功");
        try {
            Preconditions.checkArgument(comm != null, "小区为空");
            if(StringUtils.isBlank(comm.getOid())){
                commMapper.insertSelective(comm);
                resp.setRetMsg("新增成功");
            } else{
                commMapper.updateByPrimaryKeySelective(comm);
                resp.setRetMsg("修改成功");
            }
        } catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<List<String>> queryStrPrompt(String str, Long limit){
        BaseResp resp = succ("新增成功");
        try {
            if(StringUtils.isNotBlank(str)){
                if(limit == null || limit > 10l){
                    limit =10l;
                }
                List<String> list = houseMapper.queryStrPrompt(str, limit);
                resp.setData(list);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp editBuilding(TResBuilding building){
        BaseResp resp = succ("新增成功");
        try {
            Preconditions.checkArgument(building != null, "楼栋为空");
            if(StringUtils.isBlank(building.getOid())){
                buildingMapper.insertSelective(building);
                resp.setRetMsg("新增成功");
            } else{
                buildingMapper.updateByPrimaryKeySelective(building);
                resp.setRetMsg("修改成功");
            }
        } catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp editHouse(TResHouse house){
        BaseResp resp = succ("新增成功");
        try {
            Preconditions.checkArgument(house != null, "房源为空");
            if(StringUtils.isBlank(house.getOid())){
                houseMapper.insertSelective(house);
                resp.setRetMsg("新增成功");
            } else{
                houseMapper.updateByPrimaryKeySelective(house);
                resp.setRetMsg("修改成功");
            }
        } catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<Map<String, HouseDto>> houseCompare(String oid, String otherOid){
        BaseResp resp = succ("查询成功");
        try{
            Preconditions.checkArgument(StringUtils.isNotBlank(oid), "oid为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(oid), "otherOid为空");

            HouseDto one = houseMapper.oneHouse(oid);
            Preconditions.checkArgument(one != null, "房源未找到", oid);

            HouseDto otherOne = houseMapper.oneHouse(otherOid);
            Preconditions.checkArgument(otherOne != null, "房源未找到", otherOid);

            Map<String, HouseDto> map = new HashMap<>();
            map.put("one", one);
            map.put("otherOne", otherOne);
            resp.setData(map);
        } catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<List<HouseDto>> listHouseByCond(HouseQueryCondParam param) {
        BaseResp<List<HouseDto>> resp = succ("查询成功");
        try {
            if (param != null)
                PageHelper.startPage(param.getPageNum(), param.getPageSize());

            List<HouseDto> list = houseMapper.listHouseByCond(param);
            resp.setData(list);
        } catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<HouseDetailDto> oneHouseDetail(String oid, String aoid, String custId) {
        BaseResp<HouseDetailDto> resp = succ("查询成功");
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(oid), "参数为空");
            HouseDetailDto dto = houseMapper.oneHouseDetail(oid);
            Preconditions.checkArgument(dto != null, "查询失败, oid is [%s]", oid);
            String groupid = dto.getIgroupoid();
            if(groupid != null){
                TSaImages imageParam = new TSaImages();
                imageParam.setIgroupoid(groupid);
                imageParam.setStatus(1);
                dto.setImageList(imagesMapper.select(imageParam));
            }
            TResHouseParam houseParamParam = new TResHouseParam();
            houseParamParam.setHoid(oid);
            houseParamParam.setStatus(1);
            dto.setParamList(paramMapper.listByHoid(oid));
            dto.setHouseQtList(getTreeHouseQt(qtMapper.listHouseQtByHouseId(oid)));
            String commId = dto.getCoid();
            if(commId != null){
                dto.setCommunity(commMapper.selectByPrimaryKey(commId));
                TResCommProp commPropParam = new TResCommProp();
                commPropParam.setCoid(commId);
                commPropParam.setStatus(1);
                dto.setCommPropList(commPropMapper.select(commPropParam));
                dto.setCommSale(commSaleMapper.selectByPrimaryKey(commId));

                TResCommPtrend tmp = new TResCommPtrend();
                tmp.setCoid(commId);
                tmp.setStatus(1);
                dto.setCommPtrendList(commPtrendMapper.select(tmp));

                if(StringUtils.isNotBlank(aoid)){
                    TCmAgentFollow param = new TCmAgentFollow();
                    param.setAoid(aoid);
                    param.setFollowtype("3");//1买房 2租房 3小区
                    param.setFollow(commId);
                    List<TCmAgentFollow> select = agentFollowMapper.select(param);
                    dto.setIsFollowComm(select.size() > 0 ? 1 : 0);
                }
                if(StringUtils.isNotBlank(custId)){
                    TCmCustFollow param = new TCmCustFollow();
                    param.setCoid(custId);
                    param.setFollowtype("3");//1买房 2租房 3小区
                    param.setFollow(commId);
                    List<TCmCustFollow> select = custFollowMapper.select(param);
                    dto.setIsFollowComm(select.size() > 0 ? 1 : 0);
                }
            }
            TResHouseHot houseHot = plusHouseHot(oid, 1, 0, 0);
            dto.setHouseHot(houseHot);
            dto.setHouseLoan(houseLoanMapper.selectByPrimaryKey(oid));

            if(StringUtils.isNotBlank(aoid)){
                TCmAgentFollow param = new TCmAgentFollow();
                param.setAoid(aoid);
                param.setFollowtype("1");//1买房 2租房 3小区
                param.setFollow(oid);
                List<TCmAgentFollow> select = agentFollowMapper.select(param);
                dto.setIsFollowHouse(select.size() > 0 ? 1 : 0);

                Integer isFollowHouse = dto.getIsFollowHouse();
                if(isFollowHouse == 0){
                    param.setFollowtype("2");//1买房 2租房 3小区
                    List<TCmAgentFollow> tmp = agentFollowMapper.select(param);
                    dto.setIsFollowHouse(tmp.size() > 0 ? 1 : 0);
                }
            }

            if(StringUtils.isNotBlank(custId)){
                TCmCustFollow param = new TCmCustFollow();
                param.setCoid(custId);
                param.setFollowtype("1");//1买房 2租房 3小区
                param.setFollow(oid);
                List<TCmCustFollow> select = custFollowMapper.select(param);
                dto.setIsFollowHouse(select.size() > 0 ? 1 : 0);

                Integer isFollowHouse = dto.getIsFollowHouse();
                if(isFollowHouse == 0){
                    param.setFollowtype("2");//1买房 2租房 3小区
                    List<TCmCustFollow> tmp = custFollowMapper.select(param);
                    dto.setIsFollowHouse(tmp.size() > 0 ? 1 : 0);
                }
            }

            dto.setHlipath(hlayoutMapper.getHlipathByHoid(oid));
            resp.setData(dto);
        } catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public TResHouseHot plusHouseHot(String oid, Integer browse, Integer seen, Integer follow) {
        TResHouseHot tmp = new TResHouseHot();
        tmp.setOid(oid);
        TResHouseHot houseHot = houseHotMapper.selectOne(tmp);
        if(houseHot == null){
            houseHot = new TResHouseHot();
            houseHot.setOid(oid);
            houseHot.setBrowse(browse);
            houseHot.setSeen(seen);
            houseHot.setFollow(follow);
            houseHot.setCdate(new Date());
            houseHot.setStatus(1);
            houseHotMapper.insertSelective(houseHot);
        } else{
            Integer tmpbrowse = houseHot.getBrowse();
            if(tmpbrowse == null){
                tmpbrowse = 0;
            }
            houseHot.setBrowse(tmpbrowse + browse);
            Integer tmpseen = houseHot.getSeen();
            if(tmpseen == null){
                tmpseen = 0;
            }
            houseHot.setSeen(tmpseen + seen);
            Integer tmpfollow = houseHot.getFollow();
            if(tmpfollow == null){
                tmpfollow = 0;
            }
            houseHot.setFollow(tmpfollow + follow);
            houseHotMapper.updateByPrimaryKeySelective(houseHot);
        }
        return houseHot;
    }

    @Override
    public BaseResp<List<HouseDto>> listHouseByAgentLocal(List<String> houseidlist) {
        BaseResp<List<HouseDto>> resp = succ("查询成功");
        try {
            List<HouseDto> list = null;
            if ( houseidlist != null  ) list = houseMapper.listLocalHouseByAgent(houseidlist);
            else resp = fail("输入的参数为空");
            resp.setData(list);
        } catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    public BaseResp<Map<String, List<HouseQueryItemDto>>> listHouseQueryItem() {
        BaseResp<Map<String, List<HouseQueryItemDto>>> resp = succ("查询成功");
        try {
            List<HouseQueryItemDto> list = houseMapper.listHouseQueryItem();
            List<HouseQueryItemDto> metro = getHouseQueryItemByType(list, HouseQueryItemDto.METRO);
            List<HouseQueryItemDto> county = getHouseQueryItemByType(list, HouseQueryItemDto.COUNTY);
            List<HouseQueryItemDto> orie = getHouseQueryItemByType(list, HouseQueryItemDto.ORIE);
            List<HouseQueryItemDto> label = getHouseQueryItemByType(list, HouseQueryItemDto.LABEL);
            List<HouseQueryItemDto> layout = getHouseQueryItemByType(list, HouseQueryItemDto.LAYOUT);
            ImmutableMap<String, List<HouseQueryItemDto>> map = ImmutableMap.of(HouseQueryItemDto.METRO, metro, HouseQueryItemDto.COUNTY, county, HouseQueryItemDto.ORIE, orie, HouseQueryItemDto.LABEL, label, HouseQueryItemDto.LAYOUT, layout);
            resp.setData(map);
        } catch (IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = fail(e.getMessage());
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            resp = fail();
        }
        return resp;
    }

    private List<HouseQueryItemDto> getHouseQueryItemByType(List<HouseQueryItemDto> list, String type) {
        List<HouseQueryItemDto> result = new ArrayList<>();
        for (HouseQueryItemDto tmp : list) {
            List<HouseQueryItemDto> tmpList = new ArrayList<>();
            if (StringUtils.equals(type, tmp.getType()) && StringUtils.isBlank(tmp.getPid())) {
                for (HouseQueryItemDto o : list) {
                    String pid = o.getPid();
                    if (StringUtils.equals(tmp.getDictid(), pid) && StringUtils.equals(type, o.getType())) {
                        tmpList.add(o);
                    }
                }
                tmp.setChildren(tmpList);
                result.add(tmp);
            }
        }
        return result;
    }

    private List<HouseQtType> getTreeHouseQt(List<HouseQtDto> list){
        List<HouseQtType> result = new ArrayList<>();
        Map<String, List<HouseQtDto>> houseQtMap = new HashMap<>(); //key是clazoid
        Map<String, List<HouseQtClazz>> houseQtClazzMap = new HashMap<>(); //key是qttype
        Map<String, HouseQtType> houseQtTypeMap = new HashMap<>();//key是qttype
        for (HouseQtDto dto : list) { //把对象分类
            String clazoid = dto.getClazoid();
            List<HouseQtDto> houseQtDtos = houseQtMap.get(clazoid);
            if(houseQtDtos == null){
                houseQtDtos = new ArrayList<>();
            }
            houseQtDtos.add(dto);
            houseQtMap.put(clazoid, houseQtDtos);

            String qttype = dto.getQttype();
            List<HouseQtClazz> qtClazzList = houseQtClazzMap.get(qttype);
            if(qtClazzList == null){
                qtClazzList = new ArrayList<>();
            }

            boolean isExist = false;
            for (HouseQtClazz tmp : qtClazzList) {
                if(StringUtils.isBlank(clazoid)){
                    isExist = true;
                    break;
                }
                if(clazoid.equals(tmp.getKey())){
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                qtClazzList.add(new HouseQtClazz(clazoid, dto.getClazzname()));
            }

            houseQtClazzMap.put(qttype, qtClazzList);

            HouseQtType qtType = houseQtTypeMap.get(qttype);
            if(qtType == null){
                String dictname = dto.getDictname();
                houseQtTypeMap.put(qttype, new HouseQtType(qttype, dictname));
            }
        }

        for (HouseQtType qtType: houseQtTypeMap.values()) {
            qtType.setChildren(houseQtClazzMap.get(qtType.getKey()));
            result.add(qtType);
        }

        Collection<List<HouseQtClazz>> tmpQtClazzColl = houseQtClazzMap.values();
        for (List<HouseQtClazz> tmpQtClazzList: tmpQtClazzColl) {
            for (HouseQtClazz qtClazz: tmpQtClazzList) {
                qtClazz.setChildren(houseQtMap.get(qtClazz.getKey()));
            }
        }

        return result;
    }
}
