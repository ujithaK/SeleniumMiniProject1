package com.automation.pages;

import com.automation.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class    ProductsPage {

    private WebDriver driver;
    private static final String PRODUCT_PATH = "/collections/all";

    private By clickheels=By.xpath("//*[@id=\"product-1\"]/img");
    private By addHeels = By.id("add");
    private By cartIcon = By.xpath("//*[@id=\"minicart\"]/a[1]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void open() {
        driver.get(ConfigManager.getProperty("baseUrl") + PRODUCT_PATH);
    }
    public void addProductToCart() {
        open();
        driver.findElement(clickheels).click();
        driver.findElement(addHeels).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
