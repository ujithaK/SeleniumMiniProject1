package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
            Files.copy(srcFile.toPath(), Paths.get(destPath));
            System.out.println("Screenshot saved at: " + destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
