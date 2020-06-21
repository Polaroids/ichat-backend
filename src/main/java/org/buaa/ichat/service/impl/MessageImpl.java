package org.buaa.ichat.service.impl;

import org.apache.shiro.SecurityUtils;
import org.buaa.ichat.entity.*;
import org.buaa.ichat.mapper.*;
import org.buaa.ichat.service.FriendService;
import org.buaa.ichat.service.GroupService;
import org.buaa.ichat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @Autowired
    FriendService friendService;
    @Autowired
    GroupService groupService;
    @Override
    public Integer insertMSG(Integer userID, String content, Integer receiverID) throws Exception {
        if (userID == null || content ==null || content.equals("")||receiverID==null)
            throw new  Exception("参数缺失");
        Message message = Message.Build()
                                .sentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                                .content(content)
                                .receiverID(receiverID)
                                .senderID(userID)
                                .build();
        messageMapper.insertMessage(message);
        return message.getMessageID();
    }

    @Override
    public Integer insertGMSG(Integer userID, String content, Integer groupID) throws Exception {
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
        return groupMSG.getGM_ID();
    }

    @Override
    public Message getMSGByID(Integer messageID) throws Exception
    {
        if(messageID == null)
            throw new Exception("参数缺失");
        Message con = Message.QueryBuild().messageID(messageID).build();
        Message ans = messageMapper.queryMessageLimit1(con);
        if(ans == null)
            throw new Exception("不存在的私聊消息");
        return ans;
    }

    @Override
    public List<Message> getNoSendMSG(Integer userID, Integer receiverID) throws Exception
    {
        if(receiverID == null || userID == null)
            throw new Exception("参数缺失");
        List<Message> messages = messageMapper.queryMessage(Message.QueryBuild().senderID(userID).receiverID(receiverID).sent(0).build());

        return messages;
    }

    @Override
    public GroupMSG getGMSGByID(Integer GM_ID) throws Exception
    {
        if(GM_ID == null)
            throw new Exception("参数缺失");
        GroupMSG con = GroupMSG.QueryBuild().GM_ID(GM_ID).build();
        GroupMSG ans = groupMSGMapper.queryGroupMSGLimit1(con);
        if(ans == null)
            throw new Exception("不存在的群聊消息");
        return ans;
    }

    @Override
    public List<GroupMSG> getNoSendGMSG(Integer groupID, Integer receiverID) throws Exception
    {
        if(receiverID == null || groupID == null)
            throw new Exception("参数缺失");
        List<GMSGSend> gmsgSends = gmsgSendMapper.queryGMSGSend(GMSGSend.QueryBuild().groupID(groupID).receiverID(receiverID).status(0).build());
        List<Integer> gm_IDList = new ArrayList<>();

        for(GMSGSend gmsgSend: gmsgSends)
            gm_IDList.add(gmsgSend.getGM_ID());

        if(gm_IDList.size() <= 0)
            return new ArrayList<>();
        return groupMSGMapper.queryGroupMSG(GroupMSG.QueryBuild().GM_IDList(gm_IDList));
    }

    @Override
    public void updateNoSentMSG(Integer userID) throws Exception
    {
        if(userID == null)
            throw new Exception("参数缺失");

        Integer ID = new Integer((String)SecurityUtils.getSubject().getPrincipal());
        Message.UpdateBuilder updateBuilder = Message.UpdateBuild();
        updateBuilder
                .set(
                        Message.Build()
                                .sent(1).build())
                .where(Message.ConditionBuild().senderIDList(userID).receiverIDList(ID).build());
        messageMapper.update(updateBuilder.build());
    }

    @Override
    public void updateNoSentGMSG(Integer groupID) throws Exception
    {
        if(groupID == null)
            throw new Exception("参数缺失");

        Integer ID = new Integer((String)SecurityUtils.getSubject().getPrincipal());
        GMSGSend.UpdateBuilder updateBuilder = GMSGSend.UpdateBuild();
        updateBuilder
                .set(
                        GMSGSend.Build()
                                .status(1).build())
                .where(GMSGSend.ConditionBuild().groupIDList(groupID).receiverIDList(ID).build());
        gmsgSendMapper.update(updateBuilder.build());
    }

    @Override
    public List<Message> getHistoryMSG(Integer userID, Integer msgID) throws Exception
    {

        if(userID == null || msgID == null)
            throw new Exception("参数缺失");
        Integer ID = new Integer((String) SecurityUtils.getSubject().getPrincipal());
        List<Message> rightMessages = new ArrayList<>();
        List<Message> leftMessages = new ArrayList<>();

        if(msgID < 0)
        {
            rightMessages = messageMapper.queryMessage(Message.QueryBuild().senderID(ID).receiverID(userID).build());
            leftMessages = messageMapper.queryMessage(Message.QueryBuild().senderID(userID).receiverID(ID).build());
            // return getNoSendMSG(userID, ID);
        }
        else
        {
            rightMessages = messageMapper.queryMessage(Message.QueryBuild().senderID(ID).receiverID(userID).messageIDLessEqThan(msgID).build());
            leftMessages = messageMapper.queryMessage(Message.QueryBuild().senderID(userID).receiverID(ID).messageIDLessEqThan(msgID).build());
        }

        List<Message> ans = new ArrayList<>();
        int rn = rightMessages.size() - 1;
        int ln = leftMessages.size() - 1;

        while(ans.size() < 30)
        {
            if(ln < 0 && rn < 0)
                break;
            if(ln < 0)
            {
                ans.add(rightMessages.get(rn));
                rightMessages.remove(rn);
                rn--;
            }
            else if(rn < 0)
            {
                ans.add(leftMessages.get(ln));
                leftMessages.remove(ln);
                ln--;
            }
            else if(rightMessages.get(rn).getMessageID() > leftMessages.get(ln).getMessageID())
            {
                ans.add(rightMessages.get(rn));
                rightMessages.remove(rn);
                rn--;
            }
            else if(rightMessages.get(rn).getMessageID() < leftMessages.get(ln).getMessageID())
            {
                ans.add(leftMessages.get(ln));
                leftMessages.remove(ln);
                ln--;
            }
        }

        return ans;
    }

    @Override
    public List<GroupMSG> getHistoryGMSG(Integer groupID, Integer gmsgID) throws Exception
    {
        if(groupID == null || gmsgID == null)
            throw new Exception("参数缺失");
        Integer ID = new Integer((String)SecurityUtils.getSubject().getPrincipal());

        List<GroupMSG> groupMSGs = groupMSGMapper.getGroupMsgByID(groupID);
        Integer groupMSGsIndex = groupMSGs.size() - 1;

        List<GroupMSG> ans = new ArrayList<>();

        //latest 30 gmsgs
        if(gmsgID < 0)
        {
            while(ans.size() < 30 && groupMSGsIndex >= 0)
            {
                ans.add(groupMSGs.get(groupMSGsIndex));
                groupMSGsIndex --;
            }
            return ans;
        }
        else
        {
            while(groupMSGsIndex >= 0 && groupMSGs.get(groupMSGsIndex).getGM_ID() > gmsgID)
            {
                groupMSGs.remove(groupMSGsIndex);
                groupMSGsIndex --;
            }
        }


        if(groupMSGsIndex < 29)
            return groupMSGs;
        else
            return groupMSGs.subList(groupMSGsIndex - 29, groupMSGsIndex);
    }

    @Override
    public List<JSONObject> getChatList() throws Exception
    {
        Integer ID = new Integer((String)SecurityUtils.getSubject().getPrincipal());

        List<User> friends = friendService.getFriends(ID);
        List<Group> groups = groupService.getGroups(ID);

        Integer noSendNum;
        Integer historyNum;

        List<JSONObject> ans = new ArrayList<JSONObject>();

        for(User friend: friends)
        {
            List<Message> latestMSGs = getHistoryMSG(friend.getUserID(), -1);
            historyNum = latestMSGs.size();
            //聊天列表只需要有历史消息的聊天
            if(latestMSGs.size() <= 0)
                continue;

            //有历史消息的再检查有没有未读消息
            List<Message> noSendMSG = getNoSendMSG(friend.getUserID(), ID);
            noSendNum = noSendMSG.size();

            //聊天列表只需要有未读消息的聊天
            //改需求了 cnm
            //if(noSendNum <= 0)
            //    continue;

            //Message lastMSG = noSendMSG.get(noSendNum - 1);
            Message lastMSG = latestMSGs.get(0);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID", friend.getUserID());
            jsonObject.put("name", friend.getUsername());
            jsonObject.put("avatar", friend.getAvatar());
            jsonObject.put("type", 0);
            jsonObject.put("num", noSendNum);
            jsonObject.put("time", lastMSG.getSentTime());

            ans.add(jsonObject);
        }

        for(Group group: groups)
        {
            List<GroupMSG> latestGMSGs = getHistoryGMSG(group.getGroupID(), -1);
            historyNum = latestGMSGs.size();
            if(latestGMSGs.size() <= 0)
                continue;

            List<GroupMSG> noSendGMSG = getNoSendGMSG(group.getGroupID(), ID);
            noSendNum = noSendGMSG.size();

            //if(noSendNum <= 0)
            //    continue;

            //GroupMSG lastGMSG = noSendGMSG.get(noSendNum - 1);
            GroupMSG lastGMSG = latestGMSGs.get(0);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ID", group.getGroupID());
            jsonObject.put("name", group.getName());
            jsonObject.put("avatar", group.getAvatar());
            jsonObject.put("type", 1);
            jsonObject.put("num", noSendNum);
            jsonObject.put("time", lastGMSG.getTime());

            ans.add(jsonObject);
        }

        return ans;
    }

    public Integer getGroupIDByGMSG(Integer GM_ID) throws Exception
    {
        if(GM_ID == null)
            throw new Exception("参数缺失");

        GMSGSend gmsgSend = gmsgSendMapper.queryGMSGSendLimit1(GMSGSend.QueryBuild().GM_ID(GM_ID).build());
        return gmsgSend.getGroupID();
    }

}
