package com.account.credintials.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailServices {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String to,String subject,String content) throws MessagingException
    {
        MimeMessage ms=javaMailSender.createMimeMessage();
        MimeMessageHelper m=new MimeMessageHelper(ms,true);
        m.setTo(to);
        m.setSubject(subject);
        m.setText(content,true);
        javaMailSender.send(ms);
    }

}
