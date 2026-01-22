package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.config.ConfigManager;
import com.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTests extends BaseTest {

    @Test
    public void completeE2EFlow() {

        // 1️⃣ Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigManager.getProperty("validUsername"),
                ConfigManager.getProperty("validPassword")
        );

        // 2️⃣ Add product to cart
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart();
        productsPage.openCart();

        // 3️⃣ Go to checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // Now just verify Delivery text appears on checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        boolean containsDelivery = driver.getPageSource().contains("Delivery");

        Assert.assertTrue(containsDelivery, "Checkout page does not contain 'Delivery'");

    }
}
