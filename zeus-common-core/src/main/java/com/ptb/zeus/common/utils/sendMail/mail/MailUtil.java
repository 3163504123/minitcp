package com.ptb.zeus.common.utils.sendMail.mail;


import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;

public class MailUtil {

	public static void sendMailByTemplate(String receiver, String subject,
			Map<String, String> map, String templateName) throws IOException, TemplateException, MessagingException {
		String maiBody = "";
		String server = ConfigLoader.getServer();
		String sender = ConfigLoader.getSender();
		String username = ConfigLoader.getUsername();
		String password = ConfigLoader.getPassword();
		String nickname = ConfigLoader.getNickname();
		MailSender mail = new MailSender(server);
		mail.setNeedAuth(true);
		mail.setNamePass(username, password, nickname);
		maiBody = TemplateFactory.generateHtmlFromFtl(templateName, map);
		mail.setSubject(subject);
		mail.setBody(maiBody);
		mail.setReceiver(receiver);
		mail.setSender(sender);
		mail.sendout();
	}

	public static void sendMailAndFileByTemplate(String receiver,
			String subject, String filePath, Map<String, String> map,
			String templateName) throws IOException, TemplateException,
			MessagingException {
		String maiBody = "";
		String server = ConfigLoader.getServer();
		String sender = ConfigLoader.getSender();
		String username = ConfigLoader.getUsername();
		String password = ConfigLoader.getPassword();
		String nickname = ConfigLoader.getNickname();
		MailSender mail = new MailSender(server);
		mail.setNeedAuth(true);
		mail.setNamePass(username, password, nickname);
		maiBody = TemplateFactory.generateHtmlFromFtl(templateName, map);
		mail.setSubject(subject);
		mail.addFileAffix(filePath);
		mail.setBody(maiBody);
		mail.setReceiver(receiver);
		mail.setSender(sender);
		mail.sendout();
	}

	public static void sendMail(String receiver, String subject, String maiBody)
			throws IOException, MessagingException {
		String server = ConfigLoader.getServer();
		String sender = ConfigLoader.getSender();
		String username = ConfigLoader.getUsername();
		String password = ConfigLoader.getPassword();
		String nickname = ConfigLoader.getNickname();
		MailSender mail = new MailSender(server);
		mail.setNeedAuth(true);
		mail.setNamePass(username, password, nickname);
		mail.setSubject(subject);
		mail.setBody(maiBody);
		mail.setReceiver(receiver);
		mail.setSender(sender);
		mail.sendout();
	}

	public static void sendMailAndFile(String receiver, String subject,
			String filePath, String maiBody) throws IOException,
			MessagingException {
		String server = ConfigLoader.getServer();
		String sender = ConfigLoader.getSender();
		String username = ConfigLoader.getUsername();
		String password = ConfigLoader.getPassword();
		String nickname = ConfigLoader.getNickname();
		MailSender mail = new MailSender(server);
		mail.setNeedAuth(true);
		mail.setNamePass(username, password, nickname);
		mail.setSubject(subject);
		mail.setBody(maiBody);
		mail.addFileAffix(filePath);
		mail.setReceiver(receiver);
		mail.setSender(sender);
		mail.sendout();
	}

}
