package edu.jpoint.spring.springedu.aspect;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("notify.about.exception")
@Component
public class MailHolder {
    private String password;
    private String username;
    private String notifyTo;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNotifyTo(String notifyTo) {
        this.notifyTo = notifyTo;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getNotifyTo() {
        return notifyTo;
    }
}
