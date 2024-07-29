package com.vwologin.AutomationChallenge1;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        // Create an instance of JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by pixels
        js.executeScript("window.scrollBy(0,1000)");



        WebElement editButton = driver.findElement(By.xpath("//span[@id=\"edit-record-3\"]"));
        editButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registration-form-modal")));

        WebElement modal = driver.findElement(By.id("registration-form-modal"));

        WebElement ageVerify = driver.findElement(By.xpath("//input[@placeholder=\"Age\"]"));
        String getValue = ageVerify.getAttribute("value");
        Assert.assertEquals("29", getValue);
        ////input[@placeholder="Age"]
        WebElement closeBtn = driver.findElement(By.xpath("//button[@class=\"close\"]"));
        closeBtn.click();
        WebElement addbtn = driver.findElement(By.xpath("//button[@id=\"addNewRecordButton\"]"));
        addbtn.click();
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
        WebElement modelBox = driver.findElement(By.xpath("//div[@class=\"modal-content\"]"));
        //First Name
        WebElement firstName = driver.findElement(By.xpath("//input[@id=\"firstName\"]"));
        firstName.clear();
        firstName.sendKeys("Anavia");
        //lastName
        WebElement lastName = driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
        lastName.clear();
        lastName.sendKeys("Saini");
        //Email
        WebElement email = driver.findElement(By.xpath("//input[@id=\"userEmail\"]"));
        email.clear();
        email.sendKeys("kaurk161@gmail.com");
        //Age
        WebElement age = driver.findElement(By.xpath("//input[@id=\"age\"]"));
        age.clear();
        age.sendKeys("5");
        //Salary
        WebElement salary = driver.findElement(By.xpath("//input[@id=\"salary\"]"));
        salary.clear();
        salary.sendKeys("100000");
        //Department
        WebElement department = driver.findElement(By.xpath("//input[@id=\"department\"]"));
        department.clear();
        department.sendKeys("IT");
        //submit
        WebElement submitbtn = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
        submitbtn.click();

        //close model box
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
        /*WebElement close2 = driver.findElement(By.xpath("//button[@class=\"close\"]"));
        close2.click();*/
        //verify name
        List<WebElement> verify = driver.findElements(By.xpath("//div[@class='rt-tr-group'][4]//div[@class=\"rt-td\"]"));
        for (WebElement element : verify) {
            String value = element.getText();
            System.out.println(value);
            Assert.assertEquals("Anavia", verify);
        }
    }
}