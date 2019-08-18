package edu.jpoint.spring.springedu.aspect;

import edu.jpoint.spring.springedu.annotation.ConditionalOnRandom;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnRandom
@Aspect
public class BenchmarkAspect {

    @Around("@annotation(edu.jpoint.spring.springedu.annotation.Benchmark)&&within(edu.jpoint..*)")
    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            System.out.println(String.format("%s:%s: executionTime(ns):%s",
                    joinPoint.getTarget().getClass().getCanonicalName(),
                    joinPoint.getSignature().getName(),
                    System.nanoTime() - start));
        }
        return result;
    }
}
