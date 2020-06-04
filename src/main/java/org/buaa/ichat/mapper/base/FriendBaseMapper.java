package org.buaa.ichat.mapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.Friend;
/**
*  @author 
*/
public interface FriendBaseMapper {

    int insertFriend(Friend object);

    int updateFriend(Friend object);

    int update(Friend.UpdateBuilder object);

    List<Friend> queryFriend(Friend object);

    Friend queryFriendLimit1(Friend object);

}