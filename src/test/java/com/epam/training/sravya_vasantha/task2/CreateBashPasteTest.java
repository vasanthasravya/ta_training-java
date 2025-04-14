package com.epam.training.sravya_vasantha.task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateBashPasteTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
    }

    @Test
    public void createBashPasteSuccessfully() {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String title = "how to gain dominance among developers";
        String syntax = "Bash";
        String expiration = "10 Minutes";

        PastebinHomePage homePage = new PastebinHomePage(driver);
        homePage.enterCode(code);
        homePage.selectSyntaxHighlighting(syntax);
        homePage.selectPasteExpiration(expiration);
        homePage.enterTitle(title);
        homePage.createPaste();

        // 🕒 Wait for the real paste page to load (Cloudflare workaround)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Just a moment...")));

        PastebinResultPage resultPage = new PastebinResultPage(driver);
        assertEquals(title, resultPage.getPageTitle());
        assertEquals(syntax, resultPage.getSyntaxHighlighting());
        assertEquals(code, resultPage.getPostedCode());
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
