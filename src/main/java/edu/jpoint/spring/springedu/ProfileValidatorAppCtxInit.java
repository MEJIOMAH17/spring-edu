package edu.jpoint.spring.springedu;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ProfileValidatorAppCtxInit implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        String[] activeProfiles = configurableApplicationContext.getEnvironment().getActiveProfiles();
        if (activeProfiles.length == 0) {
            throw new RuntimeException("Нельзя работать без профилей");
        }
    }
}
