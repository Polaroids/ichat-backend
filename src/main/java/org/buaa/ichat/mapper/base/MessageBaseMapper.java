package org.buaa.ichat.mapper.base;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.buaa.ichat.entity.Message;
/**
*  @author 
*/
public interface MessageBaseMapper {

    int insertMessage(Message object);

    int updateMessage(Message object);

    int update(Message.UpdateBuilder object);

    List<Message> queryMessage(Message object);

    Message queryMessageLimit1(Message object);

}