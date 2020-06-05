package org.buaa.ichat.mapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.GroupMSG;
/**
*  @author 
*/
public interface GroupMSGBaseMapper {

    int insertGroupMSG(GroupMSG object);

    int updateGroupMSG(GroupMSG object);

    int update(GroupMSG.UpdateBuilder object);

    List<GroupMSG> queryGroupMSG(GroupMSG object);

    GroupMSG queryGroupMSGLimit1(GroupMSG object);

}