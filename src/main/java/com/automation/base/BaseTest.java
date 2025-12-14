package com.automation.base;

import com.automation.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver(ConfigManager.getProperty("browser"));
        driver = DriverFactory.getDriver();
        driver.get(ConfigManager.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
