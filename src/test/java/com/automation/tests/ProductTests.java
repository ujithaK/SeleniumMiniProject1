package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test
    public void addProductTest() {
        // 1️⃣ Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("uji@gmail.com", "uji@123");

        // 2️⃣ Add product to cart
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart();

        // 3️⃣ Open cart and assert
        productsPage.openCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("/products"));
    }
}
