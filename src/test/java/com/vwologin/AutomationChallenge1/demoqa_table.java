package com.vwologin.AutomationChallenge1;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import static java.util.concurrent.TimeUnit.*;
import static org.testng.Assert.*;

public class demoqa_table {
    EdgeDriver driver;
    @BeforeTest

    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }
       @Test
        public void TestTableModelBox() {
           driver.get("https://demoqa.com/webtables");
           driver.manage().window().maximize();
           driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
           // Scroll down
           Actions actions = new Actions(driver);
           actions.sendKeys(Keys.PAGE_DOWN).build().perform();
           driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
           WebElement editButton = driver.findElement(By.xpath("//span[@id=\"edit-record-3\"]"));
           editButton.click();
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-form-modal")));
           WebElement modal = driver.findElement(By.id("registration-form-modal"));
           WebElement ageVerify = driver.findElement(By.xpath("//input[@placeholder=\"Age\"]"));
           // Get the value of the element
           String ActualValue = ageVerify.getAttribute("value");
           // Define the expected value
           String ExpectedValue = "29";
           // Assert that the actual value matches the expected value
           Assert.assertEquals(ActualValue, ExpectedValue, "Value matched");
           Assert.assertTrue(ageVerify.isDisplayed(), "Element is displayed");
           WebElement closeBtn = driver.findElement(By.xpath("//button[@class=\"close\"]"));
           closeBtn.click();
       }
       public void closeBrowser(){
        driver.quit();
        }
    }