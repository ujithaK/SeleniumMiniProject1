package com.automation.pages;

import com.automation.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By email = By.id("email");
    private By password = By.id("password");
    private By createBtn = By.xpath("//*[@id=\"create_customer\"]/div[6]/input");

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait
    }

    // Open the registration page
    public void openRegisterPage() {
        driver.get(ConfigManager.getProperty("baseUrl") + ConfigManager.getProperty("registerPath"));
    }

    // Register method
    public void register(String fn, String ln, String em, String pw) {
        openRegisterPage();

        sendKeysWithFallback(firstName, fn);
        sendKeysWithFallback(lastName, ln);
        sendKeysWithFallback(email, em);
        sendKeysWithFallback(password, pw);

        clickElement(createBtn);
    }

    // Helper method to send keys safely
    private void sendKeysWithFallback(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        scrollIntoView(element);
        try {
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            // Fallback using JavaScript
            setValueByJS(element, value);
        }
    }

    // Helper method to click safely
    private void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        scrollIntoView(element);
        element.click();
    }

    // Scroll element into view
    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Fallback: set input value using JavaScript
    private void setValueByJS(WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", element, value);
    }
}
