package com.vwologin.AutomationChallenge1;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ModelBox_Small {
    @Test
    public void modelsml() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);

        WebElement smallButton = driver.findElement(By.id("showSmallModal"));
        smallButton.click();

        WebElement ModalBoxText  = driver.findElement(By.className("modal-body"));
        String value = ModalBoxText.getText();
        System.out.println(value);
        // Expected text to verify
        String expectedText = "This is a small modal. It has very less content";

        // Assert that the actual text matches the expected text
        Assert.assertEquals(value, expectedText, "Text does not match!");

        WebElement ModalClose = driver.findElement(By.id("closeSmallModal"));
        ModalClose.click();

        driver.quit();
        }
    }