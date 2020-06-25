package com.demo.spring.springselenium.kelvin.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Lazy
@Configuration
public @interface LazyConfiguration {
}
