package com.vwologin.AutomationChallenge1;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ModelBox_Small {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }
        @Test
        public void TestModelBox(){
        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);

        WebElement smallButton = driver.findElement(By.id("showSmallModal"));
        smallButton.click();

        WebElement ModalBoxText  = driver.findElement(By.className("modal-body"));
        //Assert Type Actual and Expected
        String ActualText = ModalBoxText.getText();
        String ExpectedText = "This is a small modal. It has very less content";
        Assert.assertEquals(ActualText,ExpectedText,"matched");

        System.out.println(ActualText);
        //Assert Type True
       Assert.assertTrue(ModalBoxText.isDisplayed(),"Displayed Matched");
       Assert.assertTrue(ModalBoxText.isEnabled(), String.valueOf(true));


        WebElement ModalClose = driver.findElement(By.className("close"));
        ModalClose.click();
         }
         @AfterTest
         public void closeBrowser(){
        driver.quit();
        }
    }