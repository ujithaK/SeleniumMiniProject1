package com.automation.tests;

import com.automation.base.BaseTest;

import com.automation.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void validRegister() {
        RegisterPage rg = new RegisterPage(driver);
        rg.register("uji","ujitha","uji1@gmail.com","uji123");
        Assert.assertTrue(driver.getCurrentUrl().contains("/account/register"));
    }
}
