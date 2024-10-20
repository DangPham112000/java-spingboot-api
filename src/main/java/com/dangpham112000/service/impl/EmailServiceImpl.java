package com.dangpham112000.service.impl;

import com.dangpham112000.entity.mail.EmailEntity;
import com.dangpham112000.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final String EMAIL_HOST = "dangpham112000.com";

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendTextEmail(EmailEntity email) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email.getToEmail());
        message.setSubject(email.getSubject());
        message.setText(email.getMessageBody());
        message.setFrom(EMAIL_HOST);
        try {
            javaMailSender.send(message);
            return "Email sent successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendHtmlEmail(EmailEntity email) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email.getToEmail());
            helper.setSubject(email.getSubject());
            helper.setText(email.getMessageBody(), true);
            helper.setFrom(EMAIL_HOST);

            javaMailSender.send(message);
            return "Email html sent successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendAttachmentsEmail(EmailEntity email) {
        return "";
    }
}
