package com.epam.training.sravya_vasantha.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By searchButton = By.cssSelector("button[aria-label='Search']");
    private By searchInput = By.name("q");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void open() {
        driver.get("https://cloud.google.com/");
    }

    public void searchCalculator(String searchTerm) {
        driver.get("https://cloud.google.com/");

        // Click search icon first
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        // Now wait for input field to appear
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        input.sendKeys(searchTerm);
        input.sendKeys(Keys.ENTER);
    }
}
