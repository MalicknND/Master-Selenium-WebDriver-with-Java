package com.practicetestautomation.tests.exceptions;

import com.practicetestautomation.pageObjects.ExceptionsPage;
import com.practicetestautomation.tests.BaseTest;
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


public class ExeptionsTests extends BaseTest {

    @Test
    public void noSuchElementExceptionTest() {
        logger.info("Starting noSuchElementExceptionTest");

        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.pushAddBtn();
        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void timeoutExceptionTest() {
        logger.info("Starting timeoutExceptionTest");

        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.pushAddBtn();
        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void elementNotInteractableExceptionTest() {
        logger.info("Starting elementNotInteractableExceptionTest");

        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.pushAddBtn();
        exceptionsPage.isRowTwoDisplayedAfterWait();
        exceptionsPage.enterFoodInRow2("Sushi");
        exceptionsPage.saveRow2();
        Assert.assertEquals(exceptionsPage.successMessage(), "Row 2 was saved", "Message is not expected");

    }

    @Test
    public void invalidElementStateExceptionTest() {
        logger.info("Starting elementNotInteractableExceptionTest");

        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.pushEditBtn();
        exceptionsPage.enterFoodInRow1("Sushi");
        exceptionsPage.saveRow1();
        Assert.assertEquals(exceptionsPage.successMessage(), "Row 1 was saved", "Message is not expected");

    }

    @Test
    public void staleElementReferenceExceptionTest() {
        logger.info("Starting staleElementReferenceExceptionTest");

        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.pushAddBtn();
        Assert.assertTrue(exceptionsPage.isInstructionsElementHiddenAfterWait(), "Instructions element is not hidden");

    }

}

