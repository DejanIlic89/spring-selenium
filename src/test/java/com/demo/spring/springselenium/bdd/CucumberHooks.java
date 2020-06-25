package com.demo.spring.springselenium.bdd;

import com.demo.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.demo.spring.springselenium.kelvin.service.ScreenshotService;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class CucumberHooks {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }
}
