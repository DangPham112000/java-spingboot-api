package com.dangpham112000.service;

import com.dangpham112000.entity.mail.EmailEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaService {

    @Autowired
    private EmailService emailService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "otp-auth-topic", groupId = "otp-group-id")
    void listenOTP(String message) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            String email = jsonNode.get("email").asText();
            String otp = jsonNode.get("otp").asText();
            log.info("Received OTP {} for email: {}",otp, email);

            EmailEntity emailEntity = new EmailEntity();

            emailEntity.setToEmail(email);
            emailEntity.setSubject("Email from Kafka go");
            emailEntity.setMessageBody("Your OTP is: " + otp);

            String result = emailService.sendTextEmail(emailEntity);

            log.info("OTP sent successfully:: {}", result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

