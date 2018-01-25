package cn.jufangbao.house.shhouse.service;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.dto.*;
import cn.jufangbao.house.shhouse.model.TCmCustFollow;
import cn.jufangbao.house.shhouse.model.TCmCustomer;
import cn.jufangbao.house.shhouse.model.TResHouseWaiting;

import java.util.List;

/**
 * CustomerService.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:41:35.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public interface CustomerService {


    BaseResp<String> custSignIn(Long phoneNum, String passwd, String wechatId);

    BaseResp<CustDetailDto> oneCust(String oid);
    /**
     * @param seller
     * @param trantype 1待售 2待租 3已售 4已租
     * @return
     */
    BaseResp<List<CustSellerDto>> listSellerHouse(String seller, String trantype);

    /**
     * @param coid
     * @param followtype 1买房 2租房 3小区
     * @return
     */
    BaseResp<List<CustFollowHouseDto>> listCustFollowHouse(String coid, String followtype);

    BaseResp<List<CustFollowCommDto>> listCustFollowComm(String coid);

    /**
     *
     * @param coid
     * @param rent 0买房 1租房
     * @return
     */
    BaseResp<List<CustBookingDto>> listCustBooking(String coid, Long rent);

    BaseResp<List<CustSeenDto>> listCustSeenHouse(String coid);

    BaseResp addCustFollow(String coid, TCmCustFollow param);

    BaseResp delCustFollow(String coid, TCmCustFollow param);

    BaseResp editHouseWaitingByCust(String coid, TResHouseWaiting houseWaiting);

    BaseResp editCustomer(CustDetailDto param);

    BaseResp<List<HouseDto>> listBuyerDeal(String coid, Long rent);

    BaseResp<List<HouseDto>> listSellerDeal(String coid, Long rent);

    BaseResp custForgetPasswd(Long phoneNum);

    BaseResp editCustPasswd(Long phoneNum, String newPasswd);

    BaseResp listCustAgent(String coid);

    BaseResp queryCustomerByPhoneNum(Long phoneNum);
}
