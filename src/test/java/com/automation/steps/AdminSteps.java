package com.automation.steps;

import com.automation.pages.AdminPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AdminSteps {
    AdminPage adminPage = new AdminPage();

    @When("user clicks on add button")
    public void user_clicks_on_add_button() {
        adminPage.clickAddBtn();
    }

    @Then("verify add user page loaded")
    public void verify_add_user_page_loaded() {
       Assert.assertTrue(adminPage.isAddUserDisplayed());
    }

    @Then("user select user role as ESS")
    public void user_select_user_role_as_ess() {
        adminPage.selectRollAsESS();
    }

    @Then("user add employee name")
    public void user_add_employee_name() {
        adminPage.setEmployeeName(ConfigReader.getConfigValue("employee.name"));
    }

    @Then("user make the status enabled")
    public void user_make_the_status_enabled() {
        adminPage.setStatus();
    }

    @Then("user sets username and password")
    public void user_sets_username_and_password() {
         adminPage.setUsernameAndPassword(ConfigReader.getConfigValue("Username"));
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        adminPage.clickOnSaveBtn();
    }

    @Then("verify success message is displayed")
    public void verify_success_message_is_displayed() {
        Assert.assertTrue(adminPage.isSuccessMsgDisplayed());
    }

    @Then("verify system users page loaded")
    public void verify_system_users_page_loaded() {
      Assert.assertTrue(adminPage.isSystemUsersTitleDisplayed());
    }

    @When("user search newly created user")
    public void user_search_newly_created_user() {
        adminPage.doSearchByUsername(ConfigReader.getConfigValue("Username"));
    }

    @Then("verify newly created user is displayed in search list")
    public void verify_newly_created_user_is_displayed_in_search_list() {
           Assert.assertEquals(adminPage.getSearchResult(),ConfigReader.getConfigValue("Username"));
    }

    @Then("user click on delete icon of the newly created user")
    public void user_click_on_delete_icon_of_the_newly_created_user() {
          adminPage.clickOnTrashBtn();
    }

    @When("user click on Yes, Delete button")
    public void user_click_on_yes_delete_button() {
        adminPage.clickOnDeleteConfirmationBtn();
    }



    @Then("verify the success message  is displayed")
    public void verifyTheSuccessMessageIsDisplayed() {
        Assert.assertTrue(adminPage.isSuccessMsgDisplayed());
    }
}
