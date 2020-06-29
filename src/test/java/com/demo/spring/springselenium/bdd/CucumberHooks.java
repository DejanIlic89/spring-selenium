package com.demo.spring.springselenium.bdd;

import com.demo.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.demo.spring.springselenium.kelvin.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        this.applicationContext.getBean(WebDriver.class).quit();
    }

}
