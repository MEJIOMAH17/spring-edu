package edu.jpoint.spring.springedu.aspect;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConditionalOnBean(MailSender.class)
public class MailSender {

    public void send() {
        System.out.println("sending email");
    }
}
