package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("uji@gmail.com", "uji@123");
        Assert.assertTrue(driver.getCurrentUrl().contains("/account/login"));
    }

    @Test
    public void invalidLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong@gmail.com", "wrong");
        Assert.assertTrue(lp.getErrorMessage().contains("incorrect"));
    }
}
