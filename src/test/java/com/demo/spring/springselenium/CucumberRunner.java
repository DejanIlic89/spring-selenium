package com.demo.spring.springselenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        strict = true,
        tags = "@google or @visa or @login",
        features = "classpath:features",
        glue = "com.demo.spring.springselenium.bdd",
        plugin = {
                "pretty",
                "html:target/test-output/"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
