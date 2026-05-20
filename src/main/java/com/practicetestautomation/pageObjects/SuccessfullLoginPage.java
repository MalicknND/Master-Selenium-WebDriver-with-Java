package com.practicetestautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SuccessfullLoginPage extends BasePage {
    private final By logoutBtnLocator = By.linkText("Log out");

    public SuccessfullLoginPage(WebDriver driver) {
        super(driver);
    }


    public boolean isLogoutBtnDisplayed() {
        return isDisplayed(logoutBtnLocator);
    }

    public void load(){
        wait.until(ExpectedConditions.urlToBe("https://practicetestautomation.com/logged-in-successfully/"));
        waitForElement(logoutBtnLocator);
    }
}
