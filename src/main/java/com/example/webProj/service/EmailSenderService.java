package com.example.webProj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail,
                          String subject,
                          String msg)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("goodreadsin592021@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(msg);

        mailSender.send(message);
        System.out.println("Mail sent succesfuly from "+message.getFrom()+ " to "+message.getTo()+".");
    }
}
