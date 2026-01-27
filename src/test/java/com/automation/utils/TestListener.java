package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestListener implements ITestListener {

    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        Object testClass = result.getInstance();
        try {
            // Access 'driver' from BaseTest superclass
            Field driverField = testClass.getClass().getSuperclass().getDeclaredField("driver");
            driverField.setAccessible(true);
            driver = (WebDriver) driverField.get(testClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = null;

        try {
            // First try to get driver via getter method
            Method getDriverMethod = testClass.getClass().getMethod("getDriver");
            driver = (WebDriver) getDriverMethod.invoke(testClass);
        } catch (Exception e) {
            // Fallback: access the driver field directly from BaseTest
            try {
                Field driverField = testClass.getClass().getSuperclass().getDeclaredField("driver");
                driverField.setAccessible(true);
                driver = (WebDriver) driverField.get(testClass);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (driver != null) {
            ScreenshotUtils.takeScreenshot(driver, result.getName());
        } else {
            System.out.println("⚠ Driver is null, screenshot not captured");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) { }

    @Override
    public void onFinish(ITestContext context) { }
}
