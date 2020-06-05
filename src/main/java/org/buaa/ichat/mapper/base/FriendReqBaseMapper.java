package org.buaa.ichat.mapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.FriendReq;
/**
*  @author 
*/
public interface FriendReqBaseMapper {

    int insertFriendReq(FriendReq object);

    int updateFriendReq(FriendReq object);

    int update(FriendReq.UpdateBuilder object);

    List<FriendReq> queryFriendReq(FriendReq object);

    FriendReq queryFriendReqLimit1(FriendReq object);

}