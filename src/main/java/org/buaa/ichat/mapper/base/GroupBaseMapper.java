package org.buaa.ichat.mapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.Group;
/**
*  @author 
*/
public interface GroupBaseMapper {

    int insertGroup(Group object);

    int updateGroup(Group object);

    int update(Group.UpdateBuilder object);

    List<Group> queryGroup(Group object);

    Group queryGroupLimit1(Group object);

}