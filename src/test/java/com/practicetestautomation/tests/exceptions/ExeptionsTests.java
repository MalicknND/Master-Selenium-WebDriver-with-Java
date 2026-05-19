package com.practicetestautomation.tests.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExeptionsTests {
    private WebDriver driver;
    private Logger logger;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {

        logger = Logger.getLogger(ExeptionsTests.class.getName());
        logger.setLevel(Level.INFO);

        logger.info("Running test in : " + browser);
        // Open page

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                logger.warning("Config missing for browser: " + browser);
                driver = new ChromeDriver();
                break;
        }

        // Implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        logger.info("Browser Closed");
    }


    @Test
    public void noSuchElementExceptionTest() {
        logger.info("Starting noSuchElementExceptionTest");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addBtn = driver.findElement(By.id("add_btn"));
        addBtn.click();

        WebElement rowToInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
        Assert.assertTrue(rowToInputField.isDisplayed(), "Row 2 input field is not displayed");
    }

    @Test
    public void timeoutExceptionTest() {
        logger.info("Starting timeoutExceptionTest");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement addBtn = driver.findElement(By.id("add_btn"));
        addBtn.click();

        WebElement rowToInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
        Assert.assertTrue(rowToInputField.isDisplayed(), "Row 2 input field is not displayed");
    }

}

