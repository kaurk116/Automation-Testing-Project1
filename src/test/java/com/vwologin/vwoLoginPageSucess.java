package com.vwologin;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class vwoLoginPageSucess {
    @Test
    public void vwo_Login() throws InterruptedException{
        EdgeOptions options =new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement EnterEmail =driver.findElement(By.id("login-username"));
        EnterEmail.sendKeys("kaurk161@gmail.com");

        WebElement EnterPassword =driver.findElement(By.id("login-password"));
        EnterPassword.sendKeys("Karamjeet@1990");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //click on sign-in button
        WebElement button =driver.findElement(By.id("js-login-btn"));
        button.click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/dashboard");
        driver.quit();
    }
}
