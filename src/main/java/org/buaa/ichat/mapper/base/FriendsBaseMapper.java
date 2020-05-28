package org.buaa.ichat.mapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.Friends;
/**
*  @author 
*/
public interface FriendsBaseMapper {

    int insertFriends(Friends object);

    int updateFriends(Friends object);

    int update(Friends.UpdateBuilder object);

    List<Friends> queryFriends(Friends object);

    Friends queryFriendsLimit1(Friends object);

}