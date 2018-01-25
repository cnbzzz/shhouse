package cn.jufangbao.house.shhouse.mapper;

import cn.jufangbao.house.shhouse.model.TCmAgentMessage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TCmAgentMessageMapper extends Mapper<TCmAgentMessage> {

    Long countUnreadMessageByToUserId(String touserid);

    List<Map> countUnreadMessageByToUserIdGroupByFromUserId(String touserid);

    List<TCmAgentMessage> queryHistoryMessage(@Param("touserid") String touserid, @Param("fromuserid") String fromuserid);
}