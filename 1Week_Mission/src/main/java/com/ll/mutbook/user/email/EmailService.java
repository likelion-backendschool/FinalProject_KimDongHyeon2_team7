package com.ll.mutbook.user.email;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender emailSender;

    public void sendWelcomeMessage(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("멋북스 가입을 축하합니다!!!");
        message.setText("회원가입 완료!");
        emailSender.send(message);
    }
}
