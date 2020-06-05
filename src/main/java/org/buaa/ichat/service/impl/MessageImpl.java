package org.buaa.ichat.service.impl;

import org.buaa.ichat.entity.GMSGSend;
import org.buaa.ichat.entity.GroupMSG;
import org.buaa.ichat.entity.Members;
import org.buaa.ichat.entity.Message;
import org.buaa.ichat.mapper.*;
import org.buaa.ichat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessageImpl implements MessageService {
    @Autowired
    GroupMSGMapper groupMSGMapper;
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    GMSGSendMapper gmsgSendMapper;
    @Autowired
    MembersMapper membersMapper;
    @Override
    public void insertMSG(Integer userID, String content, Integer receiverID) throws Exception {
        if (userID == null || content ==null || content.equals("")||receiverID==null)
            throw new  Exception("参数缺失");
        messageMapper.insertMessage(
                Message.Build()
                        .sentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                        .content(content)
                        .receiverID(receiverID)
                        .senderID(userID)
                        .build());
    }

    @Override
    public void insertGMSG(Integer userID, String content, Integer groupID) throws Exception {
        if (userID == null || content ==null || content.equals("")||groupID==null)
            throw new  Exception("参数缺失");
        //添加群消息
        GroupMSG groupMSG = GroupMSG.Build()
                .content(content)
                .time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .senderID(userID)
                .build();
        groupMSGMapper.insertGroupMSG(groupMSG);
        //查询群成员
        List<Members>members = membersMapper.queryMembers(Members.QueryBuild().groupID(groupID).build());
        //为每个群成员添加接受消息记录
        for (Members member:members){
            gmsgSendMapper.insertGMSGSend(
                    GMSGSend.Build()
                            .groupID(groupID)
                            .GM_ID(groupMSG.getGM_ID())
                            .receiverID(member.getMemberID()).build());
        }

    }


}
