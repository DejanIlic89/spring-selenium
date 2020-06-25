package com.demo.spring.springselenium.kelvin.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Bean
@Scope("browserscope")
public @interface ThreadScopeBean {
}
