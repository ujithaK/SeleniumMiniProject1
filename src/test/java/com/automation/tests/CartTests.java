package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.*;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void cartCheckoutTest() {
        new LoginPage(driver).login("uji@gmail.com", "uji@123");
        new CartPage(driver).clickCheckout();
    }
}
