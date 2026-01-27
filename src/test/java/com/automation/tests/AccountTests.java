package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.config.ConfigManager;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.AccountPage;
import com.automation.utils.TestListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;

@Listeners(TestListener.class)
public class AccountTests extends BaseTest {

    private final String email = ConfigManager.getProperty("validUsername");
    private final String pswd = ConfigManager.getProperty("validPassword");

    @Test
    public void verifyOrderHistoryAndProfile() {

        // Step 1: Go to Home Page
        HomePage homePage = new HomePage(driver);

        // Step 2: Click on Login
        homePage.clickLoginButton();

        // Step 3: Login with credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, pswd);

        // Step 4: Wait until redirected to /account
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/account"));

        // Step 5: Verify URL contains /account
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/account"),
                "User is not on the account page. Current URL: " + currentUrl);

        // Step 6: Initialize Account Page
        AccountPage accountPage = new AccountPage(driver);

        // Step 7: Verify Order History section is visible
        Assert.assertTrue(accountPage.isOrderHistorySectionVisible(),
                "Order history section is not visible on the Account Page");

        // Step 8: Validate Order History (Print result)
        if (accountPage.hasOrders()) {
            System.out.println("Orders exist for this account.");
        } else {
            System.out.println("No orders found for this account.");
        }

        // Step 9: Go to Edit Profile
        accountPage.goToEditProfile();

        // Step 10: Verify Email matches logged-in user
        Assert.assertEquals(accountPage.getProfileEmail(), email,
                "Profile email does not match the logged-in user");
    }

}
