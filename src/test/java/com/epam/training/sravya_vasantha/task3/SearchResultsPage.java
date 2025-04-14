package com.epam.training.sravya_vasantha.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCalculatorLink() {
        driver.findElement(By.xpath("//a[contains(text(),'Google Cloud Pricing Calculator')]")).click();
    }
}
