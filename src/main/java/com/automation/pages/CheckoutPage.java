package com.automation.pages;

import com.automation.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    private WebDriver driver;

    // Locators based on Shopify Checkout
    private By emailField = By.id("email");
    private By firstNameField = By.id("TextField0");
    private By lastNameField = By.id("TextField1");
    private By addressField = By.id("TextField2");
    private By cityField = By.id("TextField3");
    private By countryDropdown = By.id("Select0");
    private By stateDropdown = By.id("Select1");
    private By postalCodeField = By.id("TextField4");
    private By phoneField = By.id("TextField5");

    private By continueToShippingBtn = By.cssSelector("button[type='submit']");
    private By continueToPaymentBtn = By.cssSelector("button[type='submit']");
    private By payNowBtn = By.cssSelector("button[type='submit']"); // depends on gateway

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutDetails(String email, String fn, String ln, String addr,
                                     String city, String country, String zip, String phone) {

        WaitUtils.waitForVisibility(driver, emailField, 15).sendKeys(email);
        WaitUtils.waitForVisibility(driver, firstNameField, 10).sendKeys(fn);
        WaitUtils.waitForVisibility(driver, lastNameField, 10).sendKeys(ln);
        WaitUtils.waitForVisibility(driver, addressField, 10).sendKeys(addr);
        WaitUtils.waitForVisibility(driver, cityField, 10).sendKeys(city);

        // Country dropdown
        WebElement countryElem = WaitUtils.waitForVisibility(driver, countryDropdown, 10);
        new Select(countryElem).selectByVisibleText(country);

        // If country is India → select State
        if(country.equalsIgnoreCase("India")) {
            WebElement stateElem = WaitUtils.waitForVisibility(driver, stateDropdown, 10);
            new Select(stateElem).selectByIndex(1); // pick any or customize
        }

        WaitUtils.waitForVisibility(driver, postalCodeField, 10).sendKeys(zip);
        WaitUtils.waitForVisibility(driver, phoneField, 10).sendKeys(phone);
    }

    public void continueToShipping() {
        WaitUtils.waitForClickable(driver, continueToShippingBtn, 20).click();
    }

    public void continueToPayment() {
        WaitUtils.waitForClickable(driver, continueToPaymentBtn, 20).click();
    }

    public void payNow() {
        WaitUtils.waitForClickable(driver, payNowBtn, 20).click();
    }
}
