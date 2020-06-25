package com.demo.spring.springselenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        features = "classpath:features",
        glue = "com.demo.spring.springselenium.bdd",
        plugin = {
                "pretty",
                "html:/home/ubuntu/Documents/udemy/temp/target/"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
