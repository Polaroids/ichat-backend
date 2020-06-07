package org.buaa.ichat.service.impl;

import org.buaa.ichat.entity.Friend;
import org.buaa.ichat.entity.FriendReq;
import org.buaa.ichat.entity.Friends;
import org.buaa.ichat.entity.User;
import org.buaa.ichat.mapper.FriendMapper;
import org.buaa.ichat.mapper.FriendReqMapper;
import org.buaa.ichat.mapper.FriendsMapper;
import org.buaa.ichat.mapper.UserMapper;
import org.buaa.ichat.service.FriendService;
import org.buaa.ichat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FriendImpl implements FriendService {
    @Autowired
    UserService userService;
    @Autowired
    FriendReqMapper friendReqMapper;
    @Autowired
    FriendMapper friendMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public void add(Integer senderID, Integer receiverID)throws Exception {
        // 有个BUG，可以重复添加
        if (receiverID == null)
            throw new Exception("参数非法");
        try {
            userService.getInfo(new Integer(receiverID));
        }catch (Exception e){
            throw new Exception("添加的用户不存在");
        }
        FriendReq friendReq = new FriendReq();
        friendReq.setReceiverID(receiverID);
        friendReq.setSenderID(senderID);
        friendReq.setStatus(0);
        friendReq.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        friendReqMapper.insertFriendReq(friendReq);
    }

    @Override
    public void deal(Integer ID,Boolean ans) {
        //这里有个BUG，未验证处理这条申请的人是否是接收者，即只要登录就可以处理任何好友请求
        //还有一个BUG就是，可以重复处理
        Integer status;
        status = ans?1:-1;
        friendReqMapper.update(FriendReq.UpdateBuild()
                .where(FriendReq.ConditionBuild().idList(ID)).set(FriendReq.Build().status(status).build()));
        FriendReq friendReq =  friendReqMapper.queryFriendReqLimit1(FriendReq.QueryBuild().id(ID).build());
        String time =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        if (ans) {
            friendMapper.insertFriend(Friend.Build().friendID(friendReq.getSenderID()).time(time).userID(friendReq.getReceiverID()).build());
            friendMapper.insertFriend(Friend.Build().friendID(friendReq.getReceiverID()).time(time).userID(friendReq.getSenderID()).build());
        }
    }

    @Override
    public List<User> getFriends(Integer userID) {
        List<Friend> friends = friendMapper.queryFriend(Friend.QueryBuild().userID(userID));
        List<Integer> userIDList = new ArrayList<>();
        if (friends.size() == 0)
            return new ArrayList<>();
        for (Friend friend:friends){
            userIDList.add(friend.getFriendID());
        }
        return userMapper.queryUser(User.QueryBuild().UserIDList(userIDList));
    }

    @Override
    public boolean isFriend(Integer ID1, Integer ID2) {
        Friend friend = friendMapper.queryFriendLimit1(Friend.QueryBuild().userID(ID1).friendID(ID2).build());
        return friend != null;
    }

    @Override
    public List<FriendReq> getRelations(Integer userID) {
        return friendReqMapper.queryFriendReq(FriendReq.QueryBuild().receiverID(userID));
    }
}
