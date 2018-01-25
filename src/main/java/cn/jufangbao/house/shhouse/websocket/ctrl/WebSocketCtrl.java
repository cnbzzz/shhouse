package cn.jufangbao.house.shhouse.websocket.ctrl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.model.TCmAgentMessage;
import cn.jufangbao.house.shhouse.websocket.service.MessageService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * cn.jufangbao.house.shhouse.websocket.ctrl
 * Created by bzzz on 2017-05-05 20:38.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */

@RestController
@RequestMapping("/msg")
public class WebSocketCtrl {

    protected Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private MessageService messageService;

    /**
     * 给指定用户发送消息方法
     * @return
     */
    @RequestMapping("/sendMessage")
    public String send(@RequestParam("data") String data) {
        log.debug("param is {}", data);
        TCmAgentMessage param = null;
        if(StringUtils.isNotBlank(data)){
            try{
                param = JSON.parseObject(data, TCmAgentMessage.class);
            } catch(JSONException e){
                log.error("json is bad {}", data);
            }
        }
        if(param == null){
            return BaseResp.failResp("发送失败").toString();
        }
        BaseResp resp = messageService.sendMessage(param);
        return resp.toString();
    }

    /**
     * 把某位用户消息标记为已读
     * @return
     */
    @RequestMapping("/markMessageReadByToUserId")
    public String markMessageReadByToUserId(String toUserId) {
        log.debug("param is {}", toUserId);
        BaseResp resp = messageService.markMessageReadByToUserId(toUserId);
        return resp.toString();
    }

    /**
     * 把某位两位用户之间消息标记为已读
     * @return
     */
    @RequestMapping("/markMessageReadByFromToUserId")
    public String markMessageReadByToUserId(@RequestParam("fromUserId") String fromUserId, @RequestParam("toUserId") String toUserId) {
        log.debug("param is {}, {}", fromUserId, toUserId);
        BaseResp resp = messageService.markMessageReadByFromToUserId(fromUserId, toUserId);
        return resp.toString();
    }

    /**
     * 查询某位用户消息未读消息
     * @return
     */
    @RequestMapping("/queryUnreadMessageByToUserId")
    public String queryUnreadMessageByToUserId(String toUserId) {
        log.debug("param is {}", toUserId);
        BaseResp resp = messageService.queryUnreadMessageByToUserId(toUserId);
        return resp.toString();
    }

    /**
     * 查询接收方和发送方历史消息
     * @return
     */
    @RequestMapping("/queryHistoryMessage")
    public String queryHistoryMessage(String toUserId, String fromUserId) {
        log.debug("param is {}, {}", toUserId, fromUserId);
        BaseResp resp = messageService.queryHistoryMessage(toUserId, fromUserId);
        return resp.toString();
    }

    /**
     * 查询某位用户消息未读消息数量
     * @return
     */
    @RequestMapping("/countUnreadMessageByToUserId")
    public String countUnreadMessageByToUserId(String toUserId) {
        log.debug("param is {}", toUserId);
        BaseResp resp = messageService.countUnreadMessageByToUserId(toUserId);
        return resp.toString();
    }

    /**
     * 查询某位用户消息未读消息数量按照发送方分组
     * @return
     */
    @RequestMapping("/countUnreadMessageByToUserIdGroupByFromUserId")
    public String countUnreadMessageByToUserIdGroupByFromUserId(String toUserId) {
        log.debug("param is {}", toUserId);
        BaseResp resp = messageService.countUnreadMessageByToUserIdGroupByFromUserId(toUserId);
        return resp.toString();
    }
}
