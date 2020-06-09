package org.buaa.ichat;

import org.buaa.ichat.entity.GroupMSG;
import org.buaa.ichat.mapper.GroupMSGMapper;
import org.buaa.ichat.service.MessageService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	private final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);
	@Autowired
	MessageService messageService;
	@Autowired
	GroupMSGMapper groupMSGMapper;
	@Test
	void contextLoads() {
		try {
			List<GroupMSG> groupMSGS= groupMSGMapper.getGroupMsgByID(19);
			for (GroupMSG groupMSG:groupMSGS){
				System.out.println(groupMSG.toString());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
