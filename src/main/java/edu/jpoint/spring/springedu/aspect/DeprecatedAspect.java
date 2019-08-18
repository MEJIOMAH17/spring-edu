package edu.jpoint.spring.springedu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DeprecatedAspect {

    @Before("@annotation(Deprecated)&&within(edu.jpoint..*)")
    public void deprecatedAdvice(JoinPoint joinPoint) {
        System.err.println(String.format("used depricated method %s from class: %s",
                joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass()));
    }
}
