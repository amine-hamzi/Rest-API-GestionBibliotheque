package com.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public Boolean sendSimpleEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ambiblio01@gmail.com");
        message.setTo(email.getToEmail());
        message.setText(email.getBody());
        message.setSubject(email.getSubject());
        try{
            mailSender.send(message);
            return true;
        }catch(MailException e){
            return false;
        }
    }
}
