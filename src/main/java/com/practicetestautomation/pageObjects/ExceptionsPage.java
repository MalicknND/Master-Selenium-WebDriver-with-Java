package com.practicetestautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ExceptionsPage extends BasePage {
    private final By addBtnLocator = By.id("add_btn");
    private final By editBtnLocator = By.id("edit_btn");
    private final By row2InputField = By.xpath("//div[@id='row2']/input");
    private final By row1InputField = By.xpath("//div[@id='row1']/input");
    private final By row2SaveBtn = By.xpath("//div[@id='row2']/button[@name='Save']");
    private final By row1SaveBtn = By.xpath("//div[@id='row1']/button[@name='Save']");
    private final By successMessageLocator = By.id("confirmation");
    private final By instructionsLocator = By.id("instructions");


    public ExceptionsPage(WebDriver driver) {
        super(driver);
    }

    public void visit(){
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void pushAddBtn(){
        driver.findElement(addBtnLocator).click();
    }

    public void pushEditBtn(){
        driver.findElement(editBtnLocator).click();
    }

    public boolean isRowTwoDisplayedAfterWait(){
        return waitForIsDisplayed(row2InputField);
    }

    public void enterFoodInRow2(String foodName){
        driver.findElement(row2InputField).sendKeys(foodName);
    }
    public void enterFoodInRow1(String foodName){
        WebElement row1Input = driver.findElement(row1InputField);
        row1Input.clear();
        row1Input.sendKeys(foodName);
    }

    public void saveRow2(){
        driver.findElement(row2SaveBtn).click();
    }
    public void saveRow1(){
        driver.findElement(row1SaveBtn).click();
    }

    public String successMessage(){
        return waitForElement(successMessageLocator).getText();
    }

    public boolean isInstructionsElementHiddenAfterWait(){
        return waitForIsHidden(instructionsLocator);
    }

}
