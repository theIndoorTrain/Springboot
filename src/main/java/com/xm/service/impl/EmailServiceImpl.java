package com.xm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xm.service.EmailService;
/**
 * 邮件发送业务实现
 * @author xm
 *
 */
@Service
public class EmailServiceImpl implements EmailService {
	
	//获取发送者信息
	@Value("${mail.from.addr}")
	private String from; 
	
	//定义邮件发送者
	@Autowired
	private JavaMailSender sender;

	@Override
	public void sendSimpleEmail(String to, String subject,String content) {
		//定义简单邮件
		SimpleMailMessage message = new SimpleMailMessage();
		//把发送者、收件人、标题、邮件内容封装入简单邮件中
		System.out.println("from: "+from+",to:"+to+",subject:"+subject);
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		//交给邮件发送者进行转发
		sender.send(message);
		System.out.println("发送");
	}

}
