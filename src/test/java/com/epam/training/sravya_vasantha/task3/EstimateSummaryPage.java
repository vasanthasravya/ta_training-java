package com.epam.training.sravya_vasantha.task3;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public class EstimateSummaryPage {
    private WebDriver driver;

    public EstimateSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentTabCostText() {
        String original = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String handle : windows) {
            if (!handle.equals(original)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return driver.getPageSource();
    }
}
