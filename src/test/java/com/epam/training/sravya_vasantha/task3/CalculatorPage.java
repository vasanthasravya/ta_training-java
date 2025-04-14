package com.epam.training.sravya_vasantha.task3;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CalculatorPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void switchToFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@src, '/products/calculator')]")));
        driver.switchTo().frame(0); // nested frame
    }

    public void fillForm() {
        driver.findElement(By.xpath("//md-tab-item/div[text()='Compute Engine']")).click();

        driver.findElement(By.name("quantity")).sendKeys("4");
        selectDropdown("Operating System / Software", "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL");
        selectDropdown("Provisioning model", "Regular");
        selectDropdown("Machine Family", "General purpose");
        selectDropdown("Series", "N1");
        selectDropdown("Machine type", "n1-standard-8");

        driver.findElement(By.xpath("//md-checkbox[@aria-label='Add GPUs']")).click();
        selectDropdown("GPU type", "NVIDIA Tesla V100");
        selectDropdown("Number of GPUs", "1");

        selectDropdown("Local SSD", "2x375 GB");
        selectDropdown("Datacenter location", "Frankfurt (europe-west3)");
        selectDropdown("Committed usage", "1 Year");

        driver.findElement(By.xpath("//button[@aria-label='Add to Estimate']")).click();
    }

    private void selectDropdown(String label, String value) {
        driver.findElement(By.xpath("//label[contains(text(),'" + label + "')]/following-sibling::md-select")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option/div[contains(text(),'" + value + "')]"))).click();
    }

    public String getEstimatedCost() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//b[contains(text(),'Total Estimated Cost')]")
        )).getText();
    }

    public void clickShare() {
        driver.findElement(By.xpath("//button[@id='Email Estimate']")).click();
    }

    public void openEstimateSummary() {
        driver.findElement(By.xpath("//button[contains(text(),'Open estimate summary')]")).click();
    }
}
