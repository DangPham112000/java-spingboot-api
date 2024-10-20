package com.dangpham112000.service;

import com.dangpham112000.entity.mail.EmailEntity;

public interface EmailService {

    String sendTextEmail(EmailEntity email);
    String sendHtmlEmail(EmailEntity email);
    String sendAttachmentsEmail(EmailEntity email);

}
