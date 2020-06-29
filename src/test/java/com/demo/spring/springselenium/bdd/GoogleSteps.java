package com.demo.spring.springselenium.bdd;

import com.demo.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.demo.spring.springselenium.page.google.GooglePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
public class GoogleSteps {

    @LazyAutowired
    private GooglePage googlePage;

    @Given("I am on the google site")
    public void launchSite() {
        this.googlePage.goTo();
    }

    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }

    @Then("I should see search results page")
    public void clickSearch() {
        Assert.assertTrue(this.googlePage.getSearchResultComponent().isAt());
    }

    @Then("I should see at least {int} results")
    public void verifyResults(int count) {
        Assert.assertTrue(this.googlePage.getSearchResultComponent().getCount() >= count);
    }
}
