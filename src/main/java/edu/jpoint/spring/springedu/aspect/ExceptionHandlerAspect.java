package edu.jpoint.spring.springedu.aspect;

import org.apache.commons.mail.HtmlEmail;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
@ConditionalOnProperty("notify.about.exception.notify-to")
@Component
@Aspect
public class ExceptionHandlerAspect {
    private final ExecutorService executor;
    private final MailSender mailSender;
    private Map<Exception, Void> exceptionMap = new WeakHashMap<>();

    @Autowired
    public ExceptionHandlerAspect(ExecutorService executor, MailSender mailSender) {
        this.executor = executor;
        this.mailSender = mailSender;
    }

    @AfterThrowing(pointcut = "execution(* edu.jpoint..*(..))" +
            " && @annotation(edu.jpoint.spring.springedu.annotation.NotifyAboutException)",
            throwing = "ex")
    public void advice(JoinPoint joinPoint, RuntimeException ex) {

        if (!exceptionMap.containsKey(ex)) {
            exceptionMap.put(ex, null);
            executor.execute(() -> notification(ex, joinPoint));
        }

    }

    public void notification(Throwable e, JoinPoint joinPoint) {
        mailSender.send();
//        HtmlEmail email = new HtmlEmail();
//        email.setHostName("smtp.gmail.com");
//        email.setSmtpPort(465);
//        email.setSSLOnConnect(true);
//        email.setAuthentication(mailHolder.getUsername(), mailHolder.getPassword());
//        email.setSubject(String.format("Exception in%s:%s",
//                joinPoint.getTarget().getClass().getCanonicalName(),
//                joinPoint.getSignature().getName()));
//        try {
//            if (e.getLocalizedMessage() != null) {
//                email.setMsg(e.getClass().getCanonicalName() + ":" + e.getLocalizedMessage());
//            } else {
//                email.setMsg(e.getClass().getCanonicalName());
//            }
//            email.setFrom(mailHolder.getUsername());
//            email.setTo(Collections.singleton(new InternetAddress(mailHolder.getNotifyTo())));
//            email.send();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

    }
}
