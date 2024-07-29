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
import static java.util.concurrent.TimeUnit.*;

public class demoqa_table {
    @Test
    public void table() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);

        // Scroll down
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();


        WebElement editButton = driver.findElement(By.xpath("//span[@id=\"edit-record-3\"]"));
        editButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-form-modal")));

        WebElement modal = driver.findElement(By.id("registration-form-modal"));

        WebElement ageVerify = driver.findElement(By.xpath("//input[@placeholder=\"Age\"]"));
        String getValue = ageVerify.getAttribute("value");
        Assert.assertEquals("29", getValue);
        System.out.println(getValue);

        WebElement closeBtn = driver.findElement(By.xpath("//button[@class=\"close\"]"));
        closeBtn.click();

        driver.quit();
        }
    }