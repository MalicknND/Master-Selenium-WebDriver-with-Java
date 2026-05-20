package com.practicetestautomation.tests.login;

import com.practicetestautomation.pageObjects.LoginPage;
import com.practicetestautomation.pageObjects.SuccessfullLoginPage;
import com.practicetestautomation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;



public class LoginTests extends BaseTest {

    @Test(groups = {"positive", "regression", "smoke"})
    public void testLoginFunctionality() {

        logger.info("Start test login functionality");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        SuccessfullLoginPage successfullLoginPage = loginPage.executeLogin("student", "Password123");
        successfullLoginPage.load();

        logger.info("Verify the login functionality");
        Assert.assertEquals(successfullLoginPage.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/"); //sert à vérifier que deux valeurs sont identiques dans TestNG.

        Assert.assertTrue(successfullLoginPage.getPageSource().contains("Congratulations student. You successfully logged in!"));

        Assert.assertTrue(successfullLoginPage.isLogoutBtnDisplayed());
    }

    @Parameters({"username", "password", "expectedErrorMessage"})
    @Test(groups = {"negative", "regression"})
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {

        logger.info("Starting negative loging test");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        loginPage.executeLogin(username, password);
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
    }
}

