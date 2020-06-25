package com.demo.spring.springselenium.kelvin.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Page
public @interface Window {
    String value() default "";
}
