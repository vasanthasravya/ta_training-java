package com.epam.training.sravya_vasantha.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PastebinResultPage {
    private final WebDriver driver;

    public PastebinResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getSyntaxHighlighting() {
        return driver.findElement(By.xpath("//a[@class='btn -small h_800']")).getText();
    }

    public String getPostedCode() {
        return driver.findElement(By.xpath("//textarea")).getText();
    }
}
