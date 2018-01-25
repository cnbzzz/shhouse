package cn.jufangbao.house.shhouse.mapper;

import cn.jufangbao.house.shhouse.dto.*;
import cn.jufangbao.house.shhouse.model.TCmAgent;
import cn.jufangbao.house.shhouse.model.TCmCustomer;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TCmCustomerMapper extends Mapper<TCmCustomer> {

    List<CustSellerDto> listSellerHouse(@Param("seller") String seller, @Param("transtype") String transtype); //transtype不传查全部，1待售，2待租，3已售，4已租

    List<CustAgentDto> listCustAgent(String coid);

    List<CustFollowHouseDto> listCustFollowHouse(@Param("coid") String coid, @Param("followtype") String followtype);

    List<CustFollowCommDto> listCustFollowComm(@Param("coid") String coid);

    List<CustSeenDto> listCustSeenHouse(String coid);

    CustSellerCountDto countSeller(String seller);

    CustFollowCountDto countCustFollow(String coid);

    Long countCustBrowse(String coid);

    Long countHouse(String rent);//rent=0售房，rent=1租房

    List<CustBookingDto> listCustBooking(@Param("coid") String coid, @Param("rent") Long rent);

    List<HouseDto> listBuyerDeal(@Param("boid") String coid, @Param("rent") Long rent);

    List<HouseDto> listSellerDeal(@Param("soid") String coid, @Param("rent") Long rent);

    CustDetailDto queryCustDetailByOid(String custId);
}