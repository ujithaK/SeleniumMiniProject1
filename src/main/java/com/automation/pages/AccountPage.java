package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By orderHistorySection = By.id("orderHistory"); // update if locator differs
    private By ordersList = By.cssSelector(".order-item"); // example selector
    private By profileEmail = By.id("profileEmail"); // update if locator differs
    private By editProfileButton = By.id("editProfile");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isOrderHistorySectionVisible() {
        try {
            WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(orderHistorySection));
            return section.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasOrders() {
        try {
            List<WebElement> orders = driver.findElements(ordersList);
            return !orders.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public void goToEditProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'addresses') or contains(text(),'Edit')]")
        ));

        editBtn.click();
    }


    public String getProfileEmail() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileEmail)).getText();
    }
}
