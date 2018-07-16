package com.xm;

import java.io.File;

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

	@Test
	/**
	 * 多用途互联网邮件
	 */
	public void sendAttachmentEmail() {
		File attachment = new File("src/main/resources/static/1.txt");
		emailService.sendAttachmentEmail("1373572467@qq.com", "122", "Hello Mail!",attachment);
	}
	
	@Test
	/**
	 * 发送模板邮件
	 */
	public void sendTemplateMail() {
		emailService.sendTemplateMail("1373572467@qq.com", "激活邮件","EmailActivation");
	}
	
}
