package com.epam.training.sravya_vasantha.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinHomePage {
    private final WebDriver driver;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCode(String code) {
        WebElement codeField = driver.findElement(By.id("postform-text"));
        codeField.sendKeys(code);
    }

    public void selectSyntaxHighlighting(String value) {
        driver.findElement(By.id("select2-postform-format-container")).click();
        WebElement bashOption = driver.findElement(By.xpath("//li[text()='" + value + "']"));
        bashOption.click();
    }

    public void selectPasteExpiration(String expiration) {
        driver.findElement(By.id("select2-postform-expiration-container")).click();
        WebElement expirationOption = driver.findElement(By.xpath("//li[text()='" + expiration + "']"));
        expirationOption.click();
    }

    public void enterTitle(String title) {
        WebElement titleField = driver.findElement(By.id("postform-name"));
        titleField.sendKeys(title);
    }

    public void createPaste() {
        driver.findElement(By.xpath("//button[text()='Create New Paste']")).click();
    }
}
