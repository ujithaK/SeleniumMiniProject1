package com.automation.pages;

import com.automation.config.ConfigManager;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private static final String LOGIN_PATH = "/account/login";

    // Locators
    private By emailInput = By.id("customer_email");
    private By passwordInput = By.id("customer_password");
    private By signInButton = By.xpath("//*[@id='customer_login']/div[5]/input");
    private By errorMessage = By.cssSelector(".error, .errors, .alert, .alert-danger");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Open login page and wait until URL contains login path
    public void open() {
        driver.get(ConfigManager.getProperty("baseUrl") + LOGIN_PATH);
        WaitUtils.waitForUrlContains(driver, LOGIN_PATH, 10); // pass driver and timeout
    }

    // Login method
    public void login(String email, String password) {
        open();

        WaitUtils.waitForVisibility(driver, emailInput, 10).clear();
        WaitUtils.waitForVisibility(driver, emailInput, 10).sendKeys(email);

        WaitUtils.waitForVisibility(driver, passwordInput, 10).clear();
        WaitUtils.waitForVisibility(driver, passwordInput, 10).sendKeys(password);

        WaitUtils.waitForClickable(driver, signInButton, 10).click();
    }

    // Get error message if login fails
    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText().trim();
        } catch (Exception e) {
            return null;
        }
    }
}
