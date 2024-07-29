package com.vwologin.AutomationChallenge1;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class demoqa2_table {
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

        //verify name
        List<WebElement> verify = driver.findElements(By.xpath("//div[@class='rt-tr-group'][4]//div[@class=\"rt-td\"]"));
        for (WebElement element : verify) {
            String value = element.getText();
            System.out.println(value);
        }
    }
}