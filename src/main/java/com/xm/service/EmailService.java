package com.xm.service;

import java.io.File;

/**
 * 邮件发送业务
 * @author xm
 *
 */
public interface EmailService {
	
	/**
	 * 发送简单邮件
	 * @param to ：收件人
	 *  @param subject : 标题
	 * @param content ：邮件内容
	 */
	void sendSimpleEmail(String to,String subject,String content);
	
	/**
	 * 发送带附件的邮件
	 * @param to：收件人
	 * @param subject : 标题
	 * @param content：邮件内容
	 * @param attachment：附件
	 */
	void sendAttachmentEmail(String to,String subject,String content,File attachment);
}
