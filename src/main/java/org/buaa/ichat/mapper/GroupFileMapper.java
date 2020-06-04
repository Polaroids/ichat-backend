package org.buaa.ichat.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.GroupFile;
import org.buaa.ichat.mapper.base.GroupFileBaseMapper;
/**
*  @author 
*/
public interface GroupFileMapper extends GroupFileBaseMapper{
    public void delete(Integer fileID);

}