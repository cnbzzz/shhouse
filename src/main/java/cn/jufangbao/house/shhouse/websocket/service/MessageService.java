package cn.jufangbao.house.shhouse.websocket.service;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.model.TCmAgentMessage;

/**
 * cn.jufangbao.house.shhouse.websocket.service
 * Created by bzzz on 2017-05-06 12:04.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public interface MessageService {

    BaseResp sendMessage(TCmAgentMessage msg);

    BaseResp markMessageReadByToUserId(String toUserId);

    BaseResp queryUnreadMessageByToUserId(String toUserId);

    BaseResp countUnreadMessageByToUserId(String toUserId);

    BaseResp countUnreadMessageByToUserIdGroupByFromUserId(String toUserId);

    BaseResp queryHistoryMessage(String toUserId, String fromUserId);

    BaseResp markMessageReadByFromToUserId(String fromUserId, String toUserId);
}
