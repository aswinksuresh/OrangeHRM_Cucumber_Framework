package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.pages.RecruitmentPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RecruitmentSteps {
    RecruitmentPage recruitmentPage = new RecruitmentPage();
    @Then("verify recruitment page is loaded")
    public void verify_recruitment_page_is_loaded() {
        Assert.assertTrue(recruitmentPage.isRecruitmentPageDisplayed());
    }

    @Then("user fill required details with upload on doc file in resume")
    public void user_fill_required_details_with_upload_on_doc_file_in_resume() {
     recruitmentPage.fillRequiredDetails();
    }

    @When("user search by candidate name")
    public void user_search_by_candidate_name() {
        recruitmentPage.searchByCandidateName();

    }

    @Then("verify search result displays candidate name")
    public void verify_search_result_displays_candidate_name() {
        Assert.assertEquals(recruitmentPage.verifySearchResult(), ConfigReader.getConfigValue("candidate.name"));;
    }
}
