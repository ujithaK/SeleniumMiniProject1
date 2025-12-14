package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutFlowTest() {
        new LoginPage(driver).login("uji@gmail.com", "uji@123");
        ProductsPage pp = new ProductsPage(driver);
        pp.addProductToCart();
        pp.openCart();

        new CartPage(driver).clickCheckout();
        CheckoutPage cp = new CheckoutPage(driver);
        cp.enterDetails("ujitha", "k", "500001");
        cp.finishCheckout();

        Assert.assertTrue(new OrderCompletePage(driver)
                .getSuccessMessage().contains("Thank you"));
    }
}
