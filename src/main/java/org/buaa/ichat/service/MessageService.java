package org.buaa.ichat.service;

public interface MessageService {
    //单独聊天的消息
    public void insertMSG(Integer userID,String content,Integer receiverID)throws Exception;
    public void insertGMSG(Integer userID,String content,Integer groupID)throws Exception;
}
