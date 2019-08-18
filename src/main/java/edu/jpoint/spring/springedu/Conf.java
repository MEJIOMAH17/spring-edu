package edu.jpoint.spring.springedu;

import edu.jpoint.spring.springedu.aspect.BenchmarkAspect;
import edu.jpoint.spring.springedu.aspect.DeprecatedAspect;
import edu.jpoint.spring.springedu.aspect.MailHolder;
import edu.jpoint.spring.springedu.aspect.MailSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan("edu.jpoint.spring.springedu.aspect")
@EnableConfigurationProperties(MailHolder.class)
public class Conf {
//    @Bean
//    @ConditionalOnBean(MailSender.class)
//    public MailSender mailSender() {
//        return new MailSender();
//    }
    public void processNames(List<String> stringList){

    }


}
