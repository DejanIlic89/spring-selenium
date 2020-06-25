package com.demo.spring.springselenium.googletest;

import com.demo.spring.springselenium.SpringBaseTestNGTest;
import com.demo.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.demo.spring.springselenium.kelvin.service.ScreenshotService;
import com.demo.spring.springselenium.page.google.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google1Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());

//        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResultComponent().isAt());
        Assert.assertTrue(this.googlePage.getSearchResultComponent().getCount() > 2);
        this.screenshotService.takeScreenShot();
        this.googlePage.close();
    }

}
