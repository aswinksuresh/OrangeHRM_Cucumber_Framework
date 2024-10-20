package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomeSteps {
    HomePage homePage = new HomePage();
    @Then("verify user is on admin page")
    public void verify_user_is_on_admin_page() {
        Assert.assertTrue(homePage.isAdminPageDisplayed());
    }

    @Then("verify that user is on homepage")
    public void verify_that_user_is_on_homepage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user logout")
    public void user_logout() {
         homePage.doLogout();
    }

    @When("user clicks on admin link")
    public void user_clicks_on_admin_link() {
         homePage.clickAdminLink();
    }



}
