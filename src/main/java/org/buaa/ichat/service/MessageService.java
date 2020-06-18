package org.buaa.ichat.service;

import org.buaa.ichat.entity.Group;
import org.buaa.ichat.entity.GroupMSG;
import org.buaa.ichat.entity.Message;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface MessageService {
    //单独聊天的消息
    public Integer insertMSG(Integer userID,String content,Integer receiverID)throws Exception;
    public Integer insertGMSG(Integer userID,String content,Integer groupID)throws Exception;
    public Message getMSGByID(Integer messageID)throws Exception;
    public List<Message> getNoSendMSG(Integer userID, Integer receiverID)throws Exception;
    public GroupMSG getGMSGByID(Integer GM_ID)throws Exception;
    public List<GroupMSG> getNoSendGMSG(Integer groupID, Integer receiverID)throws Exception;
    public void updateNoSentMSG(Integer userID)throws Exception;
    public void updateNoSentGMSG(Integer groupID)throws Exception;
    public List<Message> getHistoryMSG(Integer userID, Integer msgID)throws Exception;
    public List<GroupMSG> getHistoryGMSG(Integer groupID, Integer gmsgID)throws Exception;
    public List<JSONObject> getChatList()throws Exception;
    public Integer getGroupIDByGMSG(Integer GM_ID)throws Exception;
}
