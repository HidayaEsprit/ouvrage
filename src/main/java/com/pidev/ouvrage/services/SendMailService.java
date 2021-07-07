package com.pidev.ouvrage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String to, String body, String topic){
		System.out.println("sending ...");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	simpleMailMessage.setFrom("bahaeddine.messaoudi@esprit.tn");
	simpleMailMessage.setTo(to);
	simpleMailMessage.setSubject(topic);
	simpleMailMessage.setText(body);
	javaMailSender.send(simpleMailMessage);
	System.out.println("sent email ...");
	}
}
