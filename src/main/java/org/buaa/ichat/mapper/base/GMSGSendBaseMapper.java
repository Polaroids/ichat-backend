package org.buaa.ichat.mapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.GMSGSend;
/**
*  @author 
*/
public interface GMSGSendBaseMapper {

    int insertGMSGSend(GMSGSend object);

    int updateGMSGSend(GMSGSend object);

    int update(GMSGSend.UpdateBuilder object);

    List<GMSGSend> queryGMSGSend(GMSGSend object);

    GMSGSend queryGMSGSendLimit1(GMSGSend object);

}