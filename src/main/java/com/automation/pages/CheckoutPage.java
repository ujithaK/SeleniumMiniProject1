package com.automation.pages;

import com.automation.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    private WebDriver driver;
    private  static final  String Check_URL="/checkouts/cn/hWN6QDJIdFP6RDE6MhFpKnFk/en-sg?_r=AQABObiNSHbRASxScQ5WwHsYfBKFtJPOmPS4t_KLqTSUy3w";

    private  By loc=By.id("Select2222");
    private By firstName = By.id("TextField7125");
    private By lastName = By.id("TextField7126");
    private By postalCode = By.id("TextField35");
    private By finishBtn = By.id("checkout-pay-button");

    public void open() {
        driver.get(ConfigManager.getProperty("baseUrl") + Check_URL);
    }

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String fn, String ln, String zip) {
        Select select=new Select(driver.findElement(loc));
        select.selectByVisibleText("India");
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void finishCheckout() {
        driver.findElement(finishBtn).click();
    }
}
