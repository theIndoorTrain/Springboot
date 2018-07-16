package com.xm.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

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
	
	@Autowired
	//模板解析
	private TemplateEngine templateEngine;

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

	@Override
	public void sendAttachmentEmail(String to, String subject, String content, File attachment) {
		//创建多用途互联网邮件
		MimeMessage message = sender.createMimeMessage();
		
		try {
			//封装多用途互联网邮件
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content);
			helper.addAttachment("附件", attachment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sender.send(message);
	}

	@Override
	public void sendTemplateMail(String to, String subject, String info) {
		//创建多用途互联网邮件
				MimeMessage message = sender.createMimeMessage();
				
				try {
					//封装多用途互联网邮件
					MimeMessageHelper helper = new MimeMessageHelper(message, true);
					helper.setFrom(from);
					helper.setTo(to);
					helper.setSubject(subject);
					//封装模板参数
					Context context = new Context();
					context.setVariable("id", 1);
					//解析模板
					String content = templateEngine.process(info, context);
					
					//true:识别Html
					helper.setText(content, true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				sender.send(message);
	}

}
