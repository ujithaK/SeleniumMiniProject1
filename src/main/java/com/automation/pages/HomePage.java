package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By loginButton = By.cssSelector("a[href*='login']"); // update selector if needed

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://sauce-demo.myshopify.com"); // ensure loads homepage
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
