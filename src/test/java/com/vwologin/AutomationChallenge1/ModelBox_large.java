package com.vwologin.AutomationChallenge1;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ModelBox_large {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }
        @Test
        public void testModelBoxLarge() {
        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            // Scroll down
            Actions actions =new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement smallButton = driver.findElement(By.id("showLargeModal"));
        smallButton.click();

        WebElement ModalBoxText = driver.findElement(By.className("modal-body"));
        //Assert Type Actual and Expected
        String ActualText = ModalBoxText.getText();
        String ExpectedText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        Assert.assertEquals(ActualText,ExpectedText, "Text Matched");

        //Assert Type True
        Assert.assertTrue(ModalBoxText.isDisplayed(), "Displayed Matched");
        Assert.assertTrue(ModalBoxText.isEnabled(), String.valueOf(true));
        Assert.assertNotNull(ModalBoxText.getText(), "Not null");
        // Expected text to verify

        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
        WebElement ModalClose = driver.findElement(By.className("close"));
        ModalClose.click();
    }
        @AfterTest
        public void closeBrowser(){
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            driver.quit();
        }
    }