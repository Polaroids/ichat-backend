package org.buaa.ichat.service;

import org.buaa.ichat.entity.FriendReq;
import org.buaa.ichat.entity.User;

import java.util.List;

public interface FriendService {
    public void add(Integer senderID,Integer receiverID)throws Exception;
    public void deal(Integer ID,Boolean ans);
    public boolean isFriend(Integer ID1,Integer ID2);
    public List<User> getFriends(Integer userID);
    public List<FriendReq> getRelations(Integer userID);
}
