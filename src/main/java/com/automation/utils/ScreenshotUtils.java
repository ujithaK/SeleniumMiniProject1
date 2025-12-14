package com.automation.utils;

import com.automation.base.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class ScreenshotUtils {

    public static String takeScreenshot(String name) {
        try {
            File src = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);
            String path = "C:\\Users\\Ujitha K\\Pictures\\Screenshots/" + name + ".png";
            FileUtils.copyFile(src, new File(path));
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}
