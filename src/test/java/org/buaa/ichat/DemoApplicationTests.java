package org.buaa.ichat;

import org.buaa.ichat.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	@Autowired
	MessageService messageService;
	@Test
	void contextLoads() {
		try {
			messageService.insertGMSG(1000000,"内容",19);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
