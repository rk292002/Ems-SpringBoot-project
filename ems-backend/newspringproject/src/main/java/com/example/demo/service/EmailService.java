package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
   @Autowired
	private JavaMailSender emailSender;
   public void sendEmail(String to, String subject, String body) {
       SimpleMailMessage message = new SimpleMailMessage();
       message.setFrom("raipillikusuma@gmail.com");
       message.setTo(to);
       message.setSubject(subject);
       message.setText(body);
       System.out.println("sending email to-"+ to );
       emailSender.send(message);
       System.out.println("email sent successfully");
   }
public EmailService(JavaMailSender emailSender) {
	super();
	this.emailSender = emailSender;
}

}
