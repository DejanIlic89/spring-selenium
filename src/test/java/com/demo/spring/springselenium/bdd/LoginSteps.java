package com.demo.spring.springselenium.bdd;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class LoginSteps {
    @Given("I navigate to the login page")
    public void openLoginPage() {
        System.out.println("Navigate login page");
    }

    @And("I click login button")
    public void clickLoginBtn() {
        System.out.println("Click login button");
    }

    @Then("I should see the user form page")
    public void getUserFormPage() {
        System.out.println("I should see user form page");
    }

    @And("I enter the following for Login")
    public void iEnterTheFollowingForLogin(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();

        System.out.println(data.get(0).get(0));
        System.out.println(data.get(0).get(1));
    }
}
