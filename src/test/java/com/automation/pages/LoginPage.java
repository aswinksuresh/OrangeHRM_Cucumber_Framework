package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//button")
    WebElement loginBtn;

    public void openWebsite(){
        driver.get(ConfigReader.getConfigValue("application.url"));
    }
    public void doLogin(){
        username.sendKeys(ConfigReader.getConfigValue("login.username"));
        password.sendKeys(ConfigReader.getConfigValue("login.password"));
        loginBtn.click();
    }
    public boolean isLoginPageDisplayed(){
        return loginBtn.isDisplayed();
    }
}
