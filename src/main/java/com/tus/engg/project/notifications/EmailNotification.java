package com.tus.engg.project.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailNotification {

	@Value("${spring.mail.username}")
	private String userName;

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendNotification() throws MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom(userName);
		mimeMessageHelper.setTo("balajibaluace97@gmail.com");
		mimeMessageHelper.setCc("mnraomq@gmail.com");
		mimeMessageHelper.setBcc("ashinjimmy54@gmail.com");
		mimeMessageHelper.setSubject("Humidity Range Alert");
		mimeMessageHelper.setText("Subject: Important Notice: High Indoor Humidity Alert\n\n" + "Dear User,\n\n"
				+ "We would like to bring to your attention that the indoor humidity level in your premises has exceeded the recommended threshold of 60%. This increase poses a potential risk of black mold proliferation if left unaddressed.\n\n"
				+ "We strongly advise taking necessary measures to mitigate this issue promptly, as prolonged high humidity levels can lead to adverse health effects and property damage.\n\n"
				+ "Thank you for your attention to this matter.\n\n" + "Best Regards,\n"
				+ "Team Monitoring & Alerting - Black Mold");
		javaMailSender.send(mimeMessage);
	}

}
