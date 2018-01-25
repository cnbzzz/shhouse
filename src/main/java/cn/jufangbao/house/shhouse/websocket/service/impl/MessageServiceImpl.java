package cn.jufangbao.house.shhouse.websocket.service.impl;

import cn.jufangbao.house.shhouse.base.BaseResp;
import cn.jufangbao.house.shhouse.mapper.TCmAgentMessageMapper;
import cn.jufangbao.house.shhouse.model.TCmAgentMessage;
import cn.jufangbao.house.shhouse.websocket.service.MessageService;
import com.google.common.base.Preconditions;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

/**
 * cn.jufangbao.house.shhouse.websocket.service.impl
 * Created by bzzz on 2017-05-06 12:04.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class MessageServiceImpl implements MessageService {

    private Logger log = LogManager.getLogger();

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @Resource
    private TCmAgentMessageMapper agentMessageMapper;

    public BaseResp sendMessage(TCmAgentMessage msg){
        BaseResp resp = BaseResp.succResp("发送成功");
        try{
            Preconditions.checkArgument(msg != null, "消息为空");

            String fromuserid = msg.getFromuserid();
            Preconditions.checkArgument(StringUtils.isNotBlank(fromuserid), "发送方为空");

            String touserid = msg.getTouserid();
            Preconditions.checkArgument(StringUtils.isNotBlank(touserid), "接收方为空");

            String content = msg.getContent();
            Preconditions.checkArgument(StringUtils.isNotBlank(content), "消息内容为空");

            String msgtype = msg.getMsgtype();
            if(StringUtils.isBlank(msgtype)){
                msgtype = "Text";
            }
            msg.setMsgtype(msgtype);

            msg.setCreatetime(new Date());
            msg.setStatus(0);
            agentMessageMapper.insertSelective(msg);
            simpMessagingTemplate.convertAndSendToUser(touserid, "/message", msg);
            resp.setData(msg);
        }catch (IllegalStateException | IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp(e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp("发送失败");
        }
        return resp;
    }

    public BaseResp markMessageReadByToUserId(String toUserId){
        BaseResp resp = BaseResp.succResp("操作成功");
        try{
            Preconditions.checkArgument(StringUtils.isNotBlank(toUserId), "接收方id为空");

            TCmAgentMessage message = new TCmAgentMessage();
            message.setStatus(1);
            if(message != null){
                Example example = new Example(TCmAgentMessage.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("touserid", toUserId);
                criteria.andEqualTo("status", 0);
                agentMessageMapper.updateByExampleSelective(message, example);
            }
        }catch (IllegalStateException | IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp(e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp("操作失败");
        }
        return resp;
    }

    public BaseResp markMessageReadByFromToUserId(String fromUserId, String toUserId){
        BaseResp resp = BaseResp.succResp("操作成功");
        try{
            Preconditions.checkArgument(StringUtils.isNotBlank(toUserId), "接收方id为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(fromUserId), "发送方id为空");

            TCmAgentMessage message = new TCmAgentMessage();
            message.setStatus(1);
            if(message != null){
                Example example = new Example(TCmAgentMessage.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("touserid", toUserId);
                criteria.andEqualTo("fromuserid", fromUserId);
                criteria.andEqualTo("status", 0);
                agentMessageMapper.updateByExampleSelective(message, example);
            }
        }catch (IllegalStateException | IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp(e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp("操作失败");
        }
        return resp;
    }

    public BaseResp countUnreadMessageByToUserId(String toUserId){
        BaseResp resp = BaseResp.succResp("操作成功");
        try{
            Preconditions.checkArgument(StringUtils.isNotBlank(toUserId), "接收方id为空");
            Long count = agentMessageMapper.countUnreadMessageByToUserId(toUserId);
            resp.setData(count);
        }catch (IllegalStateException | IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp(e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp("操作失败");
        }
        return resp;
    }

    public BaseResp countUnreadMessageByToUserIdGroupByFromUserId(String toUserId){
        BaseResp resp = BaseResp.succResp("操作成功");
        try{
            Preconditions.checkArgument(StringUtils.isNotBlank(toUserId), "接收方id为空");
            List<Map> list = agentMessageMapper.countUnreadMessageByToUserIdGroupByFromUserId(toUserId);
            resp.setData(list);
        }catch (IllegalStateException | IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp(e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp("操作失败");
        }
        return resp;
    }


    public BaseResp queryUnreadMessageByToUserId(String toUserId){
        BaseResp resp = BaseResp.succResp("操作成功");
        try{
            Preconditions.checkArgument(StringUtils.isNotBlank(toUserId), "消息id为空");

            Example example = new Example(TCmAgentMessage.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("touserid", toUserId);
            criteria.andEqualTo("status", 0);
            example.setOrderByClause("createtime asc");
            List<TCmAgentMessage> messageList = agentMessageMapper.selectByExample(example);
            resp.setData(messageList);
        }catch (IllegalStateException | IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp(e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp("操作失败");
        }
        return resp;
    }


    public BaseResp queryHistoryMessage(String toUserId, String fromUserId){
        BaseResp resp = BaseResp.succResp("操作成功");
        try{
            Preconditions.checkArgument(StringUtils.isNotBlank(toUserId), "接收方id为空");
            Preconditions.checkArgument(StringUtils.isNotBlank(fromUserId), "发送方id为空");

            List<TCmAgentMessage> messageList = agentMessageMapper.queryHistoryMessage(toUserId, fromUserId);
            resp.setData(messageList);
        }catch (IllegalStateException | IllegalArgumentException e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp(e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage(), e);
            resp = BaseResp.failResp("操作失败");
        }
        return resp;
    }
}
