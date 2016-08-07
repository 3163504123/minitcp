package com.ptb.zeus.common.utils.sendMail.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class MailSender {
	private MimeMessage mimeMsg; // MIME邮件对象
	private Session session; // 邮件会话对象
	private Properties props; // 系统属性
	private Multipart mp; // Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成
	private String username;// 发件人的用户名
	private String password;// 发件人的密码
	private String nickname;// 发件人的昵称
	private static Logger log = LoggerFactory.getLogger(MailSender.class);

	public MailSender(String smtp) {
		setSmtpHost(smtp);
		createMimeMessage();
	}

	public void setSmtpHost(String hostName) {
		if (props == null)
			props = System.getProperties();
		props.put("mail.smtp.host", hostName);
		log.debug("set system properties success ：mail.smtp.host= " + hostName);

	}

	public void createMimeMessage() {
		// 获得邮件会话对象
		session = Session.getDefaultInstance(props, null);
		// 创建MIME邮件对象
		mimeMsg = new MimeMessage(session);
		mp = new MimeMultipart();
		log.debug(" create session and mimeMessage success");
	}

	public void setNeedAuth(boolean need) {
		if (props == null)
			props = System.getProperties();
		if (need) {
			props.put("mail.smtp.auth", "true");
		} else {
			props.put("mail.smtp.auth", "false");
		}
		log.debug("set smtp auth success：mail.smtp.auth= " + need);

	}

	public void setSubject(String subject) throws UnsupportedEncodingException,
			MessagingException {
		mimeMsg.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));
		log.debug("set mail subject success, subject= " + subject);

	}

	public void setBody(String mailBody) throws MessagingException {
		BodyPart bp = new MimeBodyPart();
		bp.setContent("" + mailBody, "text/html;charset=utf-8");
		mp.addBodyPart(bp);
		log.debug("set mail body content success,mailBody= " + mailBody);

/*		bp = new MimeBodyPart();
		DataSource fds = new FileDataSource("F:\\MAIL.png");
		bp.setDataHandler(new DataHandler(fds));
		bp.setHeader("Content-ID","<image>");
		mp.addBodyPart(bp);*/

/*		MimeBodyPart contentMultiAlterBody = new MimeBodyPart();
		MimeMultipart contentMultiAlter = new MimeMultipart("alternative");
		BodyPart bp = new MimeBodyPart();
		bp.setContent("" + mailBody, "text/html;charset=utf-8");
		contentMultiAlter.addBodyPart(bp);
		log.debug("set mail body content success,mailBody= " + mailBody);
		contentMultiAlterBody.setContent(contentMultiAlter);

		MimeBodyPart contentBody = new MimeBodyPart();
		MimeMultipart contentMultiRealt = new MimeMultipart("related");
		bp = new MimeBodyPart();
		DataSource fds = new FileDataSource("F:\\MAIL.png");
		bp.setDataHandler(new DataHandler(fds));
		bp.setHeader("Content-ID","<image>");
		contentMultiRealt.addBodyPart(bp);
		contentMultiRealt.addBodyPart(contentMultiAlterBody);
		contentBody.setContent(contentMultiRealt);

		mp.addBodyPart(contentBody);*/
	}

	public void addFileAffix(String filePath) throws MessagingException, UnsupportedEncodingException {
		BodyPart bp = new MimeBodyPart();
		FileDataSource fileds = new FileDataSource(filePath);
		bp.setDataHandler(new DataHandler(fileds));
		bp.setFileName(MimeUtility.encodeText(fileds.getName()));
		mp.addBodyPart(bp);
		log.debug("mail add file success,filename= " + filePath);
	}

	public void setSender(String sender) throws UnsupportedEncodingException,
			AddressException, MessagingException {
		nickname = MimeUtility.encodeText(nickname, "utf-8", "B");
		mimeMsg.setFrom(new InternetAddress(nickname + " <" + sender + ">"));
		log.debug(" set mail sender and nickname success , sender= " + sender
				+ ",nickname=" + nickname);
	}

	public void setReceiver(String receiver) throws AddressException,
			MessagingException {
		mimeMsg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(receiver));
		log.debug("set mail receiver success,receiver = " + receiver);
	}

	public void setCopyTo(String copyto) throws AddressException,
			MessagingException {
		mimeMsg.setRecipients(Message.RecipientType.CC,
				InternetAddress.parse(copyto));
		log.debug("set mail copyto receiver success,copyto = " + copyto);
	}

	public void sendout() throws MessagingException {
		mimeMsg.setContent(mp);
		mimeMsg.saveChanges();
		Session mailSession = Session.getInstance(props, null);
		Transport transport = mailSession.getTransport("smtp");
		transport.connect((String) props.get("mail.smtp.host"), username,
				password);
		transport.sendMessage(mimeMsg,
				mimeMsg.getRecipients(Message.RecipientType.TO));
		transport.close();
		log.debug(" send mail success");
	}

	public void setNamePass(String username, String password, String nickname) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;

	}

}
