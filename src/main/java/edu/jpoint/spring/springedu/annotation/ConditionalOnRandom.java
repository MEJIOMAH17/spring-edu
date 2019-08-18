package edu.jpoint.spring.springedu.annotation;

import edu.jpoint.spring.springedu.OnRandomConditional;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnRandomConditional.class)
public @interface ConditionalOnRandom {
}
