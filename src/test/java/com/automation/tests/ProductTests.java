package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test
    public void addProductTest() {
        new LoginPage(driver).login("uji@gmail.com", "uji@123");
        new ProductsPage(driver).addProductToCart();
    }
}
