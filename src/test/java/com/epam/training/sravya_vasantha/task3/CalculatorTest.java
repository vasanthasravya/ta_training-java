package com.epam.training.sravya_vasantha.task3;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchPage;
    private CalculatorPage calculatorPage;
    private EstimateSummaryPage summaryPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        searchPage = new SearchResultsPage(driver);
        calculatorPage = new CalculatorPage(driver);
        summaryPage = new EstimateSummaryPage(driver);
    }

    @Test
    public void testGoogleCloudCalculator() {
        homePage.open();
        homePage.searchCalculator("Google Cloud Platform Pricing Calculator");
        searchPage.clickCalculatorLink();

        calculatorPage.switchToFrame();
        calculatorPage.fillForm();
        String estimatedCost = calculatorPage.getEstimatedCost();

        Assert.assertTrue("Cost should contain USD", estimatedCost.contains("USD"));
        calculatorPage.clickShare();
        calculatorPage.openEstimateSummary();

        String summaryText = summaryPage.getCurrentTabCostText();
        Assert.assertTrue(summaryText.contains("n1-standard-8"));
        Assert.assertTrue(summaryText.contains("Frankfurt"));
        Assert.assertTrue(summaryText.contains("1 Year"));
    }

    @After
    public void teardown() {
        if (driver != null) driver.quit();
    }
}
