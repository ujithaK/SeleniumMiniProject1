package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletePage {

    private WebDriver driver;

    private By successMsg = By.className("complete-header");

    public OrderCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }
}
