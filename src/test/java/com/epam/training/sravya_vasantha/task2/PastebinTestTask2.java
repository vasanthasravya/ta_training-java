package com.epam.training.sravya_vasantha.task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastebinTestTask2 {

    private WebDriver driver;

    private final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n"
            + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
            + "git push origin master --force";

    private final String TITLE = "how to gain dominance among developers";
    private final String SYNTAX = "Bash";
    private final String EXPIRATION = "10 Minutes";

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void createPasteAndValidateDetails() {
        driver.get("https://pastebin.com");

        PastebinPageTask2 pastePage = new PastebinPageTask2(driver);
        pastePage.enterCode(CODE);
        pastePage.selectSyntaxHighlighting(SYNTAX);
        pastePage.selectExpiration(EXPIRATION);
        pastePage.enterTitle(TITLE);
        pastePage.submitPaste();

        // === Assertions ===
        // 1. Title
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains(TITLE), "Page title does not match paste title");

        // 2. Syntax highlighting (verify language label on the page)
        String actualSyntax = driver.findElement(By.cssSelector(".left .highlighted-code")).getAttribute("class");
        assertTrue(actualSyntax.contains("bash"), "Syntax highlighting is not Bash");

        // 3. Code content check
        String actualCode = driver.findElement(By.cssSelector("textarea")).getText();
        assertEquals(CODE, actualCode, "Code content does not match");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
