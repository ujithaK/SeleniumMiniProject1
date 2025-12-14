package com.automation.utils;

import com.automation.base.DriverFactory;

public class BrowserUtils {

    public static String getTitle() {
        return DriverFactory.getDriver().getTitle();
    }
}
