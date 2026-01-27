package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.config.ConfigManager;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import com.automation.utils.TestListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(TestListener.class)
public class ProductTests extends BaseTest {

    private String email= ConfigManager.getProperty("validUsername");
    private String pswd= ConfigManager.getProperty("validPassword");



    @Test
    public void addProductTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, pswd);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart();

        productsPage.openCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("/products"));
    }

    @Test
    public void searchProductTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, pswd);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.searchProduct("shirt");

        int resultsCount = driver.findElements(By.cssSelector("li.grid__item")).size();
        Assert.assertTrue(resultsCount > 0, " No search results found for 'shirt'");
    }
}
