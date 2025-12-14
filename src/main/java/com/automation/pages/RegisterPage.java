
package com.automation.pages;

import com.automation.config.ConfigManager;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;
    private static final String Register_PATH = "/account/register";

    private By firstName=By.xpath("//*[@id=\"first_name\"]");
    private By lastName=By.xpath("//*[@id=\"last_name\"]");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By signInButton = By.xpath("//*[@id=\"create_customer\"]/div[6]/input");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(ConfigManager.getProperty("baseUrl") + Register_PATH);
    }

    public void register(String fn,String ln,String email, String password) {
        open();
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signInButton).click();
    }

}
