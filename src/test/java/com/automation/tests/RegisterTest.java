package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.RegisterPage;
import com.automation.config.ConfigManager;
import com.automation.utils.TestListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


@Listeners(TestListener.class)
public class RegisterTest extends BaseTest {

    @DataProvider(name = "registerData")
    public Object[][] getRegisterData() {
        return new Object[][]{
                { ConfigManager.getProperty("fname"), ConfigManager.getProperty("lname"),
                        ConfigManager.getProperty("mail"), ConfigManager.getProperty("validPassword") },
                { "Test", "User", ConfigManager.getProperty("invalidUsername"),
                        ConfigManager.getProperty("invalidPassword") }
        };
    }

    @Test(dataProvider = "registerData")
    public void testRegister(String firstName, String lastName, String email, String password) {
        RegisterPage rg = new RegisterPage(driver);
        rg.register(firstName, lastName, email, password);

        // Wait for URL or success message after registration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/account"));

        // Validate successful registration
        String currentUrl = driver.getCurrentUrl();
        boolean isRegisterSuccess = currentUrl.contains("/account");

        Assert.assertTrue(isRegisterSuccess,
                "Register URL validation failed! Current URL: " + currentUrl);
    }
}
