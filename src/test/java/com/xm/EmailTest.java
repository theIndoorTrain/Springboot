package com.xm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xm.service.EmailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {
	
	@Autowired
	private EmailService emailService;
	
	@Test
	/**
	 * 测试简单邮件的发送
	 */
	public void sendSimpleMassage() {
		emailService.sendSimpleEmail("1373572467@qq.com", "122", "Hello Mail!");
	}

}
