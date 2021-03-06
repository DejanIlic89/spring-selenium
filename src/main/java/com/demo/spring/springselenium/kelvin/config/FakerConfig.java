package com.demo.spring.springselenium.kelvin.config;

import com.demo.spring.springselenium.kelvin.annotation.LazyConfiguration;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }

}
