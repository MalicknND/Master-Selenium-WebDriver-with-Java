package com.practicetestautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessfullLoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By logoutBtnLocator = By.linkText("Log out");

    public SuccessfullLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public boolean isLogoutBtnDisplayed() {
        try {
            return driver.findElement(logoutBtnLocator).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
