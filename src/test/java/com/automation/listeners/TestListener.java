package com.automation.listeners;

import com.automation.base.BaseTest;
import com.automation.utils.ScreenshotUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        // Get the WebDriver instance from the test class
        Object testClass = result.getInstance();
        if (testClass instanceof BaseTest) {
            BaseTest base = (BaseTest) testClass;
            ScreenshotUtils.takeScreenshot(base.getDriver(), result.getName());
        }
    }
}
