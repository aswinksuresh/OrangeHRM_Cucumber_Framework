package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//span[@class=\"oxd-userdropdown-tab\"]")
    WebElement userProfile;
    @FindBy(xpath = "//a[@class=\"oxd-userdropdown-link\" and text()=\"Logout\"]")
    WebElement logoutBtn;

    @FindBy(xpath = "//a[@class='oxd-main-menu-item active toggle']")
    WebElement activeLink;

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminLink;
    @FindBy(xpath = "//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")
    WebElement adminTitle;

    @FindBy(xpath = "//span[text()='Recruitment']")
    WebElement recruitmentLink;

    public boolean isHomePageDisplayed() {
        return userProfile.isDisplayed();
    }
    public boolean isAdminPageDisplayed() {
        return adminTitle.isDisplayed();
    }

    public void doLogout() {
        userProfile.click();
        logoutBtn.click();
    }

    public void clickAdminLink() {
        adminLink.click();
    }

    public void clickOnRecruitmentLink() {
        recruitmentLink.click();
    }
}
