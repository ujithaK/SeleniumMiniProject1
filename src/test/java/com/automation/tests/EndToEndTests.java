package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.*;
import org.testng.annotations.Test;

public class EndToEndTests extends BaseTest {

    @Test
    public void completeE2EFlow() {
        new LoginPage(driver).login("uji@gmail.com", "uji@123");
        ProductsPage pp = new ProductsPage(driver);
        pp.addProductToCart();
        pp.openCart();
        new CartPage(driver).clickCheckout();

        CheckoutPage cp = new CheckoutPage(driver);
        cp.enterDetails("Ujitha", "QA", "600001");
        cp.finishCheckout();
    }
}
