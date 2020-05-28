package org.buaa.ichat.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.Members;
import org.buaa.ichat.mapper.base.MembersBaseMapper;
/**
*  @author 
*/
public interface MembersMapper extends MembersBaseMapper{
    public void quit(Integer memberID,Integer groupID);

}