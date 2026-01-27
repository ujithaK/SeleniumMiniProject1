package com.automation.pages;

import com.automation.config.ConfigManager;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage {

    private WebDriver driver;
    private static final String PRODUCT_PATH = "/collections/all";
    private static final int TIMEOUT = 20; // seconds

    private By productItem = By.xpath("//*[@id=\"product-1\"]/img"); // clickable link of product
    private By addToCart = By.id("add");
    private By cartIcon = By.xpath("//*[@id=\"minicart\"]/a[1]");
    private By searchIcon = By.cssSelector("button.search-modal__toggle");
    private By searchInput = By.cssSelector("input.search__input");
    private By searchSubmit = By.cssSelector("button.search__button");
    private By searchResultItems = By.cssSelector("li.grid__item"); // search result product cards


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(ConfigManager.getProperty("baseUrl") + PRODUCT_PATH);
        WaitUtils.waitForUrlContains(driver, PRODUCT_PATH, TIMEOUT);
    }

    public void addProductToCart() {
        open();

        // Wait for product link to be visible
        WebElement prod = WaitUtils.waitForVisibility(driver, productItem, TIMEOUT);

        // Scroll into view and hover
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", prod);
        new Actions(driver).moveToElement(prod).perform();

        // Click the product
        prod.click();

        // Wait for Add to Cart button to be clickable
        WebElement addBtn = WaitUtils.waitForClickable(driver, addToCart, TIMEOUT);

        // Scroll into view and click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addBtn);
        addBtn.click();
    }

    public void searchProduct(String productName) {
        // Click Search Icon
        WebElement searchBtn = WaitUtils.waitForClickable(driver, searchIcon, TIMEOUT);
        searchBtn.click();

        // Wait for Search Input
        WebElement searchField = WaitUtils.waitForVisibility(driver, searchInput, TIMEOUT);
        searchField.sendKeys(productName);

        // Click Submit
        WebElement submitBtn = WaitUtils.waitForClickable(driver, searchSubmit, TIMEOUT);
        submitBtn.click();

        // Wait for Results Page
        WaitUtils.waitForVisibility(driver, searchResultItems, TIMEOUT);
    }

    public void openCart() {
        WebElement cart = WaitUtils.waitForClickable(driver, cartIcon, TIMEOUT);
        cart.click();
    }
}
