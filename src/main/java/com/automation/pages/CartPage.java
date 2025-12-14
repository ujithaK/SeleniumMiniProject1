package com.automation.pages;

import com.automation.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private static final String CART_PATH = "/cart";

    private By checkoutBtn = By.xpath("//*[@id=\"drawer\"]/div/form/div[2]/input");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(ConfigManager.getProperty("baseUrl") + CART_PATH);
    }


    public void clickCheckout() {
        open();
        driver.findElement(checkoutBtn).click();
    }
}

