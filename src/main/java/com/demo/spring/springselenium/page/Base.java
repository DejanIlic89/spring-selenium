package com.demo.spring.springselenium.page;

import com.demo.spring.springselenium.kelvin.annotation.LazyAutowired;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public abstract class Base {

    @LazyAutowired
    protected WebDriver driver;

    @LazyAutowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isAt();

}
