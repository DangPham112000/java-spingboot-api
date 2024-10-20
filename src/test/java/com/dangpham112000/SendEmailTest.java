package com.dangpham112000;

import com.dangpham112000.util.EmailSenderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
public class SendEmailTest {

    @Autowired
    EmailSenderUtil emailSenderUtil;

    @Test
    void sendTextEmail() {
        String to = "haidangpham112000@gmail.com";
        String subject = "Test OTP simple";
        String content = "This is a test";

        emailSenderUtil.sendTextMail(to, subject, content);
    }

    @Test
    void sendHtmlEmail() throws IOException {
        String to = "haidangpham112000@gmail.com";
        String subject = "Test OTP HTML";
        String content = "OTP is 1231";

        Resource resource = new ClassPathResource("/templates/email/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());
        emailSenderUtil.sendHtmlMail(to, subject, htmlContent);
    }
}
