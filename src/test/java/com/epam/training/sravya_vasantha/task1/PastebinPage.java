package com.epam.training.sravya_vasantha.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinPage {
    private WebDriver driver;

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCode(String code) {
        driver.findElement(By.id("postform-text")).sendKeys(code);
    }

    public void selectExpiration() {
        WebElement dropdown = driver.findElement(By.id("select2-postform-expiration-container"));
        dropdown.click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();
    }

    public void enterTitle(String title) {
        driver.findElement(By.id("postform-name")).sendKeys(title);
    }

    public void submit() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
