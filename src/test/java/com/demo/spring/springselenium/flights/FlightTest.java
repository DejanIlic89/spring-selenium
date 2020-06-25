package com.demo.spring.springselenium.flights;

import com.demo.spring.springselenium.SpringBaseTestNGTest;
import com.demo.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.demo.spring.springselenium.page.flights.FlightPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTest extends SpringBaseTestNGTest {

    @LazyAutowired
    private FlightPage flightPage;

    @LazyAutowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest() {
        this.flightPage.goTo(this.appDetails.getUrl());
        Assert.assertTrue(this.flightPage.isAt());
        Assert.assertEquals(this.flightPage.getLabels(), this.appDetails.getLabels());
    }

}
