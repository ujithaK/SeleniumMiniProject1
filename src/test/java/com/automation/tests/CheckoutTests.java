package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.config.ConfigManager;
import com.automation.pages.*;
import com.automation.utils.TestListener;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListener.class)
public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutFlowTest() {

        // Login
        new LoginPage(driver)
                .login(ConfigManager.getProperty("validUsername"), ConfigManager.getProperty("validPassword"));

        // Add product & go checkout
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart();
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // Now just verify Delivery text appears on checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        boolean containsDelivery = driver.getPageSource().contains("Delivery");

        Assert.assertTrue(containsDelivery, "Checkout page does not contain 'Delivery'");

        // Test Ends Here (Passes if Delivery is found)
    }

}
