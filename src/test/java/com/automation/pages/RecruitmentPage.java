package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RecruitmentPage extends BasePage{
    @FindBy(xpath = "//h6[text()='Recruitment']")
    WebElement recruitmentTitle;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-middlename']")
    WebElement middleNameInput;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
    WebElement lastNameInput;

    @FindBy(xpath = "//label[text()='Email']/../..//input[@class='oxd-input oxd-input--active']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@class='oxd-file-input']")
    WebElement fileInput;

    @FindBy(xpath = "//a[text()='Candidates']")
    WebElement candidateAnchor;

    @FindBy(xpath = "//label[text()='Candidate Name']/../..//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input")
    WebElement candidateNameInput;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-option']/span")
    WebElement srchResult;

    @FindBy(xpath = "//div[@class=\"oxd-table-cell oxd-padding-cell\"]")
    List<WebElement> result;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement srchBtn;

    public boolean isRecruitmentPageDisplayed() {
        return recruitmentTitle.isDisplayed();
    }

    public void fillRequiredDetails() {
        firstNameInput.sendKeys(ConfigReader.getConfigValue("candidate.firstname"));
        middleNameInput.sendKeys(ConfigReader.getConfigValue("candidate.middlename"));
        lastNameInput.sendKeys(ConfigReader.getConfigValue("candidate.lastname"));
        emailInput.sendKeys(ConfigReader.getConfigValue("candidate.email"));
        fileInput.sendKeys(System.getProperty("user.dir")+"/src/test/resources/Assignment 1.pdf");
    }

    public void searchByCandidateName() {
        candidateAnchor.click();
        candidateNameInput.sendKeys(ConfigReader.getConfigValue("candidate.firstname"));
        srchResult.click();
        srchBtn.click();

    }

    public String verifySearchResult() {
        return result.get(2).getText();
    }
}
