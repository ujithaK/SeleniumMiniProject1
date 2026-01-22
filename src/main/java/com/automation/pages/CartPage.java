package com.automation.pages;

import com.automation.config.ConfigManager;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;
    private static final String CART_PATH = "/cart";
    private static final int TIMEOUT = 20; // seconds

    private By checkoutBtn = By.name("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(ConfigManager.getProperty("baseUrl") + CART_PATH);
    }

    public void clickCheckout() {
        // Wait until checkout button is clickable
        WebElement checkoutElement = WaitUtils.waitForClickable(driver, checkoutBtn, TIMEOUT);

        // Scroll button into view to avoid overlay issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", checkoutElement);

        // Click the checkout button
        checkoutElement.click();
    }

    public void clickCheckoutFromDrawer() {
        By drawerCheckoutBtn = By.cssSelector("button[name='checkout']");
        WebElement checkoutElement = WaitUtils.waitForClickable(driver, drawerCheckoutBtn, TIMEOUT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", checkoutElement);
        checkoutElement.click();
    }
}
