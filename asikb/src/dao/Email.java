package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import myApp.SMTP;
import myApp.Sysadmin;

public enum Email {
	instance;
	private SMTP account;
	private Sysadmin admin;

	private Email() {
		getFromDB();
		loadFromDB();
	}

	private SMTP getFromDB() {
		try {
			Connection connection = Utils.getConnection();
			PreparedStatement psmt = connection.prepareStatement(
					"SELECT smtpserver, smtpport, smtpauth, smtpstarttls, smtpfromaddress, smtpusername, smtppassword  FROM sysinfo");
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				account = new SMTP(rs.getString("smtpserver"), rs.getInt("smtpport"), rs.getString("smtpauth"),
						rs.getString("smtpstarttls"), rs.getString("smtpfromaddress"), rs.getString("smtpusername"),
						rs.getString("smtppassword"));
			}
		} catch (Exception e) {
			Email.instance.sendErrorEmail(e, "Failed to get SMTP settings from the database", e.getMessage());
		}
		return account;
	}

	private Sysadmin loadFromDB() {
		try {
			Connection connection = Utils.getConnection();
			PreparedStatement psmt = connection.prepareStatement("SELECT adminuser, adminemail FROM sysinfo");
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				admin = new Sysadmin(rs.getString("adminuser"), rs.getString("adminemail"));
			}
		} catch (Exception e) {
			Email.instance.sendErrorEmail(e, "Failed to load sys admin from the database", e.getMessage());
		}
		return admin;
	}

	public void sendErrorEmail(Exception e, String subject, String error) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", account.getAuth());
		props.put("mail.smtp.starttls.enable", account.getStarttls());
		props.put("mail.smtp.host", account.getServer());
		props.put("mail.smtp.port", account.getPort());
		props.put("mail.smtp.ssl.trust", account.getServer());

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(account.getUsername(), account.getPassword());
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(account.getFromaddress()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(admin.getEmail()));
			message.setSubject(subject);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(error + "\n\n" + e.toString());
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException e1) {
			throw new RuntimeException(e1);
		}
	}

}
