package org.buaa.ichat.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.Friends;
import org.buaa.ichat.entity.User;
import org.buaa.ichat.mapper.base.FriendsBaseMapper;
/**
*  @author 
*/
public interface FriendsMapper extends FriendsBaseMapper{
    public List<User> getFriendsByID(Integer ID);
    public List<Friends> getRelationsByID(Integer ID);

}