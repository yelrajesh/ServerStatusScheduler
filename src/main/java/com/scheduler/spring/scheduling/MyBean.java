package com.scheduler.spring.scheduling;

import java.net.InetAddress;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import org.springframework.scheduling.annotation.Scheduled;

public class MyBean {

	@Scheduled(cron = "0 0/15 * * * *")
	public void printMessage() {
		pingServer("");
	}

	private void pingServer(String ipAddress) {
		try {
			ipAddress = "127.0.0.1";
			InetAddress inet = InetAddress.getByName(ipAddress);
			System.out.println("Sending Ping Request to " + ipAddress);
			if (inet.isReachable(300)) {
				sendEmailSSL();
				System.out.println(ipAddress + " is reachable.");
			} else {
				System.out.println(ipAddress + " NOT reachable.");
			}
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}

	private void sendEmailSSL() {
		final String username = "yelrajesh@gmail.com";
		final String password = "Umayal@1357";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("yelrajesh@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("svivek.eee@gmail.com"));
			message.setSubject("Testing Gmail TLS");
			message.setText("Dear Phylos," + "\n\n Please do not spam my email!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
