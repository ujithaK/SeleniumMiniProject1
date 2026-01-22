package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage lp = new LoginPage(driver);

        lp.login(
                ConfigManager.getProperty("validUsername"),
                ConfigManager.getProperty("validPassword")
        );

        // ASSERTION: Successful login should NOT show error
        String error = lp.getErrorMessage();
        Assert.assertTrue(error == null || error.isEmpty(), "Unexpected login failure message shown!");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage lp = new LoginPage(driver);

        lp.login(
                ConfigManager.getProperty("invalidUsername"),
                ConfigManager.getProperty("invalidPassword")
        );

        String error = lp.getErrorMessage();

        // Either error exists or user stays on same login page
        boolean invalid = (error != null && !error.isEmpty())
                || driver.getCurrentUrl().contains("/account/login");

        Assert.assertTrue(invalid, "Invalid login did NOT trigger an error or stay on login page!");
    }

}
