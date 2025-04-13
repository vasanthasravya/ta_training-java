package com.epam.training.sravya_vasantha.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PastebinTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void createNewPaste() {
        driver.get("https://pastebin.com");

        PastebinPage page = new PastebinPage(driver);
        page.enterCode("Hello from WebDriver");
        page.selectExpiration();
        page.enterTitle("helloweb");
        page.submit();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
