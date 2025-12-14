
package com.automation.pages;

import com.automation.config.ConfigManager;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private static final String LOGIN_PATH = "/account/login";

    private By emailInput = By.id("customer_email");
    private By passwordInput = By.id("customer_password");
    private By signInButton = By.className("button");
    private By errorMessage = By.cssSelector(".errors");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(ConfigManager.getProperty("baseUrl") + LOGIN_PATH);
    }

    public void login(String email, String password) {
        open();
        WaitUtils.waitForVisibility(emailInput).sendKeys(email);
        WaitUtils.waitForVisibility(passwordInput).sendKeys(password);
        WaitUtils.waitForVisibility(signInButton).click();
    }

    public String getErrorMessage() {
        return WaitUtils.waitForVisibility(errorMessage).getText();
    }
}
