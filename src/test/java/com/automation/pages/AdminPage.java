package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdminPage extends BasePage{
    @FindBy(xpath = "//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")
    WebElement adminTitle;

    @FindBy(xpath = "//div[@class='orangehrm-header-container']//button[contains(@class,'secondary')]")
    WebElement addBtn;

    @FindBy(xpath = "//h6[text()=\"Add User\"]")
    WebElement  addUserTitle;

    @FindBy(xpath = "//label[text()='User Role']/../..//i[contains(@class,'select-text--arrow')]")
    WebElement userRollLink;

    @FindBy(xpath = "//div[@class=\"oxd-select-option\"]//span[text()=\"ESS\"]")
    WebElement essOption;

    @FindBy(xpath = "//div[contains(@class,'input--before')]/following-sibling::input")
    WebElement employeeNameField;

    @FindBy(xpath = "//label[text()='Status']/../..//i[contains(@class,'select-text--arrow')]")
    WebElement statusLink;

    @FindBy(xpath = "//div[@class=\"oxd-select-option\"]//span[text()=\"Enabled\"]")
    WebElement enabledOption;

    @FindBy(xpath = "//label[text()='Username']/../..//input[contains(@class,'input--active')]")
    WebElement userNameInput;

    @FindBy(xpath = "//label[text()='Password']/../..//input[contains(@class,'input--active')]")
    WebElement passwordInput;

    @FindBy(xpath = "//label[text()='Confirm Password']/../..//input[contains(@class,'input--active')]")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[contains(@class,'button--secondary')]")
    WebElement saveBtn;

    @FindBy(xpath = "//div[contains(@class,'success')]/p[text()=\"Success\"]")
    WebElement successMsg;
    @FindBy(xpath = "//div[@class=\"oxd-autocomplete-option\"]//span")
    WebElement dropDownUsername;

    @FindBy(xpath = "//h5")
    WebElement systemUsersTitle;

   @FindBy(xpath = "//button[text()=' Search ']")
   WebElement srchBtn;

    @FindBy(xpath = "//div[@class=\"oxd-table-cell oxd-padding-cell\"]")
    List<WebElement> result;

    @FindBy(xpath = "//i[contains(@class,'bi-trash')]")
    WebElement trashIcon;

    @FindBy(xpath = "//button[text()=\" Yes, Delete \"]")
    WebElement deleteConfirmationBtn;

    public boolean isAdminPageDisplayed() {
        return adminTitle.isDisplayed();
    }

    public void clickAddBtn() {
        addBtn.click();
    }

    public boolean isAddUserDisplayed() {
        return addUserTitle.isDisplayed();
    }

    public void selectRollAsESS() {
        userRollLink.click();
        essOption.click();

    }

    public void setEmployeeName(String configValue) {
        employeeNameField.sendKeys(configValue);
        dropDownUsername.click();
    }

    public void setStatus() {
        statusLink.click();
        enabledOption.click();
    }

    public void setUsernameAndPassword(String configValue) {
        String username = generateUniqueUsername(configValue);
        ConfigReader.setConfigValue("Username",username);
        userNameInput.sendKeys(username);
        String password = configValue.replaceAll(" ","")+"@12345";
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);

    }

    public void clickOnSaveBtn() {
        saveBtn.click();
    }

    public boolean isSuccessMsgDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(successMsg));
        return successMsg.isDisplayed();
    }

    public boolean isSystemUsersTitleDisplayed() {
        return systemUsersTitle.isDisplayed();
    }

    public void doSearchByUsername(String configValue) {
       userNameInput.sendKeys(ConfigReader.getConfigValue("Username"));
       srchBtn.click();
    }

    public String  getSearchResult() {
        wait.until(ExpectedConditions.visibilityOf(result.get(1)));
        System.out.println(result.get(1).getText());
        return result.get(1).getText();
    }

    public void clickOnTrashBtn() {
        trashIcon.click();
    }

    public void clickOnDeleteConfirmationBtn() {
        deleteConfirmationBtn.click();
    }

    public static String generateUniqueUsername(String configValue) {
        // Remove spaces from the username
        String baseUsername = configValue.replaceAll(" ", "");

        // Append a timestamp to ensure uniqueness
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Ensure the final username does not exceed 40 characters
        // Calculate the max length for baseUsername so that the final result stays within 40 characters
        int maxBaseLength = 40 - timestamp.length(); // subtract the length of the timestamp
        if (baseUsername.length() > maxBaseLength) {
            baseUsername = baseUsername.substring(0, maxBaseLength); // truncate if necessary
        }

        // Concatenate base username with the timestamp
        return baseUsername + timestamp;
    }
}
