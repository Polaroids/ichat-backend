package org.buaa.ichat.service.impl;

import org.buaa.ichat.entity.Group;
import org.buaa.ichat.entity.Members;
import org.buaa.ichat.entity.User;
import org.buaa.ichat.mapper.GroupMapper;
import org.buaa.ichat.mapper.MembersMapper;
import org.buaa.ichat.mapper.UserMapper;
import org.buaa.ichat.service.FriendService;
import org.buaa.ichat.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GroupImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    MembersMapper membersMapper;
    @Autowired
    FriendService friendService;
    @Autowired
    UserMapper userMapper;
    @Override
    public void create(Integer userID, String name, String des, String avatar, String[] members)throws Exception {
        Group group = Group.Build()
                .name(name)
                .avatar(avatar)
                .description(des)
                .owner(userID)
                .createTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).build();
        groupMapper.insertGroup(group);
        List<Integer> fails = new ArrayList<>();

        membersMapper.insertMembers(
                Members.Build()
                        .memberID(userID)
                        .time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                        .groupID(group.getGroupID()).inviterID(userID)
                        .build());

        for (String member:members){
            if (friendService.isFriend(userID,new Integer(member)))
                membersMapper.insertMembers(
                        Members.Build()
                                .memberID(new Integer(member))
                                .time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                                .groupID(group.getGroupID()).inviterID(userID)
                                .build());
            else fails.add(new Integer(member));
        }
        if (fails.size() != 0)
            throw new Exception("群已经成功创建但部分非好友无法拉进群聊");
    }

    @Override
    public boolean isManager(Integer userID, Integer groupID) {
        return groupMapper.queryGroupLimit1(Group.QueryBuild().owner(userID).groupID(groupID)) != null;
    }

    @Override
    public void invite(Integer userID, Integer groupID, Integer[] friendIDs)throws Exception {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        for (Integer friendID:friendIDs) {
            System.out.println(friendID);
            System.out.println(groupID);
            if (!friendService.isFriend(userID, friendID))
                throw new Exception("不可邀请非好友");
//        if (!isManager(userID,groupID))
//            throw new Exception("只有管理员可以邀请好友入群");

            membersMapper.insertMembers(Members.Build().time(time).groupID(groupID).inviterID(userID).memberID(friendID).build());
        }
    }

    @Override
    public void quit(Integer userID, Integer groupID) throws Exception{
        if (groupID == null)
            throw new Exception("groupID不可为空");
        //BUG，群主解散未考虑
        if (
        membersMapper.queryMembersLimit1(Members.Build().memberID(userID).groupID(groupID).build()) == null)
            throw new Exception("操作失败，您已不在当前的群中");
        membersMapper.quit(userID,groupID);
    }

    @Override
    public List<User> getMembers(Integer groupID) throws Exception {
        if (groupID == null)
            throw new Exception("groupID不可为空");
        if (null==groupMapper.queryGroupLimit1(Group.QueryBuild().groupID(groupID).build()))
            throw new  Exception("该群聊不存在");
        List<Members> members = membersMapper.queryMembers(Members.QueryBuild().groupID(groupID).build());
        List<Integer> membersID = new ArrayList<>();
        for (Members member:members){
            membersID.add( member.getMemberID());
        }
        if (members.size() == 0)
            throw new Exception("无成员，未知异常");
        return userMapper.queryUser(User.QueryBuild().UserIDList(membersID));
    }

    @Override
    public List<Group> getGroups(Integer userID) {

        List<Members> members= membersMapper.queryMembers(Members.QueryBuild().memberID(userID));
        List<Integer> groupIDs  = new ArrayList<>();
        for (Members member:members){
            groupIDs.add(member.getGroupID());
        }

        return groupMapper.queryGroup(Group.QueryBuild().groupIDList(groupIDs).build());
    }
}

