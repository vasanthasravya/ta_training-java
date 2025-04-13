package com.epam.training.sravya_vasantha.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinPageTask2 {
    private WebDriver driver;

    public PastebinPageTask2(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCode(String code) {
        driver.findElement(By.id("postform-text")).sendKeys(code);
    }

    public void selectSyntaxHighlighting(String syntax) {
        driver.findElement(By.id("select2-postform-format-container")).click();
        driver.findElement(By.xpath("//li[text()='" + syntax + "']")).click();
    }

    public void selectExpiration(String value) {
        driver.findElement(By.id("select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[text()='" + value + "']")).click();
    }

    public void enterTitle(String title) {
        driver.findElement(By.id("postform-name")).sendKeys(title);
    }

    public void submitPaste() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
