package org.buaa.ichat.service.impl;

import org.buaa.ichat.entity.Friends;
import org.buaa.ichat.entity.User;
import org.buaa.ichat.mapper.FriendsMapper;
import org.buaa.ichat.service.FriendService;
import org.buaa.ichat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FriendImpl implements FriendService {
    @Autowired
    UserService userService;
    @Autowired
    FriendsMapper friendsMapper;
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
        Friends friends = new Friends();
        friends.setReceiverID(receiverID);
        friends.setSenderID(senderID);
        friends.setStatus(0);
        friends.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        friendsMapper.insertFriends(friends);
    }

    @Override
    public void deal(Integer ID,Boolean ans) {
        //这里有个BUG，未验证处理这条申请的人是否是接收者，即只要登录就可以处理任何好友请求
        //还有一个BUG就是，可以重复处理
        Integer status;
        status = ans?1:-1;
        friendsMapper.update(Friends.UpdateBuild()
                .where(Friends.ConditionBuild().idList(ID)).set(Friends.Build().status(status).build()));
    }

    @Override
    public List<User> getFriends(Integer userID) {
        return friendsMapper.getFriendsByID(userID);
    }

    @Override
    public boolean isFriend(Integer ID1, Integer ID2) {
        Friends friends = friendsMapper.queryFriendsLimit1(Friends.QueryBuild().senderID(ID1).receiverID(ID2));
        if (friends != null && friends.getStatus() ==1)
            return true;

        friends = friendsMapper.queryFriendsLimit1(Friends.QueryBuild().senderID(ID2).receiverID(ID1));
        return  (friends != null && friends.getStatus() ==1);

    }

    @Override
    public List<Friends> getRelations(Integer userID) {
        return friendsMapper.getRelationsByID(userID);
    }
}
