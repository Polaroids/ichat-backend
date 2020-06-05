package org.buaa.ichat.mapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.GroupFile;
/**
*  @author 
*/
public interface GroupFileBaseMapper {

    int insertGroupFile(GroupFile object);

    int updateGroupFile(GroupFile object);

    int update(GroupFile.UpdateBuilder object);

    List<GroupFile> queryGroupFile(GroupFile object);

    GroupFile queryGroupFileLimit1(GroupFile object);

}